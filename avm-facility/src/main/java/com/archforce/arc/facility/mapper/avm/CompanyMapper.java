package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.Company;
import com.archforce.arc.facility.entity.avm.Component;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyMapper {
    Page<Company> selectAllCompanys(Company record);

    void deleteBatch(@Param("ids") List<Integer> ids);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);
}