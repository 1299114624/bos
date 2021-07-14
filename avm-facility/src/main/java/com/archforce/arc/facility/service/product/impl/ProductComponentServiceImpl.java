package com.archforce.arc.facility.service.product.impl;

import com.archforce.arc.facility.entity.avm.product.ProductComponentInfo;
import com.archforce.arc.facility.service.product.ProductComponentService;
import com.archforce.arc.common.utils.QueryVo;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.archforce.arc.facility.entity.avm.product.ProductComponent;
import com.archforce.arc.facility.mapper.avm.ProductComponentMapper;

@Service
public class ProductComponentServiceImpl implements ProductComponentService {

    @Resource
    private ProductComponentMapper productComponentMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productComponentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ProductComponent selectByPrimaryKey(Integer id) {
        return productComponentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int batchInsert(List<ProductComponent> list) {
        return productComponentMapper.batchInsert(list);
    }

    @Override
    public Page<ProductComponentInfo> getProductCom(QueryVo<ProductComponentInfo> queryVo) {
        queryVo.resetPage();
        ProductComponentInfo query = queryVo.getQuery();
        return productComponentMapper.getProductCom(query);
    }

    @Override
    public List<ProductComponentInfo> getDisProductCom(ProductComponentInfo productComponentInfo) {
        return productComponentMapper.getDisProductCom(productComponentInfo);
    }

}
