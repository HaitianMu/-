package com.example.prj.company.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 09
 * @since 2023-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Companybaseinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("creditNumber")
    private String creditNumber;

    @TableField("stockNumber")
    private String stockNumber;

    @TableField("fullName")
    private String fullName;

    @TableField("briefName")
    private String briefName;

    @TableField("legalRepresentative")
    private String legalRepresentative;

    @TableField("industryClassification")
    private String industryClassification;

    @TableField("listingDate")
    private String listingDate;

    private String area;

    @TableField("registrationAddress")
    private String registrationAddress;

    @TableField("registrationDate")
    private String registrationDate;

    @TableField("registeredAssets")
    private String registeredAssets;

    @TableField("mainProducts")
    private String mainProducts;

    @TableField("businessIncome")
    private Double businessIncome;

    @TableField("businessProfit")
    private Double businessProfit;

    @TableField("pureProfit")
    private Double pureProfit;

    @TableField("undistributedProfit")
    private Double undistributedProfit;

    @TableField("totalAssets")
    private Double totalAssets;

    @TableField("totalDebt")
    private Double totalDebt;

    @TableField("pureAssets")
    private Double pureAssets;

    @TableField("profitPerShare")
    private Double profitPerShare;

    public String getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
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

    public String getBriefName() {
        return briefName;
    }

    public void setBriefName(String briefName) {
        this.briefName = briefName;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getIndustryClassification() {
        return industryClassification;
    }

    public void setIndustryClassification(String industryClassification) {
        this.industryClassification = industryClassification;
    }

    public String getListingDate() {
        return listingDate;
    }

    public void setListingDate(String listingDate) {
        this.listingDate = listingDate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRegisteredAssets() {
        return registeredAssets;
    }

    public void setRegisteredAssets(String registeredAssets) {
        this.registeredAssets = registeredAssets;
    }

    public String getMainProducts() {
        return mainProducts;
    }

    public void setMainProducts(String mainProducts) {
        this.mainProducts = mainProducts;
    }

    public Double getBusinessIncome() {
        return businessIncome;
    }

    public void setBusinessIncome(Double businessIncome) {
        this.businessIncome = businessIncome;
    }

    public Double getBusinessProfit() {
        return businessProfit;
    }

    public void setBusinessProfit(Double businessProfit) {
        this.businessProfit = businessProfit;
    }

    public Double getPureProfit() {
        return pureProfit;
    }

    public void setPureProfit(Double pureProfit) {
        this.pureProfit = pureProfit;
    }

    public Double getUndistributedProfit() {
        return undistributedProfit;
    }

    public void setUndistributedProfit(Double undistributedProfit) {
        this.undistributedProfit = undistributedProfit;
    }

    public Double getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(Double totalAssets) {
        this.totalAssets = totalAssets;
    }

    public Double getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(Double totalDebt) {
        this.totalDebt = totalDebt;
    }

    public Double getPureAssets() {
        return pureAssets;
    }

    public void setPureAssets(Double pureAssets) {
        this.pureAssets = pureAssets;
    }

    public Double getProfitPerShare() {
        return profitPerShare;
    }

    public void setProfitPerShare(Double profitPerShare) {
        this.profitPerShare = profitPerShare;
    }
}
