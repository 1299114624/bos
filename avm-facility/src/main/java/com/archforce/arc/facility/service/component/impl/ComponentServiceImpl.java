package com.archforce.arc.facility.service.component.impl;

import cn.hutool.json.JSONUtil;
import com.archforce.arc.common.exception.ApplicationException;
import com.archforce.arc.common.exception.FileHandlerException;
import com.archforce.arc.common.log.LogUtils;
import com.archforce.arc.facility.entity.avm.component.ComponentImportTemp;
import com.archforce.arc.facility.entity.common.Files;
import com.archforce.arc.facility.mapper.avm.ComponentMapper;
import com.archforce.arc.facility.entity.avm.component.ComponentCompany;
import com.archforce.arc.facility.entity.vo.ComponentVo;
import com.archforce.arc.common.exception.BusinessException;
import com.archforce.arc.facility.mapper.avm.ComponentCompanyMapper;
import com.archforce.arc.facility.mapper.avm.FilesMapper;
import com.archforce.arc.facility.mapper.avm.FunctionComponentMapper;
import com.archforce.arc.common.utils.QueryVo;
import com.archforce.arc.common.utils.Sort;
import com.archforce.arc.facility.util.Constant;
import com.archforce.arc.facility.util.ExcelUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.archforce.arc.facility.entity.avm.component.Component;
import com.archforce.arc.facility.service.component.ComponentService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.*;

import static com.archforce.arc.common.exception.ErrorCodeConstant.COMPONENT_NAME_EXIT;

@Service
public class ComponentServiceImpl implements ComponentService{

    @Resource
    private ComponentMapper componentMapper;

    @Resource
    private FunctionComponentMapper functionComponentMapper;

    @Resource
    private ComponentCompanyMapper componentCompanyMapper;

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
            componentVo.setCompanyNames(componentCompanyMapper.selectCompanyNamesByComponentId(componentVo.getId()));
            componentVo.setCompanyIds(componentCompanyMapper.selectCompanyIdsByComponentId(componentVo.getId()));
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
        ids.stream().forEach(id -> {
            List<ComponentCompany> componentCompanies = componentCompanyMapper.selectByComponentId(id);
            if (componentCompanies != null && componentCompanies.size() > 0) {
                componentCompanyMapper.deleteByComponentId(id);
            }
        });
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return componentMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(ComponentVo record) {
        Component component = componentMapper.selectByComponentName(record.getComponentName());
        if (Objects.nonNull(component)) {
            throw new BusinessException(COMPONENT_NAME_EXIT);
        }
        int i = componentMapper.insertSelective(record);
        // 添加组件与客户的关联关系
        batchInsertComponentCompany(record);
        return i;
    }


    @Override
    public Component selectByPrimaryKey(Integer id) {
        return componentMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(ComponentVo record) {
        int i = componentMapper.updateByPrimaryKeySelective(record);
        // 校验
        try {
            componentMapper.selectByComponentName(record.getComponentName());
        } catch (Exception e) {
            throw new BusinessException(COMPONENT_NAME_EXIT);
        }
        List<ComponentCompany> componentCompanies = componentCompanyMapper.selectByComponentId(record.getId());
        if (componentCompanies != null && componentCompanies.size() > 0) {
            componentCompanyMapper.deleteByComponentId(record.getId());
        }
        batchInsertComponentCompany(record);
        return i;
    }

    /**
     * 添加功能与客户的关联关系
     * @param record
     */
    private void batchInsertComponentCompany(ComponentVo record) {
        List<ComponentCompany> componentCompanies = new ArrayList<>();
        String companyIds = record.getCompanyIds();
        if (companyIds == null || companyIds == "") return;

        Arrays.asList(companyIds.split(",")).stream().forEach(v -> {
            ComponentCompany componentCompany = new ComponentCompany();
            componentCompany.setComponentId(record.getId());
            componentCompany.setCompanyId(Integer.parseInt(v));
            componentCompanies.add(componentCompany);
        });
        componentCompanyMapper.batchInsert(componentCompanies);
    }


}
