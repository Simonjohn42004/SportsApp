package com.example.sportsapp;

public class SportsClass {
    private int sportimage;
    private String sportname;

    public SportsClass(int sportimage, String sportname) {
        setSportimage(sportimage);

        setSportname(sportname);
    }

    public int getSportimage() {
        return sportimage;
    }

    public void setSportimage(int sportimage) {
        this.sportimage = sportimage;
    }

    public String getSportname() {
        return sportname;
    }

    public void setSportname(String sportname) {
        this.sportname = sportname;
    }
}
