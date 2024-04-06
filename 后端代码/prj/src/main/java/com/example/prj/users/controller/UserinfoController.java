package com.example.prj.users.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.prj.users.entity.Userinfo;
import com.example.prj.users.mapper.UserinfoMapper;
import com.example.prj.users.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 09
 * @since 2023-09-02
 */
@CrossOrigin
@RestController
@RequestMapping("/userinfo")
public class UserinfoController {
@Autowired
    UserinfoMapper userinfoMapper;
//注册接口
    //请求参数
    //userName用户名string
    // password密码string

  /*  返回参数
     userID int
     isNameUsed BOOL
     isLogIn bool*/
    @PostMapping("/register")
    public String register(@RequestBody Userinfo u) throws InterruptedException {

        JSONObject jsonObject=new JSONObject();
        int result=userinfoMapper.register(u);//插入数据库
        List<Integer>register =userinfoMapper.getuid(u);
             //查找用户uid
        if (result==1){
            jsonObject.put("userID", register);
            jsonObject.put("isNameUsed", false);
            jsonObject.put("isLogIn",true);
            return JSON.toJSONString(jsonObject);

        }
        else{
            jsonObject.put("userID", -1);
            jsonObject.put("isNameUsed", true);
            jsonObject.put("isLogIn",false);
            return JSON.toJSONString(jsonObject);
        }
    }

    //登录接口
    //请求参数
    //userName用户名string
    // password密码string

    /*  返回参数
       userID int
       ifUseName/PasswordCorrect BOOL
       isLogIn bool*/
    @PostMapping("/login")
    public String login(@RequestBody Userinfo u){
        JSONObject jsonObject=new JSONObject();
        List<Userinfo>result =userinfoMapper.login(u);
        List<Integer> useruid=userinfoMapper.getuid(u);   //查找用户uid
        System.out.println("result:"+result);
        System.out.println();

        if (!result.isEmpty()){
            jsonObject.put("userID", useruid);
            jsonObject.put("ifUseName/PasswordCorrect", true);
            jsonObject.put("isLogIn",true);
            System.out.println(jsonObject);
            return JSON.toJSONString(jsonObject);

        }
        else{
            jsonObject.put("userID", -1);
            jsonObject.put("ifUseName/PasswordCorrect", false);
            jsonObject.put("isLogIn",false);
            return JSON.toJSONString(jsonObject);
        }

    }
}
