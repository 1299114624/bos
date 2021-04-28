package com.archforce.arc.facility.service.component.impl;

import com.archforce.arc.facility.entity.vo.ComponentVo;
import com.archforce.arc.facility.exception.BusinessException;
import com.archforce.arc.facility.mapper.avm.FunctionComponentMapper;
import com.archforce.arc.facility.utils.QueryVo;
import com.archforce.arc.facility.utils.Sort;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.archforce.arc.facility.mapper.avm.ComponentMapper;
import com.archforce.arc.facility.entity.avm.component.Component;
import com.archforce.arc.facility.service.component.ComponentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static com.archforce.arc.facility.exception.ErrorCodeConstant.COMPONENT_NAME_EXIT;
import static com.archforce.arc.facility.exception.ErrorCodeConstant.FUNCTION_GROUP_NAME_EXIT;

@Service
public class ComponentServiceImpl implements ComponentService{

    @Resource
    private ComponentMapper componentMapper;

    @Resource
    private FunctionComponentMapper functionComponentMapper;

    @Override
    public Page<ComponentVo> getAllComponnet(QueryVo<Component> queryVo) {
        queryVo.resetPage();
        Component query = queryVo.getQuery();
        Sort sort = queryVo.getSort();
        String sortInfo = QueryVo.getSortTableFiled(sort.getKey()) + " " +sort.getSortType().name();
        PageHelper.orderBy(sortInfo);
        Page<ComponentVo> components = componentMapper.selectAllComponents(query);
        List<ComponentVo> result = components.getResult();
        for(ComponentVo componentVo : result) {
            componentVo.setFunctionNames(functionComponentMapper.selectFunctionNamesByComponentId(componentVo.getId()));
        }
        return components;
    }
    @Override
    public List<Component> getAllComponnetList() {
        return componentMapper.selectAllComponentList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(List<Integer> ids) {
        functionComponentMapper.deleteBatchByComponentId(ids);
        componentMapper.deleteBatch(ids);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return componentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Component record) {
        Component component = componentMapper.selectByComponentName(record.getComponentName());
        if (Objects.nonNull(component)) {
            throw new BusinessException(COMPONENT_NAME_EXIT);
        }
        return componentMapper.insertSelective(record);
    }


    @Override
    public Component selectByPrimaryKey(Integer id) {
        return componentMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(Component record) {
        int i = componentMapper.updateByPrimaryKeySelective(record);
        // 校验
        try {
            componentMapper.selectByComponentName(record.getComponentName());
        } catch (Exception e) {
            throw new BusinessException(COMPONENT_NAME_EXIT);
        }
        return i;
    }



}
