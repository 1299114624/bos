package com.archforce.arc.facility.controller;

import com.archforce.arc.facility.entity.avm.company.CompanyComponent;
import com.archforce.arc.facility.entity.avm.company.CompanyComponentInfo;
import com.archforce.arc.facility.service.company.CompanyComponentService;
import com.archforce.common.utils.PageInfo;
import com.archforce.common.utils.QueryVo;
import com.archforce.common.utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addCompanyCom")
    public ResBody addCompanyCom(@RequestBody List<CompanyComponent> companyComponents) {
        return ResBody.ok(companyComponentService.batchInsert(companyComponents));
    }

    @PostMapping("/delete/{id}")
    public ResBody deleteByPrimaryKey(@PathVariable("id") Integer id) {
        companyComponentService.deleteByPrimaryKey(id);
        return ResBody.ok();
    }
}
