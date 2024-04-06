package com.example.prj.companydetails.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.prj.company.entity.Companybaseinfo;
import com.example.prj.companydetails.entity.Companyleaders;
import com.example.prj.companydetails.entity.Focuslist;
import com.example.prj.companydetails.entity.RankResult;
import  com.example.prj.companydetails.entity.detailpost;

import com.example.prj.companydetails.mapper.CompanyleadersMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 09
 * @since 2023-09-04
 */
@RestController
@CrossOrigin
@RequestMapping("/company1")
public class CompanyleadersController {
    @Autowired
    CompanyleadersMapper companyleadersMapper;

 @PostMapping("/details")
    public  String companydetails(@RequestBody detailpost a ){  // search the detailed basic information of companies
     Companybaseinfo companybaseinfo = companyleadersMapper.getbase(a);
     List<Focuslist> focuslists = companyleadersMapper.getfocuslist(a);
     ObjectMapper objectMapper = new ObjectMapper();

     Map<String, Object> response = new HashMap<>();
     response.put("companyBaseInfo", companybaseinfo);

     if (focuslists.isEmpty()) {
         response.put("ifAddedToFavorate", false);
     }

     //得到该企业所属行业
     String industry =companyleadersMapper.getindustry(a);
     //按照income进行排名
     List<RankResult> results=companyleadersMapper.getincomerank(industry);
     for (RankResult result : results) {
         if(result.getFullName().equals(a.getFullName())){
             response.put("incomeRankRank",result.getIndustryRank());
         }
     }
     //按照BusinessProfit进行排名
     results=companyleadersMapper.GetBusinessProfitRank(industry);
     for (RankResult result : results) {
         if(result.getFullName().equals(a.getFullName())){
             response.put("BusinessProfitRank",result.getIndustryRank());
         }
     }
     //按照TotalAssets进行排名
      results=companyleadersMapper.getTotalAssetsRank(industry);
     for (RankResult result : results) {
         if(result.getFullName().equals(a.getFullName())){
             response.put("TotalAssetsRank",result.getIndustryRank());
         }
     }
     //按照TotalDebt进行排名
     results=companyleadersMapper.getTotalDebtRank(industry);
     for (RankResult result : results) {
         if(result.getFullName().equals(a.getFullName())){
             response.put("TotalDebtRank",result.getIndustryRank());
         }
     }
     //按照ProfitPerShare进行排名
      results=companyleadersMapper.getProfitPerShareRank(industry);
     for (RankResult result : results) {
         if(result.getFullName().equals(a.getFullName())){
             response.put("ProfitPerShareRank",result.getIndustryRank());
         }
     }
     //按照PureAssets进行排名
     results=companyleadersMapper.getPureAssetsrank(industry);
     for (RankResult result : results) {
         if(result.getFullName().equals(a.getFullName())){
             response.put("PureAssetsRank",result.getIndustryRank());
         }
     }
     //按照PureProfit进行排名
     results=companyleadersMapper.getPureProfitRank(industry);
     for (RankResult result : results) {
         if(result.getFullName().equals(a.getFullName())){
             response.put("PureProfitRank",result.getIndustryRank());
         }
     }


     //按照UndistributedProfit进行排名
      results=companyleadersMapper.getUndistributedProfitRank(industry);
     for (RankResult result : results) {
         if(result.getFullName().equals(a.getFullName())){
             response.put("UndistributedProfitRank",result.getIndustryRank());
         }
     }



     try {
         String jsonResponse = objectMapper.writeValueAsString(response);
         return jsonResponse;
     } catch (Exception e) {
         e.printStackTrace();
         return "JSON生成失败";
     }
 };

//公司高管
 @PostMapping("/administrater")
    public String administrater(@RequestBody detailpost a ) { // get the information of company leaders
     List<Companyleaders> leaders= companyleadersMapper.getleaders(a);
     String leaderresult= JSON.toJSONString(leaders);
     return leaderresult;
 }

}
