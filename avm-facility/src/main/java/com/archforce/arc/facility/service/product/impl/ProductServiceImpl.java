package com.archforce.arc.facility.service.product.impl;

import com.archforce.arc.facility.entity.avm.Product;
import com.archforce.arc.facility.mapper.avm.ProductMapper;
import com.archforce.arc.facility.service.product.ProductService;
import com.archforce.arc.facility.utils.QueryVo;
import com.archforce.arc.facility.utils.Sort;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Page<Product> getAllProduct(QueryVo<Product> queryVo) {
        queryVo.resetPage();
        Product query = queryVo.getQuery();
        Sort sort = queryVo.getSort();
        String sortInfo = QueryVo.getSortTableFiled(sort.getKey()) + " " +sort.getSortType().name();
        PageHelper.orderBy(sortInfo);
        return productMapper.selectAllProducts(query);
    }

    @Override
    public List<Product> getAllProductList() {
        return productMapper.selectAllProductList();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertSelective(Product record) {
        return productMapper.insertSelective(record);
    }

    @Override
    public Product selectByPrimaryKey(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        productMapper.deleteBatch(ids);
    }
}



