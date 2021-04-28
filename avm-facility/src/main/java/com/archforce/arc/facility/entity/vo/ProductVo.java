package com.archforce.arc.facility.entity.vo;

import com.archforce.arc.facility.entity.avm.product.Product;

public class ProductVo extends Product {
    private String usedCompanyNames;

    public String getUsedCompanyNames() {
        return usedCompanyNames;
    }

    public void setUsedCompanyNames(String usedCompanyNames) {
        this.usedCompanyNames = usedCompanyNames;
    }
}
