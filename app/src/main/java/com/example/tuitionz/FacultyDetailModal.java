package com.example.tuitionz;

public class FacultyDetailModal {
    String fname;
    String freview;
    int fimage;
    float frating;

    public FacultyDetailModal(String fname, String freview, int fimage, float frating) {
        this.fname = fname;
        this.freview = freview;
        this.fimage = fimage;
        this.frating = frating;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFreview() {
        return freview;
    }

    public void setFreview(String freview) {
        this.freview = freview;
    }

    public int getFimage() {
        return fimage;
    }

    public void setFimage(int fimage) {
        this.fimage = fimage;
    }

    public float getFrating() {
        return frating;
    }

    public void setFrating(float frating) {
        this.frating = frating;
    }
}
