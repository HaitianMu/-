package com.example.prj.users.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.prj.users.entity.Userinfo;
import com.example.prj.users.mapper.UserinfoMapper;
import com.example.prj.users.service.IUserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 09
 * @since 2023-09-02
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements IUserinfoService {


}
