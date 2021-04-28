package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.component.Component;
import com.archforce.arc.facility.entity.vo.ComponentVo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComponentMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Component record);

    Component selectByPrimaryKey(Integer id);

    Component selectByComponentName(String name);

    int updateByPrimaryKeySelective(Component record);

    Page<ComponentVo> selectAllComponents(Component record);

    void deleteBatch(@Param("ids") List<Integer> ids);

    List<Component> selectAllComponentList();
}