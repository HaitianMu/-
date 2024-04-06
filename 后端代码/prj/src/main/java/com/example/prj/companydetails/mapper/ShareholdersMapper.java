package com.example.prj.companydetails.mapper;

import com.example.prj.companydetails.entity.Shareholders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.prj.companydetails.entity.detailpost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
public interface ShareholdersMapper extends BaseMapper<Shareholders> {
    //查询公司股东
    @Select("select * from shareholders where fullName =#{fullName}")
    public List<Shareholders> getholders(detailpost a);

}
