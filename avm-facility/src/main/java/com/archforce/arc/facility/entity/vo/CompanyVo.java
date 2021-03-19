package com.archforce.arc.facility.entity.vo;

import com.archforce.arc.facility.entity.avm.company.Company;
import com.archforce.arc.facility.entity.avm.product.Product;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyVo extends Company {
    private List<Product> products;
    private List<Integer> productIdList;

    public String getProductNames() {
        if (products != null && products.size()>0) {
            return products.stream().map(v -> v.getSimpleEnglishName()).collect(Collectors.joining("，"));
        } else {
            return "";
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Integer> getProductIdList() {
//        if (products != null && products.size()>0) {
//            return products.stream().map(v -> v.getId()).collect(Collectors.toList());
//        } else {
//            return new ArrayList<>();
//        }
        return productIdList;
    }

    public void setProductIdList(List<Integer> productIdList) {
        this.productIdList = productIdList;
    }
}
