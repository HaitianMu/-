package com.example.prj.companydetails.entity;

public class detailpost {
     public String getFullName() {
          return fullName;
     }

     public void setFullName(String fullName) {
          this.fullName = fullName;
     }

     public int getUserID() {
          return UserID;
     }

     public void setUserID(int userID) {
          UserID = userID;
     }

     @Override
     public String toString() {
          return "detailpost{" +
                  "fullName='" + fullName + '\'' +
                  ", UserID=" + UserID +
                  '}';
     }

     String fullName;
     int UserID;
}
