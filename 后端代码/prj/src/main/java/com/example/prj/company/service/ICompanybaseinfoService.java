package com.example.prj.company.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.prj.company.entity.Companybaseinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.prj.company.entity.companysearch;
import com.example.prj.tools.areaAnalysis;
import com.example.prj.tools.generalData;
import com.example.prj.tools.industryAnalysis;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 09/gyb
 * @since 2023-09-01
 */
public interface ICompanybaseinfoService extends IService<Companybaseinfo> {
    public IPage<Companybaseinfo> search(companysearch cbi, int page, int sz);
    generalData allData();
    areaAnalysis areaGeneral(String area);
    industryAnalysis industryGeneral(String industry);

    List<String> getArea();
    List<String> getIndustry();
}
