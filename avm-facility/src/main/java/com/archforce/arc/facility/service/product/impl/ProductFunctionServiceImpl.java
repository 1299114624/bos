package com.archforce.arc.facility.service.product.impl;

import com.archforce.arc.facility.common.TreeUtils;
import com.archforce.arc.facility.entity.vo.FunctionVo;
import com.archforce.arc.facility.mapper.avm.ProductMapper;
import com.archforce.arc.facility.service.cache.FunctionCache;
import com.archforce.arc.facility.service.product.ProductFunctionService;
import com.archforce.arc.facility.common.AvmTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.archforce.arc.facility.entity.avm.product.ProductFunction;

import java.util.ArrayList;
import java.util.List;

import com.archforce.arc.facility.mapper.avm.ProductFunctionMapper;

@Service
public class ProductFunctionServiceImpl implements ProductFunctionService {

    @Resource
    private ProductFunctionMapper productFunctionMapper;

    @Resource
    private ProductMapper productMapper;

    @Autowired
    FunctionCache functionCache;

    private AvmTree creat(String name, String code, Object node) {
        AvmTree tree = new AvmTree();
        tree.setCode(code);
        tree.setName(name);
        tree.setNode(node);
        return tree;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productFunctionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ProductFunction selectByPrimaryKey(Integer id) {
        return productFunctionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int batchInsert(List<ProductFunction> list) {
        return productFunctionMapper.batchInsert(list);
    }

    @Override
    public List<AvmTree> getProductFunction(Integer productId) {
        String simpleEnglishName = productMapper.selectByPrimaryKey(productId).getSimpleEnglishName();
        String ids = productFunctionMapper.selectFunctionIdsByProductIds(productId);
        List<FunctionVo> functionVos = new ArrayList<>();
        if ("" != ids && null != ids) {
            functionVos = functionCache.getByIds(ids);
        }
        List<FunctionVo> allFunctions = functionCache.getAllFunctions();
        List<AvmTree> avmTrees = TreeUtils.filterLeafTree(allFunctions, functionVos, true);
        AvmTree groot = creat(simpleEnglishName, "0", null);
        avmTrees.add(groot);
        return TreeUtils.listToTree(avmTrees, "0");
    }
}
