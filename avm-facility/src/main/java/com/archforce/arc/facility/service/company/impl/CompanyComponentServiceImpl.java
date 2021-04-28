package com.archforce.arc.facility.service.company.impl;

import com.archforce.arc.facility.entity.avm.company.CompanyComponentInfo;
import com.archforce.arc.facility.entity.avm.component.Component;
import com.archforce.arc.facility.utils.QueryVo;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.archforce.arc.facility.mapper.avm.CompanyComponentMapper;
import java.util.List;
import com.archforce.arc.facility.entity.avm.company.CompanyComponent;
import com.archforce.arc.facility.service.company.CompanyComponentService;
@Service
public class CompanyComponentServiceImpl implements CompanyComponentService{

    @Resource
    private CompanyComponentMapper companyComponentMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return companyComponentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CompanyComponent selectByPrimaryKey(Integer id) {
        return companyComponentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int batchInsert(List<CompanyComponent> list) {
        return companyComponentMapper.batchInsert(list);
    }

    @Override
    public Page<CompanyComponentInfo> getCompanyCom(QueryVo<CompanyComponentInfo> queryVo) {
        queryVo.resetPage();
        CompanyComponentInfo query = queryVo.getQuery();
        return companyComponentMapper.getCompanyCom(query);
    }

    @Override
    public List<CompanyComponentInfo> getDisCompanyCom(CompanyComponentInfo companyComponentInfo) {
        return companyComponentMapper.getDisCompanyCom(companyComponentInfo);
    }

}
