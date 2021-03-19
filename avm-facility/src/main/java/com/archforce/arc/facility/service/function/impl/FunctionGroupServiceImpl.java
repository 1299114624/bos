package com.archforce.arc.facility.service.function.impl;

import com.archforce.arc.facility.common.AvmTree;
import com.archforce.arc.facility.common.TreeUtils;
import com.archforce.arc.facility.entity.vo.FunctionVo;
import com.archforce.arc.facility.mapper.avm.FunctionFunctionGroupMapper;
import com.archforce.arc.facility.mapper.avm.FunctionMapper;
import com.archforce.arc.facility.service.cache.FunctionCache;
import com.archforce.arc.facility.service.function.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.archforce.arc.facility.mapper.avm.FunctionGroupMapper;
import com.archforce.arc.facility.entity.avm.function.FunctionGroup;
import com.archforce.arc.facility.service.function.FunctionGroupService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
public class FunctionGroupServiceImpl implements FunctionGroupService{

    @Resource
    private FunctionGroupMapper functionGroupMapper;

    @Resource
    private FunctionFunctionGroupMapper functionFunctionGroupMapper;

    @Resource
    private FunctionService functionService;

    @Autowired
    FunctionCache functionCache;

    @Override
    public List<AvmTree> showTree() {
//        functionCache.load();
        List<FunctionGroup> functionGroups = functionGroupMapper.selectAllFunctionGroup();
        List<FunctionVo> allFunctions = functionCache.getAllFunctions();
        List<AvmTree> avmTrees = TreeUtils.treeCombine(functionGroups, allFunctions);
        return avmTrees;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Integer id, Map<String, List<Integer>> paramMap) {
        List<Integer> children = paramMap.get("children");
        if (children!= null && children.size()>0) {
            children.forEach(v -> {
                functionService.deleteByPrimaryKey(v);
            });
        }
        functionFunctionGroupMapper.deleteByFunctionGroupId(id);
        // 删除分组父子关系
        FunctionGroup functionGroup = functionGroupMapper.selectByPrimaryKey(id);
        List<FunctionGroup> functionGroups = functionGroupMapper.selectByParentCode(functionGroup.getGroupCode());
        if (Objects.nonNull(functionGroups)) {
            functionGroupMapper.deleteByParentCode(functionGroup.getGroupCode());
        }
        return functionGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(FunctionGroup record) {
        UUID uuid = UUID.randomUUID();
        record.setGroupCode(uuid.toString());
        return functionGroupMapper.insertSelective(record);
    }

    @Override
    public FunctionGroup selectByPrimaryKey(Integer id) {
        return functionGroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FunctionGroup record) {
        return functionGroupMapper.updateByPrimaryKeySelective(record);
    }

}
