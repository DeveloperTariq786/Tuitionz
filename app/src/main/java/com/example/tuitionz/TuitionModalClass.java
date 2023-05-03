package com.example.tuitionz;

public class TuitionModalClass {
    int TuitionImage;
    String Address;
    float Rating;

    public TuitionModalClass(int tuitionImage, String address, float rating) {
        TuitionImage = tuitionImage;
        Address = address;
        Rating = rating;
    }

    public int getTuitionImage() {
        return TuitionImage;
    }

    public void setTuitionImage(int tuitionImage) {
        TuitionImage = tuitionImage;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public float getRating() {
        return Rating;
    }

    public void setRating(float rating) {
        Rating = rating;
    }
}
