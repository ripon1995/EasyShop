package com.example.myapplication.Model;

public class Protective {
    int imgProtective;
    String protectiveCompany,protectivePrice;

    public Protective(int imgProtective, String protectiveCompany, String protectivePrice) {
        this.imgProtective = imgProtective;
        this.protectiveCompany = protectiveCompany;
        this.protectivePrice = protectivePrice;
    }

    public int getImgProtective() {
        return imgProtective;
    }

    public void setImgProtective(int imgProtective) {
        this.imgProtective = imgProtective;
    }

    public String getProtectiveCompany() {
        return protectiveCompany;
    }

    public void setProtectiveCompany(String protectiveCompany) {
        this.protectiveCompany = protectiveCompany;
    }

    public String getProtectivePrice() {
        return protectivePrice;
    }

    public void setProtectivePrice(String protectivePrice) {
        this.protectivePrice = protectivePrice;
    }
}
