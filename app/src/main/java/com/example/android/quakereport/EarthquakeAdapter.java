package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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

        TextView magTextView = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        double mag = currentValue.getMagnitude();
        String mag2 = new Double(mag).toString();
        magTextView.setText(mag2);

        TextView placeTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
        placeTextView.setText(currentValue.getLocation());

        TextView dateTextView = (TextView)  listItemView.findViewById(R.id.date_text_view);
        dateTextView.setText(currentValue.getDate());

        return listItemView;
    }
}
