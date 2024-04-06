package com.example.prj.companydetails.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.prj.companydetails.entity.Shareholders;
import com.example.prj.companydetails.entity.detailpost;
import com.example.prj.companydetails.mapper.ShareholdersMapper;
import com.sun.org.apache.xpath.internal.functions.FuncFloor;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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
@RequestMapping("/company2")
public class ShareholdersController {
    @Autowired
    ShareholdersMapper shareholdersMapper;
    @PostMapping("/holders")
    public  String shareholders(@RequestBody detailpost a){
     List<JSONObject> jsObjects = new ArrayList<>();
     List<Shareholders> holders=shareholdersMapper.getholders(a);
     double max=1;

     //提取每一个shareholder的name和份额，并重新封装为一个新的JSON；
                for (Shareholders holder : holders) {
                    JSONObject tem=new JSONObject();
                    tem.put("name",holder.getHolderName());
                    tem.put("value",holder.getHoldRate());
                    max-=holder.getHoldRate();
                    jsObjects.add(tem);

                }
                //将剩余的封装为"其它"；
                JSONObject tem=new JSONObject();
                //将”其它“进行封装
                tem.put("name","其他");
                tem.put("value",max);
                jsObjects.add(tem);
     String shareholder= JSON.toJSONString(jsObjects);
     return shareholder;
 }
}
