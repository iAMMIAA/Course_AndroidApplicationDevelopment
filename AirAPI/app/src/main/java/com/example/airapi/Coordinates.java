package com.example.airapi;

import com.google.gson.annotations.SerializedName;

public class Coordinates {
    @SerializedName("lon")
    private double longtitude;
    @SerializedName("lat")
    private double latiture;
    public double getLongtitude() {return longtitude;}
    public double getLatiture() {return latiture;}
}
