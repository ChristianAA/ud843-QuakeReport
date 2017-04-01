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

        // Set Location
        TextView placeTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
        placeTextView.setText(currentValue.getLocation());


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
