package com.example.myapplication.Model;

public class Women {

    int womenImg;
    String womenCompany,womenPrice;

    public Women(int womenImg, String womenCompany, String womenPrice) {
        this.womenImg = womenImg;
        this.womenCompany = womenCompany;
        this.womenPrice = womenPrice;
    }

    public int getWomenImg() {
        return womenImg;
    }

    public void setWomenImg(int womenImg) {
        this.womenImg = womenImg;
    }

    public String getWomenCompany() {
        return womenCompany;
    }

    public void setWomenCompany(String womenCompany) {
        this.womenCompany = womenCompany;
    }

    public String getWomenPrice() {
        return womenPrice;
    }

    public void setWomenPrice(String womenPrice) {
        this.womenPrice = womenPrice;
    }
}
