package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.Component;
import com.archforce.arc.facility.entity.avm.Product;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComponentMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Component record);

    Component selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Component record);

    Page<Component> selectAllComponents(Component record);

    void deleteBatch(@Param("ids") List<Integer> ids);
}