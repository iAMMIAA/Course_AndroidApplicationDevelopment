package com.example.airapi;

import com.google.gson.annotations.SerializedName;

public class Components {
    @SerializedName("co")
    private double co;

    @SerializedName("no")
    private double no;

    @SerializedName("no2")
    private double no2;

    @SerializedName("o3")
    private double o3;

    @SerializedName("so2")
    private double so2;

    @SerializedName("pm2_5")
    private double pm2_5;

    @SerializedName("pm10")
    private double pm10;

    @SerializedName("nh3")
    private double nh3;

    // Thêm các trường dữ liệu khác tương tự

    public double getCo() {
        return co;
    }

    public double getNo() {
        return no;
    }

    public double getNo2() {
        return no2;
    }

    public double getO3() {
        return o3;
    }

    public double getSo2() {
        return so2;
    }

    public double getPm2_5() {
        return pm2_5;
    }

    public double getPm10() {
        return pm10;
    }
    public double getNh3() {
        return nh3;
    }
    // Thêm các getter cho các trường dữ liệu khác
}
