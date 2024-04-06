package com.example.prj.tools;

import java.io.Serializable;
import java.util.List;

public class areaAnalysis implements Serializable {
    public int companyNumber;
    public List<industryData> industryCompany;
    public double totalAssets;
    public List<industryData> industryAssets;
    public double totalBusinessIncome;
    public List<industryData> industryBusinessIncome;
    public double totalDebt;
    public List<industryData> industryDebt;
    public List<industryData> industryPureProfit;
}
