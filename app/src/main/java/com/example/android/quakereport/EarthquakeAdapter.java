package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Christian PC on 30/03/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> EarthquakeAdapter) {
        super(context, 0, EarthquakeAdapter);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items, parent, false);
        }

        Earthquake currentValue = getItem(position);

        //MAGNITUDE

        // Find magnitude view
        TextView magTextView = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        // Decimal formatter
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        // Get and set magnitude
        String magnitude = magnitudeFormat.format(currentValue.getMagnitude());
        magTextView.setText(magnitude);

        //MAGNITUDE Color
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentValue.getMagnitude());
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        //LOCATION

        // Get location String
        String location = currentValue.getLocation();

        String primaryLocation;
        String locationOffset;

        if (location.contains(LOCATION_SEPARATOR)) {
            String[] parts = location.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = "Near the";
            primaryLocation = location;
        }

        TextView offsetTextView = (TextView) listItemView.findViewById(R.id.location_offset_text_view);
        offsetTextView.setText(locationOffset);
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.primary_location_text_view);
        locationTextView.setText(primaryLocation);


        //DATE

        // Create Date object
        Date dateObject = new Date(currentValue.getDateInMilliseconds());

        // Find date view
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        // Date formatter
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);
        // Display date
        dateTextView.setText(dateToDisplay);

        //TIME

        // Find time view
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text_view);
        // Time formatter
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String TimeToDisplay = timeFormatter.format(dateObject);
        // Display time
        timeTextView.setText(TimeToDisplay);

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
