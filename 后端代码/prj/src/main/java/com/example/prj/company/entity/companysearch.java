package com.example.prj.company.entity;

import javafx.beans.binding.StringExpression;

public class companysearch {
    public String fullName;
    public String area;
    public String totalAssets;
    public String industryClassification;
    public String pureProfit;
    public int page;
    public int pagesize;

    public String getFullName() {
        return fullName;
    }

    public String getTotalAssets() {
        return totalAssets;
    }

    public String getPureProfit() {
        return pureProfit;
    }

    public String getArea() {
        return area;
    }

    public String getIndustryClassification() {
        return industryClassification;
    }
}
