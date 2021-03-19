package com.archforce.arc.facility.service.component;

import com.archforce.arc.facility.entity.avm.component.Component;
import com.archforce.arc.facility.utils.QueryVo;
import com.github.pagehelper.Page;

import java.util.List;

public interface ComponentService{

    Page<Component> getAllComponnet(QueryVo<Component> queryVo);

    void deleteBatch(List<Integer> ids);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Component record);

    Component selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Component record);

    List<Component> getAllComponnetList();
}
