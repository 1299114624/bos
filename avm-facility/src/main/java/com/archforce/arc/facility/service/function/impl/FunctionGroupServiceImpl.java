package com.archforce.arc.facility.service.function.impl;

import com.archforce.arc.facility.common.AvmTree;
import com.archforce.arc.facility.common.TreeUtils;
import com.archforce.arc.facility.entity.avm.function.FunctionFunctionGroup;
import com.archforce.arc.facility.entity.vo.FunctionVo;
import com.archforce.arc.facility.exception.BusinessException;
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

import static com.archforce.arc.facility.exception.ErrorCodeConstant.FUNCTION_GROUP_NAME_EXIT;

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
    public int deleteByPrimaryKey(Integer id) {
        return functionGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(FunctionGroup record) {
        //校验
        FunctionGroup functionGroup = functionGroupMapper.selectByGroupName(record.getGroupName());
        if (Objects.nonNull(functionGroup)) {
            throw new BusinessException(FUNCTION_GROUP_NAME_EXIT);
        }

        UUID uuid = UUID.randomUUID();
        record.setGroupCode(uuid.toString());
        return functionGroupMapper.insertSelective(record);
    }

    @Override
    public FunctionGroup selectByPrimaryKey(Integer id) {
        return functionGroupMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(FunctionGroup record) {
        int i = functionGroupMapper.updateByPrimaryKeySelective(record);
        // 校验
        try {
            functionGroupMapper.selectByGroupName(record.getGroupName());
        } catch (Exception e) {
            throw new BusinessException(FUNCTION_GROUP_NAME_EXIT);
        }
        return i;
    }

    @Override
    public int checkAddType(Integer id) {
        FunctionGroup functionGroup = functionGroupMapper.selectByPrimaryKey(id);
        String groupCode = functionGroup.getGroupCode();
        List<FunctionFunctionGroup> functionFunctionGroups = functionFunctionGroupMapper.selectByFunctionGroupId(id);
        List<FunctionGroup> functionGroups = functionGroupMapper.selectByParentCode(groupCode);

        if ((functionFunctionGroups.size() == 0 && functionGroups.size() == 0)
        || groupCode.equals("commonFunctionGroup") || groupCode.equals("customerFunctionGroup")) {
            return 2;
        } else if (functionFunctionGroups.size() > 0) {
            return 0;
        } else {
            return 1;
        }
    }

}
