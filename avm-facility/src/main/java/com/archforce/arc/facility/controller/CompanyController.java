package com.archforce.arc.facility.controller;

import com.archforce.arc.facility.entity.vo.CompanyVo;
import com.archforce.arc.facility.service.company.CompanyService;
import com.archforce.common.utils.PageInfo;
import com.archforce.common.utils.QueryVo;
import com.archforce.common.utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/page")
    public ResBody getAllCompany(@RequestBody QueryVo<CompanyVo> queryVo) {
        return ResBody.ok(PageInfo.getPageInfo(companyService.getAllCompany(queryVo)));
    }

    @PostMapping("/list")
    public ResBody getAllCompanyList() {
        return ResBody.ok(companyService.getAllCompanyList());
    }

    @PostMapping("/add")
    public ResBody insertSelective(@RequestBody CompanyVo company) {
        companyService.insertSelective(company);
        return ResBody.ok();
    }

    @PostMapping("/update")
    public ResBody updateByPrimaryKeySelective(@RequestBody CompanyVo company) {
        companyService.updateByPrimaryKeySelective(company);
        return ResBody.ok();
    }

    @PostMapping("/deleteBatch")
    public ResBody deleteBatch(@RequestBody List<Integer> ids) {
        companyService.deleteBatch(ids);
        return ResBody.ok();
    }

}
