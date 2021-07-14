package com.archforce.arc.facility.service.company;

import com.archforce.arc.facility.entity.vo.CompanyVo;
import com.archforce.arc.facility.entity.avm.company.Company;
import com.archforce.arc.common.utils.QueryVo;
import com.github.pagehelper.Page;

import java.util.List;

public interface CompanyService{
    Page<Company> getAllCompany(QueryVo<CompanyVo> queryVo);

    List<Company> getAllCompanyList();

    void deleteBatch(List<Integer> ids);

    int insertSelective(CompanyVo record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyVo record);

}
