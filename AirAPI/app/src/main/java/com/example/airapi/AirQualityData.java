package com.example.airapi;

import com.google.gson.annotations.SerializedName;

public class AirQualityData {
    @SerializedName("dt")
    private long timestamp;
    @SerializedName("main")
    private Main main;
    @SerializedName("components")
    private Components components;

    public Main getMain() {
        return main;
    }

    public Components getComponents() {
        return components;
    }
}
