package com.example.userinterface;

public class c_YourDataModel {
    private String title;
    private String imageUrl;

    public c_YourDataModel(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
