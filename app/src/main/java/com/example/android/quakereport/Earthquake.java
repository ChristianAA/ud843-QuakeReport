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
    private long mDateInMilliseconds;

    public Earthquake (double magnitude, String location, long dateInMilliseconds) {
        mMagnitude = magnitude;
        mLocation = location;
        mDateInMilliseconds = dateInMilliseconds;
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
    public long getDateInMilliseconds () {
        return mDateInMilliseconds;
    }

}
