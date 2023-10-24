package com.example.userinterface;

public class ColorItem {
    private String colorName;
    private String backgroundColor;

    public  ColorItem(String colorName, String backgroundColor){
        this.colorName = colorName;
        this.backgroundColor = backgroundColor;
    }

    public String getColorName(){
        return colorName;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
