package com.example.prj.company.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.prj.company.entity.Companybaseinfo;
import com.example.prj.company.entity.companysearch;
import com.example.prj.company.mapper.CompanybaseinfoMapper;
import com.example.prj.company.service.ICompanybaseinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.prj.tools.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 09/gyb
 * @since 2023-09-01
 */
@Service
public class CompanybaseinfoServiceImpl extends ServiceImpl<CompanybaseinfoMapper, Companybaseinfo> implements ICompanybaseinfoService {
    @Autowired
    private CompanybaseinfoMapper companyMapper;   // mapper用于与数据库交互

    @Override
    public IPage<Companybaseinfo> search(companysearch cbi, int page, int sz) {  // 参数为:企业条件，页码，页面展示数量
        QueryWrapper wrapper=new QueryWrapper();
        int count=0;
        //近似搜全名
        if(cbi.getFullName()==null) wrapper.like("fullName","");
        wrapper.like("fullName",cbi.getFullName());
        //选项检索总资产
        if(cbi.getTotalAssets()==null){count++;}
        else if(cbi.getTotalAssets().equals("1亿以下"))
            wrapper.le("totalAssets",100000000);
        else if(cbi.getTotalAssets().equals("1到3亿")){
            wrapper.le("totalAssets",300000000);
            wrapper.gt("totalAssets",100000000);
        }
        else if(cbi.getTotalAssets().equals("3到5亿")){
            wrapper.le("totalAssets",500000000);
            wrapper.gt("totalAssets",300000000);
        }
        else if(cbi.getTotalAssets().equals("5到7亿")){
            wrapper.le("totalAssets",700000000);
            wrapper.gt("totalAssets",500000000);
        }
        else if(cbi.getTotalAssets().equals("7到10亿")){
            wrapper.le("totalAssets",1000000000);
            wrapper.gt("totalAssets",700000000);
        }
        else if(cbi.getTotalAssets().equals("10亿以上")){
            wrapper.gt("totalAssets",1000000000);
        }
        else wrapper.isNotNull("totalAssets");
        //选项检索净利润
        if(cbi.getPureProfit()==null){count++;}
        else if(cbi.getPureProfit().equals("1亿以下"))
            wrapper.le("pureProfit",100000000);
        else if(cbi.getPureProfit().equals("1到3亿")){
            wrapper.le("pureProfit",300000000);
            wrapper.gt("pureProfit",100000000);
        }
        else if(cbi.getPureProfit().equals("3到5亿")){
            wrapper.le("pureProfit",500000000);
            wrapper.gt("pureProfit",300000000);
        }
        else if(cbi.getPureProfit().equals("5到7亿")){
            wrapper.le("pureProfit",700000000);
            wrapper.gt("pureProfit",500000000);
        }
        else if(cbi.getPureProfit().equals("7到10亿")){
            wrapper.le("pureProfit",1000000000);
            wrapper.gt("pureProfit",700000000);
        }
        else if(cbi.getPureProfit().equals("10亿以上")){
            wrapper.gt("pureProfit",1000000000);
        }
        else wrapper.isNotNull("pureProfit");

        //精准搜地区
        if(cbi.getArea()!=null&&cbi.getArea().length()>0) wrapper.like("area",cbi.getArea());
        else count++;
        //精准搜分类
        if(cbi.getIndustryClassification()!=null&&cbi.getIndustryClassification().length()>0) wrapper.like("industryClassification",cbi.getIndustryClassification());
        else count++;

        Page<Companybaseinfo> pg=new Page<Companybaseinfo>(page,sz);
        IPage<Companybaseinfo>cList=companyMapper.selectPage(pg,wrapper);
        return cList;
    }
    /*
    * 以下方法的数据库查询语句在resources/mapper/company/CompanybaseinfoMapper.xml下实现
    * */

    @Override
    public generalData allData() {
        generalData gd = new generalData();

        // areaCompany
        List<areaData> fas = companyMapper.selectAreaCompany();  // 各地区各自上市企业数量
        List<area_father> af = new ArrayList<>();
        for(int i = 0; i < fas.size(); ++i){  // 遍历含不同地区的列表
            area_father faq = new area_father();
            faq.name = fas.get(i).name;    // 地区名称
            faq.value = fas.get(i).value;  // 地区企业总数
            faq.children = companyMapper.area_industryCompany(fas.get(i).name);   // 获取该地区不同行业的企业数量
            af.add(faq);
        }
        gd.areaCompany = af;

        // totalCompany: 企业总数
        gd.totalCompany = companyMapper.selectTotalCompany();

        // industryCompany: 全国各行业上市企业数量
        gd.industryCompany = companyMapper.selectIndustryCompany();

        // areaBad: 各地区近2月失信企业数量
        gd.areaBad = companyMapper.selectAreaBad();

        // totalBad: 近2月全国失信企业总数
        gd.totalBad = companyMapper.selectTotalBad();

        // areaAssets: 各地区上市企业资产总量
        gd.areaAssets = companyMapper.selectAreaAssets();

        // industryAssets: 各行业上市企业资产总量
        gd.industryAssets = companyMapper.selectIndustryAssets();

        // totalAssets: 全国所有上市公司资产总量
        gd.totalAssets = companyMapper.selectTotalAssets();

        // areaPureAssets: 各地区上市企业净资产总量
        gd.areaPureAssets = companyMapper.selectAreaPureAssets();

        // industryPureAssets: 各行业上市企业净资产总量
        gd.industryPureAssets = companyMapper.selectIndustryPureAssets();

        // totalPureAssets: 全国所有上市公司净资产总量
        gd.totalPureAssets = companyMapper.selectTotalPureAssets();

        // areaPureProfit: 各地区上市企业净利润总量
        gd.areaPureProfit = companyMapper.selectAreaPureProfit();

        // industryPureProfit: 各行业上市企业净利润总量
        gd.industryPureProfit = companyMapper.selectIndustryPureProfit();

        // totalPureProfit: 全国所有上市公司净利润总量
        gd.totalPureProfit = companyMapper.selectTotalPureProfit();

        // areaDebt: 各地区上市企业负债总量
        gd.areaDebt = companyMapper.selectAreaDebt();

        // industryDebt: 各行业上市企业负债总量
        gd.industryDebt = companyMapper.selectIndustryDebt();

        // totalDebt: 全国所有上市公司负债总量
        gd.totalDebt = companyMapper.selectTotalDebt();

        return gd;
    }

    @Override
    public areaAnalysis areaGeneral(String area) {
        areaAnalysis aa = new areaAnalysis();

        // companyNumber: 该地区上市企业总数
        aa.companyNumber = companyMapper.area_companyNumber(area);
        // industryCompany: 该地区各行业上市公司数量
        aa.industryCompany = companyMapper.area_industryCompany(area);
        // totalAssets: 地区上市企业总资产
        aa.totalAssets = companyMapper.area_totalAssets(area);
        // industryAssets: 地区不同行业的上市企业资产之和(以行业为单位求和，下同)
        aa.industryAssets = companyMapper.area_industryAssets(area);
        // totalBusinessIncome: 地区上市企业总营业收入
        aa.totalBusinessIncome = companyMapper.area_totalBusinessIncome(area);
        // industryBusinessIncome: 地区不同行业的上市企业营业收入之和
        aa.industryBusinessIncome = companyMapper.area_industryBusinessIncome(area);
        // totalDebt: 地区上市企业负债之和
        aa.totalDebt = companyMapper.area_totalDebt(area);
        // industryDebt: 地区不同行业的上市企业负债之和
        aa.industryDebt = companyMapper.area_industryDebt(area);
        // industryPureProfit: 地区不同行业的上市公司净利润之和
        aa.industryPureProfit = companyMapper.area_industryPureProfit(area);

        return aa;
    }

    @Override
    public industryAnalysis industryGeneral(String industry) {
        industryAnalysis aa = new industryAnalysis();

        // 该行业上市企业总数
        aa.companyNumber = companyMapper.industry_companyNumber(industry);
        // 该行业各地区上市公司数量
        aa.areaCompany = companyMapper.industry_areaCompany(industry);
        // 行业上市企业总资产
        aa.totalAssets = companyMapper.industry_totalAssets(industry);
        // 本行业内不同地区的上市企业资产之和(以地区为单位求和，下同)
        aa.areaAssets = companyMapper.industry_areaAssets(industry);
        // 本行业上市企业总营业收入
        aa.totalBusinessIncome = companyMapper.industry_totalBusinessIncome(industry);
        // 行业内不同地区的上市企业营业收入之和
        aa.areaBusinessIncome = companyMapper.industry_areaBusinessIncome(industry);
        // 行业上市企业负债之和
        aa.totalDebt = companyMapper.industry_totalDebt(industry);
        // 行业内不同地区的上市企业负债之和
        aa.areaDebt = companyMapper.industry_areaDebt(industry);
        // 行业内不同地区的上市公司净利润之和
        aa.areaPureProfit = companyMapper.industry_areaPureProfit(industry);

        return aa;
    }

    @Override
    public List<String> getArea() {
        return companyMapper.getAreaList();
    }

    @Override
    public List<String> getIndustry() {
        return companyMapper.getIndustryList();
    }
}
