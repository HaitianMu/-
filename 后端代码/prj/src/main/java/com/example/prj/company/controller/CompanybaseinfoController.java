package com.example.prj.company.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.prj.company.entity.Companybaseinfo;
import com.example.prj.company.entity.companysearch;
import com.example.prj.company.mapper.CompanybaseinfoMapper;
import com.example.prj.company.service.ICompanybaseinfoService;
import com.example.prj.tools.*;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 09/gyb
 * @since 2023-09-01
 */
@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanybaseinfoController {
    @Autowired
    private ICompanybaseinfoService cbs;

    @PostMapping("/searchresult")
    public String search(@RequestBody companysearch cbi){  // 根据关键词查询匹配的企业名单
        IPage<Companybaseinfo> cList=null;
        Map<String,Object> result=new HashMap<String,Object>();
        try{
            int page=cbi.page;
            int pagesize=cbi.pagesize;
            cList=cbs.search(cbi,page,pagesize);  // 在页面展示数量限制下查找企业
            //System.out.println(page);
            if(cList!=null&&cList.getSize()>0)   // 结果是否为空的判定
            {
                result.put("status",1);
                result.put("data",cList);
            }
            else{
                result.put("status",2);
                result.put("errorMsg","未查询到数据");
            }
        }catch(Exception ex){
            result.put("status",-1);
            ex.printStackTrace();
        }
        return JSON.toJSONString(result);
    }


    @PostMapping("/allData")
    public String allData(){     // 查询全国企业总概览数据
        generalData gd = null;
        Map<String,Object> result=new HashMap<String,Object>();
        try {
            gd = cbs.allData();
            if(gd != null){
                result.put("status",1);
                result.put("data",gd);
            }
            else{
                result.put("status", 2);
                result.put("errorMsg", "未找到数据");
            }
        } catch (Exception e) {
            result.put("status",-1);
            e.printStackTrace();
        }
        return JSON.toJSONString(result);
    }

    @PostMapping("/areaAnalysis")
    public String areaAnalyse(@RequestBody areaData area){     // 根据选定地区查询地区总体数据分析
        areaAnalysis aa = null;
        Map<String,Object> result=new HashMap<String,Object>();
        try {
            aa = cbs.areaGeneral(area.name);
            if(aa != null){
                result.put("status",1);
                result.put("data",aa);
            }
            else{
                result.put("status", 2);
                result.put("errorMsg", "未找到数据");
            }
        } catch (Exception e) {
            result.put("status",-1);
            e.printStackTrace();
        }
        return JSON.toJSONString(result);
    }

    @PostMapping("/industryAnalysis")
    public String industryAnalyse(@RequestBody industryData industry){  // 根据选定行业查询行业总体数据分析
        industryAnalysis ia = null;
        Map<String,Object> result=new HashMap<String,Object>();
        try {
            ia = cbs.industryGeneral(industry.name);
            if(ia != null){
                result.put("status",1);
                result.put("data",ia);
            }
            else{
                result.put("status", 2);
                result.put("errorMsg", "未找到数据");
            }
        } catch (Exception e) {
            result.put("status",-1);
            e.printStackTrace();
        }
        return JSON.toJSONString(result);
    }
    @PostMapping("/getArea")
    public String getArea(){     // 获取包含所有地区名称的列表
        List<String> ls = null;
        Map<String,Object> result=new HashMap<String,Object>();
        try {
            ls = cbs.getArea();
            if(ls != null){
                result.put("status",1);
                result.put("data",ls);
            }
            else{
                result.put("status", 2);
                result.put("errorMsg", "未找到数据");
            }
        } catch (Exception e) {
            result.put("status",-1);
            e.printStackTrace();
        }
        return JSON.toJSONString(result);
    }
    @PostMapping("/getIndustry")
    public String getIndustry(){   // 获取包含所有行业类型名称的列表
        List<String> ls = null;
        Map<String,Object> result=new HashMap<String,Object>();
        try {
            ls = cbs.getIndustry();
            if(ls != null){
                result.put("status",1);
                result.put("data",ls);
            }
            else{
                result.put("status", 2);
                result.put("errorMsg", "未找到数据");
            }
        } catch (Exception e) {
            result.put("status",-1);
            e.printStackTrace();
        }
        return JSON.toJSONString(result);
    }

}
