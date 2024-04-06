package com.example.prj.company.mapper;

import com.example.prj.company.entity.Companybaseinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.prj.tools.areaData;
import com.example.prj.tools.industryData;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 09/gyb
 * @since 2023-09-01
 */
public interface CompanybaseinfoMapper extends BaseMapper<Companybaseinfo> {
    // The detailed implementation is stored in resources/mapper/company/mapper.xml
    // Each method's meaning is introduced in interface document

    // get area/industry list
    List<String> getAreaList();
    List<String> getIndustryList();


    // industry analysis
    int industry_companyNumber(String industry);
    List<areaData> industry_areaCompany(String industry);
    double industry_totalAssets(String industry);
    List<areaData> industry_areaAssets(String industry);
    double industry_totalBusinessIncome(String industry);
    List<areaData> industry_areaBusinessIncome(String industry);
    double industry_totalDebt(String industry);
    List<areaData> industry_areaDebt(String industry);
    List<areaData> industry_areaPureProfit(String industry);


    // area analysis
    int area_companyNumber(String area);
    List<industryData> area_industryCompany(String area);
    double area_totalAssets(String area);
    List<industryData> area_industryAssets(String area);
    double area_totalBusinessIncome(String area);
    List<industryData> area_industryBusinessIncome(String area);
    double area_totalDebt(String area);
    List<industryData> area_industryDebt(String area);
    List<industryData> area_industryPureProfit(String area);



    // general data
    List<areaData> selectAreaCompany();
    int selectTotalCompany();
    List<industryData> selectIndustryCompany();
    List<areaData> selectAreaBad();
    int selectTotalBad();
    List<areaData> selectAreaAssets();
    List<industryData> selectIndustryAssets();
    double selectTotalAssets();
    List<areaData> selectAreaPureAssets();
    List<industryData> selectIndustryPureAssets();
    double selectTotalPureAssets();
    List<areaData> selectAreaPureProfit();
    List<industryData> selectIndustryPureProfit();
    double selectTotalPureProfit();
    List<areaData> selectAreaDebt();
    List<industryData> selectIndustryDebt();
    double selectTotalDebt();
}
