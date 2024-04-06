package com.example.prj.companydetails.entity;

public class Focuslist {

    int UserID ;
    String stockNumber;
    String fullName;

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Focuslist{" +
                "UserID=" + UserID +
                ", stockNumber='" + stockNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
