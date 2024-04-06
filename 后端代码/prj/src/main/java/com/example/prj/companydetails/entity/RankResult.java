package com.example.prj.companydetails.entity;

public class RankResult {
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIndustryClassification() {
        return industryClassification;
    }

    public void setIndustryClassification(String industryClassification) {
        this.industryClassification = industryClassification;
    }

    public int getIndustryRank() {
        return industryRank;
    }

    public void setIndustryRank(int industryRank) {
        this.industryRank = industryRank;
    }

    @Override
    public String toString() {
        return "RankResult{" +
                "fullName='" + fullName + '\'' +
                ", industryClassification='" + industryClassification + '\'' +
                ", industryRank=" + industryRank +
                '}';
    }

    String fullName;
    String industryClassification;
    int industryRank;

}
