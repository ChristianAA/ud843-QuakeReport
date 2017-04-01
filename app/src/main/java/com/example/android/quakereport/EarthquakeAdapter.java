package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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

        // Set Magnitude
        TextView magTextView = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        double mag = currentValue.getMagnitude();
        String mag2 = new Double(mag).toString();
        magTextView.setText(mag2);

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


        // Create Date object
        Date dateObject = new Date(currentValue.getDateInMilliseconds());

        // Find date view
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        // Date formatter
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);
        // Display date
        dateTextView.setText(dateToDisplay);


        // Find time view
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text_view);
        // Time formatter
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String TimeToDisplay = timeFormatter.format(dateObject);
        // Display time
        timeTextView.setText(TimeToDisplay);

        return listItemView;
    }
}
