package com.example.tuitionz;

public class DepartmentModal {
    int Dimage;
    String subject;
    float Drating;

    public DepartmentModal(int dimage, String subject, float drating) {
        Dimage = dimage;
        this.subject = subject;
        Drating = drating;
    }

    public int getDimage() {
        return Dimage;
    }

    public void setDimage(int dimage) {
        Dimage = dimage;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public float getDrating() {
        return Drating;
    }

    public void setDrating(float drating) {
        Drating = drating;
    }
}
