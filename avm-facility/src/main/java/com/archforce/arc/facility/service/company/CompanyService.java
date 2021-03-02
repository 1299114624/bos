package com.archforce.arc.facility.service.company;

import com.archforce.arc.facility.entity.avm.Company;
import com.archforce.arc.facility.entity.avm.Component;
import com.archforce.arc.facility.utils.QueryVo;
import com.github.pagehelper.Page;

import java.util.List;

public interface CompanyService{
    Page<Company> getAllCompany(QueryVo<Company> queryVo);

    void deleteBatch(List<Integer> ids);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);

}
