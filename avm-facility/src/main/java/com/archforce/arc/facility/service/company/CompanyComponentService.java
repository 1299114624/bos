package com.archforce.arc.facility.service.company;

import java.util.List;
import com.archforce.arc.facility.entity.avm.company.CompanyComponent;
import com.archforce.arc.facility.entity.avm.company.CompanyComponentInfo;
import com.archforce.common.utils.QueryVo;
import com.github.pagehelper.Page;

public interface CompanyComponentService{


    int deleteByPrimaryKey(Integer id);

    CompanyComponent selectByPrimaryKey(Integer id);

    int batchInsert(List<CompanyComponent> list);

    Page<CompanyComponentInfo> getCompanyCom(QueryVo<CompanyComponentInfo> queryVo);


    List<CompanyComponentInfo> getDisCompanyCom(CompanyComponentInfo companyComponentInfo);
}
