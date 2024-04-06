package com.example.prj.companydetails.mapper;

import com.example.prj.companydetails.entity.Companyleaders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.prj.companydetails.entity.Focuslist;
import com.example.prj.companydetails.entity.RankResult;
import com.example.prj.companydetails.entity.detailpost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import  com.example.prj.company.entity.Companybaseinfo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 09
 * @since 2023-09-04
 */
@Mapper
public interface CompanyleadersMapper extends BaseMapper<Companyleaders> {

    //查询公司基本信息
    @Select("select * from companybaseinfo where fullName=#{fullName}")
    public Companybaseinfo getbase(detailpost a);



    //查询是否加入关注列表
    @Select("select * from focuslist where uid=#{UserID} and fullName=#{fullName}")
    public  List<Focuslist> getfocuslist(detailpost a);
    //查询公司高管
    @Select("select * from companyleaders where fullName=#{fullName}")
    public List<Companyleaders> getleaders(detailpost a);




    //得到该企业所属行业
    @Select("select industryClassification from companybaseinfo where fullName=#{fullName}")
    public String getindustry(detailpost a);

    //得到企业名称，行业名称，行业排名，ORDER BY companybaseinfo.businessIncome
    @Select("SELECT\n" +
            "    companybaseinfo.fullName,\n" +
            "    companybaseinfo.industryClassification,\n" +
            "    RANK() OVER (PARTITION BY companybaseinfo.industryClassification ORDER BY companybaseinfo.businessIncome DESC) AS industryRank\n" +
            "FROM\n" +
            "    companybaseinfo\n" +
            "WHERE\n" +
            "    companybaseinfo.industryClassification = #{industry};")
    public List<RankResult> getincomerank(String industry);


    //得到企业名称，行业名称，行业排名，ORDER BY companybaseinfo.businessProfit
    @Select("SELECT\n" +
            "    companybaseinfo.fullName,\n" +
            "    companybaseinfo.industryClassification,\n" +
            "    RANK() OVER (PARTITION BY companybaseinfo.industryClassification ORDER BY companybaseinfo.businessProfit DESC) AS industryRank\n" +
            "FROM\n" +
            "    companybaseinfo\n" +
            "WHERE\n" +
            "    companybaseinfo.industryClassification = #{industry};")
    public List<RankResult> GetBusinessProfitRank(String industry);



    //得到企业名称，行业名称，行业排名，ORDER BY companybaseinfo.pureProfit
    @Select("SELECT\n" +
            "    companybaseinfo.fullName,\n" +
            "    companybaseinfo.industryClassification,\n" +
            "    RANK() OVER (PARTITION BY companybaseinfo.industryClassification ORDER BY companybaseinfo.pureProfit DESC) AS industryRank\n" +
            "FROM\n" +
            "    companybaseinfo\n" +
            "WHERE\n" +
            "    companybaseinfo.industryClassification = #{industry};")
    public List<RankResult> getPureProfitRank(String industry);


    //得到企业名称，行业名称，行业排名，ORDER BY companybaseinfo.undistributedProfit
    @Select("SELECT\n" +
            "    companybaseinfo.fullName,\n" +
            "    companybaseinfo.industryClassification,\n" +
            "    RANK() OVER (PARTITION BY companybaseinfo.industryClassification ORDER BY companybaseinfo.undistributedProfit DESC) AS industryRank\n" +
            "FROM\n" +
            "    companybaseinfo\n" +
            "WHERE\n" +
            "    companybaseinfo.industryClassification = #{industry};")
    public List<RankResult> getUndistributedProfitRank(String industry);


    //得到企业名称，行业名称，行业排名，ORDER BY companybaseinfo.totalAssets
    @Select("SELECT\n" +
            "    companybaseinfo.fullName,\n" +
            "    companybaseinfo.industryClassification,\n" +
            "    RANK() OVER (PARTITION BY companybaseinfo.industryClassification ORDER BY companybaseinfo.totalAssets DESC) AS industryRank\n" +
            "FROM\n" +
            "    companybaseinfo\n" +
            "WHERE\n" +
            "    companybaseinfo.industryClassification = #{industry};")
    public List<RankResult> getTotalAssetsRank(String industry);


    //得到企业名称，行业名称，行业排名，ORDER BY companybaseinfo.totalDebt
    @Select("SELECT\n" +
            "    companybaseinfo.fullName,\n" +
            "    companybaseinfo.industryClassification,\n" +
            "    RANK() OVER (PARTITION BY companybaseinfo.industryClassification ORDER BY companybaseinfo.totalDebt DESC) AS industryRank\n" +
            "FROM\n" +
            "    companybaseinfo\n" +
            "WHERE\n" +
            "    companybaseinfo.industryClassification = #{industry};")
    public List<RankResult> getTotalDebtRank(String industry);

    //得到企业名称，行业名称，行业排名，ORDER BY companybaseinfo.pureAssets
    @Select("SELECT\n" +
            "    companybaseinfo.fullName,\n" +
            "    companybaseinfo.industryClassification,\n" +
            "    RANK() OVER (PARTITION BY companybaseinfo.industryClassification ORDER BY companybaseinfo.pureAssets DESC) AS industryRank\n" +
            "FROM\n" +
            "    companybaseinfo\n" +
            "WHERE\n" +
            "    companybaseinfo.industryClassification = #{industry};")
    public List<RankResult> getPureAssetsrank(String industry);

    //得到企业名称，行业名称，行业排名，ORDER BY companybaseinfo.profitPerShare
    @Select("SELECT\n" +
            "    companybaseinfo.fullName,\n" +
            "    companybaseinfo.industryClassification,\n" +
            "    RANK() OVER (PARTITION BY companybaseinfo.industryClassification ORDER BY companybaseinfo.profitPerShare DESC) AS industryRank\n" +
            "FROM\n" +
            "    companybaseinfo\n" +
            "WHERE\n" +
            "    companybaseinfo.industryClassification = #{industry};")
    public List<RankResult> getProfitPerShareRank(String industry);



}
