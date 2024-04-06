package com.example.prj.tools;

import java.io.Serializable;
import java.util.List;

public class industryAnalysis implements Serializable {
    public int companyNumber;
    public List<areaData> areaCompany;
    public double totalAssets;
    public List<areaData> areaAssets;
    public double totalBusinessIncome;
    public List<areaData> areaBusinessIncome;
    public double totalDebt;
    public List<areaData> areaDebt;
    public List<areaData> areaPureProfit;
}
