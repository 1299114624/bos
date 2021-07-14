package com.archforce.arc.facility.service.product.impl;

import com.archforce.arc.facility.entity.avm.product.Product;
import com.archforce.arc.common.exception.BusinessException;
import com.archforce.arc.facility.mapper.avm.ProductMapper;
import com.archforce.arc.facility.service.product.ProductService;
import com.archforce.arc.common.utils.QueryVo;
import com.archforce.arc.common.utils.Sort;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static com.archforce.arc.common.exception.ErrorCodeConstant.PRODUCT_SIMPLE_ENGLISH_NAME_EXIT;

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
    public List<Product> selectProductsByCompanyId(Integer id) {
        return productMapper.selectProductsByCompanyId(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertSelective(Product record) {
        //校验
        Product product = productMapper.selectBySimpleEnglishName(record.getSimpleEnglishName());
        if (Objects.nonNull(product)) {
            throw new BusinessException(PRODUCT_SIMPLE_ENGLISH_NAME_EXIT);
        }
        return productMapper.insertSelective(record);
    }

    @Override
    public Product selectByPrimaryKey(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        int i = productMapper.updateByPrimaryKeySelective(record);
        // 校验
        try {
            productMapper.selectBySimpleEnglishName(record.getSimpleEnglishName());
        } catch (Exception e) {
            throw new BusinessException(PRODUCT_SIMPLE_ENGLISH_NAME_EXIT);
        }
        return i;
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        productMapper.deleteBatch(ids);
    }
}



