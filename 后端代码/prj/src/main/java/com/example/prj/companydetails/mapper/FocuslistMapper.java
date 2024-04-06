package com.example.prj.companydetails.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.prj.companydetails.entity.Focuslist;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 09
 * @since 2023-09-06
 */
@Mapper
public interface FocuslistMapper extends BaseMapper<Focuslist> {
    @Select("select * from focuslist where uid = #{UserID} and fullName = #{fullName}")
    List<Focuslist> check(Focuslist a);

    @Insert("insert into focuslist (uid, stockNumber, fullName) values (#{UserID}, #{stockNumber}, #{fullName})")
    int startfocus(Focuslist a);

}
