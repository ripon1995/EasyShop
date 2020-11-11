package com.example.myapplication.Model;

public class Medicines {

    String medName;
    String medCompany;
    String medPrice;

    public Medicines(String name, String company,String medPrice) {
        this.medName = name;
        this.medCompany = company;
        this.medPrice=medPrice;
    }

    public String getName() {
        return medName;
    }

    public void setName(String name) {
        this.medName = name;
    }

    public String getCompanyName() {
        return medCompany;
    }

    public void setCell(String company) {
        this.medCompany = company;
    }

    public void setMedPrice(String medPrice)
    {
        this.medPrice=medPrice;
    }
    public String getMedPrice()
    {
        return medPrice;
    }

}
