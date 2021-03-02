package com.archforce.arc.facility.service.company.impl;

import com.archforce.arc.facility.entity.avm.Component;
import com.archforce.arc.facility.utils.QueryVo;
import com.archforce.arc.facility.utils.Sort;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.archforce.arc.facility.entity.avm.Company;
import com.archforce.arc.facility.mapper.avm.CompanyMapper;
import com.archforce.arc.facility.service.company.CompanyService;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Resource
    private CompanyMapper companyMapper;

    @Override
    public Page<Company> getAllCompany(QueryVo<Company> queryVo) {
        queryVo.resetPage();
        Company query = queryVo.getQuery();
        Sort sort = queryVo.getSort();
        String sortInfo = QueryVo.getSortTableFiled(sort.getKey()) + " " +sort.getSortType().name();
        PageHelper.orderBy(sortInfo);
        return companyMapper.selectAllCompanys(query);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        companyMapper.deleteBatch(ids);
    }

    @Override
    public int insertSelective(Company record) {
        return companyMapper.insertSelective(record);
    }

    @Override
    public Company selectByPrimaryKey(Integer id) {
        return companyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Company record) {
        return companyMapper.updateByPrimaryKeySelective(record);
    }

}
