package com.example.android.quakereport;

/**
 * Created by Christian PC on 30/03/2017.
 */

public class Earthquake {

    // Magnitude variable
    private double mMagnitude;

    // Location
    private String mLocation;

    // Date
    private String mDate;

    public Earthquake (double magnitude, String location, String date) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    //get Magnited
    public double getMagnitude () {
        return mMagnitude;
    }

    // get Location
    public String getLocation () {
        return mLocation;
    }

    //get Date
    public String getDate () {
        return mDate;
    }

}
