package com.archforce.arc.facility.service.function.impl;

import com.archforce.arc.facility.entity.avm.function.FunctionCompany;
import com.archforce.arc.facility.entity.avm.function.FunctionComponent;
import com.archforce.arc.facility.entity.avm.function.FunctionFunctionGroup;
import com.archforce.arc.facility.entity.vo.FunctionVo;
import com.archforce.arc.facility.exception.BusinessException;
import com.archforce.arc.facility.mapper.avm.FunctionCompanyMapper;
import com.archforce.arc.facility.mapper.avm.FunctionComponentMapper;
import com.archforce.arc.facility.mapper.avm.FunctionFunctionGroupMapper;
import com.archforce.arc.facility.mapper.avm.FunctionMapper;
import com.archforce.arc.facility.service.cache.FunctionCache;
import com.archforce.arc.facility.service.function.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.archforce.arc.facility.exception.ErrorCodeConstant.FUNCTION_CODE_EXIT;
import static com.archforce.arc.facility.exception.ErrorCodeConstant.FUNCTION_NAME_EXIT;

@Service
public class FunctionServiceImpl implements FunctionService{

    @Resource
    private FunctionMapper functionMapper;

    @Resource
    private FunctionFunctionGroupMapper functionFunctionGroupMapper;

    @Resource
    private FunctionComponentMapper functionComponentMapper;
    @Resource
    private FunctionCompanyMapper functionCompanyMapper;

    @Autowired
    FunctionCache functionCache;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Integer id) {
        int i = functionMapper.deleteByPrimaryKey(id);
        //删除功能与分组的父子关系
        FunctionFunctionGroup functionFunctionGroup = functionFunctionGroupMapper.selectByFunctionId(id);
        if (Objects.nonNull(functionFunctionGroup)) {
            functionFunctionGroupMapper.deleteByFunctionId(id);
        }
        //删除功能与组件的关联关系
        List<FunctionComponent> functionComponents = functionComponentMapper.selectByFunctionId(id);
        if (functionComponents != null && functionComponents.size()>0) {
            functionComponentMapper.deleteByFunctionId(id);
        }
        // 删除功能与客户的关联关系
        List<FunctionCompany> functionCompanies = functionCompanyMapper.selectByFunctionId(id);
        if (functionCompanies != null && functionCompanies.size()>0) {
            functionCompanyMapper.deleteByFunctionId(id);
        }
        functionCache.load();
        return i;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(FunctionVo record) {
//        Function function = new Function();
//        BeanUtils.copyProperties(record, function);
        // 校验
        FunctionVo functionVo = functionMapper.selectByFunctionCode(record.getFunctionCode());
        FunctionVo functionVo1 = functionMapper.selectByFunctionName(record.getFunctionName());
        if (Objects.nonNull(functionVo)) {
            throw new BusinessException(FUNCTION_CODE_EXIT);
        }else if (Objects.nonNull(functionVo1)) {
            throw new BusinessException(FUNCTION_NAME_EXIT);
        }

        int i = functionMapper.insertSelective(record);
        // 添加功能与分组的父子关系
        FunctionFunctionGroup functionFunctionGroup = new FunctionFunctionGroup();
        functionFunctionGroup.setFunctionId(record.getId());
        functionFunctionGroup.setFunctionGroupId(record.getParentId());
        functionFunctionGroupMapper.insert(functionFunctionGroup);

        // 添加功能与组件的关联关系
        batchInsertFunctionComponent(record);

        // 添加功能与客户的关联关系
        batchInsertFunctionCompany(record);

        functionCache.load();
        return i;
    }


    @Override
    public FunctionVo selectByPrimaryKey(Integer id) {
        FunctionVo functionVo = functionMapper.selectByPrimaryKey(id);
        List<FunctionComponent> functionComponents = functionComponentMapper.selectByFunctionId(id);
        List<FunctionCompany> functionCompanies = functionCompanyMapper.selectByFunctionId(id);
        if (functionComponents != null) {
            functionVo.setComponentIds(functionComponents.stream().map(v -> {
                return v.getComponentId() + "";
            }).collect(Collectors.joining(",")));
            functionVo.setComponentNames(functionComponents.stream().map(v -> {
                return v.getComponentName();
            }).collect(Collectors.joining(",")));
        }
        if (functionCompanies != null) {
            functionVo.setCompanyIds(functionCompanies.stream().map(v -> {
                return v.getCompanyId() + "";
            }).collect(Collectors.joining(",")));
            functionVo.setCompanyNames(functionCompanies.stream().map(v -> {
                return v.getCompanyName();
            }).collect(Collectors.joining(",")));
        }

        return functionVo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(FunctionVo record) {
        int i = functionMapper.updateByPrimaryKeySelective(record);
        // 修改功能与组件的关联关系
        List<FunctionComponent> functionComponents = functionComponentMapper.selectByFunctionId(record.getId());
        if (functionComponents != null && functionComponents.size()>0) {
            functionComponentMapper.deleteByFunctionId(record.getId());
        }
        batchInsertFunctionComponent(record);

        // 修改功能与客户的关联关系
        List<FunctionCompany> functionCompanies = functionCompanyMapper.selectByFunctionId(record.getId());
        if (functionCompanies != null && functionCompanies.size()>0) {
            functionCompanyMapper.deleteByFunctionId(record.getId());
        }
        batchInsertFunctionCompany(record);
        functionCache.load();
        return i;
    }

    /**
     * 添加功能与组件的关联关系
     * @param record
     */
    private void batchInsertFunctionComponent(FunctionVo record) {
        List<FunctionComponent> functionComponents = new ArrayList<>();
        String componentIds = record.getComponentIds();
        if (componentIds == null || componentIds == "") return;

        Arrays.asList(componentIds.split(",")).stream().forEach(v -> {
            FunctionComponent functionComponent = new FunctionComponent();
            functionComponent.setFunctionId(record.getId());
            functionComponent.setComponentId(Integer.parseInt(v));
            functionComponents.add(functionComponent);
        });
        functionComponentMapper.batchInsert(functionComponents);
    }

    /**
     * 添加功能与客户的关联关系
     * @param record
     */
    private void batchInsertFunctionCompany(FunctionVo record) {
        List<FunctionCompany> functionCompanies = new ArrayList<>();
        String companyIds = record.getCompanyIds();
        if (companyIds == null || companyIds == "") return;

        Arrays.asList(companyIds.split(",")).stream().forEach(v -> {
            FunctionCompany functionCompany = new FunctionCompany();
            functionCompany.setFunctionId(record.getId());
            functionCompany.setCompanyId(Integer.parseInt(v));
            functionCompanies.add(functionCompany);
        });
        functionCompanyMapper.batchInsert(functionCompanies);
    }
}
