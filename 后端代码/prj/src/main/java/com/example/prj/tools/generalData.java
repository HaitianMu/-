package com.example.prj.tools;

import java.io.Serializable;
import java.util.List;

public class generalData implements Serializable {

    public List<area_father> areaCompany;

    public int totalCompany;
    public List<industryData> industryCompany;

    public List<areaData> areaBad;

    public int totalBad;

    public List<areaData> areaAssets;

    public List<industryData> industryAssets;

    public double totalAssets;

    public List<areaData> areaPureAssets;

    public List<industryData> industryPureAssets;

    public double totalPureAssets;

    public List<areaData> areaPureProfit;

    public List<industryData> industryPureProfit;

    public double totalPureProfit;

    public List<areaData> areaDebt;

    public List<industryData> industryDebt;

    public double totalDebt;
}
