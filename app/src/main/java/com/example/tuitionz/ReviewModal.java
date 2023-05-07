package com.example.tuitionz;

public class ReviewModal {
    String Review;
    float TutRate;



    public ReviewModal(String review, float tutRate) {
        Review = review;
        TutRate = tutRate;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }

    public float getTutRate() {
        return TutRate;
    }

    public void setTutRate(float tutRate) {
        TutRate = tutRate;
    }
}
