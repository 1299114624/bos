package com.archforce.arc.facility.service.company.impl;

import com.archforce.arc.facility.entity.avm.company.CompanyProduct;
import com.archforce.arc.facility.entity.vo.CompanyVo;
import com.archforce.arc.facility.mapper.avm.CompanyMapper;
import com.archforce.arc.facility.mapper.avm.CompanyProductMapper;
import com.archforce.common.utils.QueryVo;
import com.archforce.common.utils.Sort;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.archforce.arc.facility.entity.avm.company.Company;
import com.archforce.arc.facility.service.company.CompanyService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Resource
    private CompanyMapper companyMapper;

    @Resource
    CompanyProductMapper companyProductMapper;

    @Override
    public Page<Company> getAllCompany(QueryVo<CompanyVo> queryVo) {
        queryVo.resetPage();
        CompanyVo query = queryVo.getQuery();
        Sort sort = queryVo.getSort();
        String sortInfo = QueryVo.getSortTableFiled(sort.getKey()) + " " +sort.getSortType().name();
        PageHelper.orderBy(sortInfo);
        return companyMapper.selectAllCompanys(query);
    }

    @Override
    public List<Company> getAllCompanyList() {
        return companyMapper.selectAllCompanyList();
    }

    @Override
    @Transactional (rollbackFor = Exception.class)
    public void deleteBatch(List<Integer> ids) {
        // 删除客户选择的产品
        ids.stream().forEach(v -> {
            companyProductMapper.deleteByCompanyId(v);
        });
        companyMapper.deleteBatch(ids);
    }

    @Override
    @Transactional (rollbackFor = Exception.class)
    public int insertSelective(CompanyVo record) {
        // 校验
        // 添加客户
        int count = companyMapper.insertSelective(record);
        // 添加客户选择的产品
        batchInsertCompanyProduct(record);
        return count;
    }

    @Override
    public Company selectByPrimaryKey(Integer id) {
        return companyMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional (rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(CompanyVo record) {
        // 修改客户选择的产品
        companyProductMapper.deleteByCompanyId(record.getId());
        batchInsertCompanyProduct(record);
        record.setUpdateTime(new Date());
        // 修改客户
        return companyMapper.updateByPrimaryKeySelective(record);
    }

    private void batchInsertCompanyProduct(CompanyVo record) {
        List<Integer> productIdList = record.getProductIdList();
        List<CompanyProduct> companyProducts = new ArrayList<>();
        if (productIdList!= null && productIdList.size()>0) {
            productIdList.stream().forEach(v -> {
                CompanyProduct companyProduct = new CompanyProduct();
                companyProduct.setCompanyId(record.getId());
                companyProduct.setProductId(v);
                companyProducts.add(companyProduct);
            });
        }
        companyProductMapper.batchInsert(companyProducts);
    }
}
