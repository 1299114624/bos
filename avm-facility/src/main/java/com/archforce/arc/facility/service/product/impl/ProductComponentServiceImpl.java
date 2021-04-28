package com.archforce.arc.facility.service.product.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.archforce.arc.facility.entity.avm.product.ProductComponent;
import com.archforce.arc.facility.mapper.avm.ProductComponentMapper;
import com.archforce.arc.facility.service.product.ProductComponentService;
@Service
public class ProductComponentServiceImpl implements ProductComponentService{

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

}
