package com.archforce.arc.facility.controller;

import com.archforce.arc.facility.entity.avm.Company;
import com.archforce.arc.facility.entity.avm.Component;
import com.archforce.arc.facility.service.company.CompanyService;
import com.archforce.arc.facility.service.component.ComponentService;
import com.archforce.arc.facility.utils.PageInfo;
import com.archforce.arc.facility.utils.QueryVo;
import com.archforce.arc.facility.utils.ResBody;
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
    public ResBody pageProducts(@RequestBody QueryVo<Company> queryVo) {
        return ResBody.ok(PageInfo.getPageInfo(companyService.getAllCompany(queryVo)));
    }

    @PostMapping("/add")
    public ResBody insertProduct(@RequestBody Company company) {
        companyService.insertSelective(company);
        return ResBody.ok();
    }

    @PostMapping("/update")
    public ResBody updateProduct(@RequestBody Company company) {
        companyService.updateByPrimaryKeySelective(company);
        return ResBody.ok();
    }

    @PostMapping("/deleteBatch")
    public ResBody deleteBatch(@RequestBody List<Integer> ids) {
        companyService.deleteBatch(ids);
        return ResBody.ok();
    }

}
