package com.archforce.arc.facility.service.component;

import com.archforce.arc.facility.entity.avm.component.Component;
import com.archforce.arc.facility.entity.vo.ComponentVo;
import com.archforce.common.utils.QueryVo;
import com.github.pagehelper.Page;

import java.util.List;

public interface ComponentService{

    Page<ComponentVo> getAllComponnet(QueryVo<Component> queryVo);

    void deleteBatch(List<Integer> ids);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(ComponentVo record);

    Component selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ComponentVo record);

    List<Component> getAllComponnetList();
}
