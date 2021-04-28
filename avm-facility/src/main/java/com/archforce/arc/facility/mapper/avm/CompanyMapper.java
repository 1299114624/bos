package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.company.Company;
import com.archforce.arc.facility.entity.avm.product.Product;
import com.archforce.arc.facility.entity.vo.CompanyVo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyMapper {
    Page<Company> selectAllCompanys(CompanyVo record);

    List<Company> selectAllCompanyList();

    void deleteBatch(@Param("ids") List<Integer> ids);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);
}