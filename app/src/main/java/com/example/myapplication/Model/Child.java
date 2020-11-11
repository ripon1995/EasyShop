package com.example.myapplication.Model;

public class Child {

    int childPic;
    String childCompany,childPrice;

    public Child(int childPic, String childCompany, String childPrice) {
        this.childPic = childPic;
        this.childCompany = childCompany;
        this.childPrice = childPrice;
    }

    public int getChildPic() {
        return childPic;
    }

    public void setChildPic(int childPic) {
        this.childPic = childPic;
    }

    public String getChildCompany() {
        return childCompany;
    }

    public void setChildCompany(String childCompany) {
        this.childCompany = childCompany;
    }

    public String getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(String childPrice) {
        this.childPrice = childPrice;
    }
}
