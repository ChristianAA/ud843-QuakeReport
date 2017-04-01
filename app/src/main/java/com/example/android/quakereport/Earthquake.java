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

    // URL

    private String mUrl;

    public Earthquake (double magnitude, String location, long dateInMilliseconds, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mDateInMilliseconds = dateInMilliseconds;
        mUrl = url;
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

    //get url
    public String getUrl () {
        return mUrl;
    }

}
