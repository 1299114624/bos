package com.archforce.arc.facility.controller;

import com.archforce.arc.facility.entity.avm.company.CompanyComponentInfo;
import com.archforce.arc.facility.entity.vo.CompanyVo;
import com.archforce.arc.facility.service.company.CompanyComponentService;
import com.archforce.arc.facility.service.company.CompanyService;
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
@RequestMapping("/companyComponent")
public class CompanyComponentController {
    @Autowired
    private CompanyComponentService companyComponentService;

    @PostMapping("/getCompanyCom")
    public ResBody getComByProduct(@RequestBody QueryVo<CompanyComponentInfo> queryVo) {
        return ResBody.ok(PageInfo.getPageInfo(companyComponentService.getCompanyCom(queryVo)));
    }

    @PostMapping("/getDisCompanyCom")
    public ResBody getDisComByProduct(@RequestBody CompanyComponentInfo companyComponentInfo) {
        return ResBody.ok(companyComponentService.getDisCompanyCom(companyComponentInfo));
    }


}
