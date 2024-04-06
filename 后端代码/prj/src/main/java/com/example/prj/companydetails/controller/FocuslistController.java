package com.example.prj.companydetails.controller;


import com.example.prj.companydetails.entity.Focuslist;
import com.example.prj.companydetails.mapper.FocuslistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 09
 * @since 2023-09-06
 */
@RestController
@CrossOrigin
@RequestMapping("/focuslist")
public class FocuslistController {
@Autowired
    FocuslistMapper focuslistMapper;

@PostMapping("/startfocus")
    public String startfocus(Focuslist a) {
        String startresult = ""; // 用来存放返回结果
        // 检查某企业是否已经被某用户添加到数据库中，避免重复添加

        List<Focuslist> checkresult = focuslistMapper.check(a);

        if (checkresult.isEmpty()) {
            int result = focuslistMapper.startfocus(a);
            if (result == 1) {
                startresult = "关注成功";
            } else {
                startresult = "关注失败"; // 处理关注失败的情况
            }
        } else {
            startresult = "该企业已添加关注，请勿重复添加！";
        }
        return startresult;
    }


}
