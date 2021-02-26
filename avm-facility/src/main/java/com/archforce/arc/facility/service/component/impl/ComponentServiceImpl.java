package com.archforce.arc.facility.service.component.impl;

import com.archforce.arc.facility.entity.avm.Product;
import com.archforce.arc.facility.utils.QueryVo;
import com.archforce.arc.facility.utils.Sort;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.archforce.arc.facility.mapper.avm.ComponentMapper;
import com.archforce.arc.facility.entity.avm.Component;
import com.archforce.arc.facility.service.component.ComponentService;

import java.util.List;

@Service
public class ComponentServiceImpl implements ComponentService{

    @Resource
    private ComponentMapper componentMapper;

    @Override
    public Page<Component> getAllProduct(QueryVo<Component> queryVo) {
        queryVo.resetPage();
        Component query = queryVo.getQuery();
        Sort sort = queryVo.getSort();
        String sortInfo = QueryVo.getSortTableFiled(sort.getKey()) + " " +sort.getSortType().name();
        PageHelper.orderBy(sortInfo);
        return componentMapper.selectAllComponents(query);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        componentMapper.deleteBatch(ids);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return componentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Component record) {
        return componentMapper.insertSelective(record);
    }

    @Override
    public Component selectByPrimaryKey(Integer id) {
        return componentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Component record) {
        return componentMapper.updateByPrimaryKeySelective(record);
    }

}
