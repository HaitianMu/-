package com.example.prj.users.mapper;

import com.example.prj.users.entity.Userinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 09
 * @since 2023-09-02
 */
@Mapper
public interface UserinfoMapper extends BaseMapper<Userinfo> {

    //用户注册接口
@Insert("INSERT INTO userinfo (`username`,`password`,`isManager`) VALUES (#{username},#{password},'0')")
    public int register(Userinfo u);
    //用户uid查找接口
@Select("select uid from userinfo where `username`=#{username}")
    public List<Integer> getuid(Userinfo u);

   //建立用户的关注列表

    //用户登录接口
    @Select("select * from userinfo where `username`=#{username} and `password`=#{password}")
    public List<Userinfo> login(Userinfo u);
}
