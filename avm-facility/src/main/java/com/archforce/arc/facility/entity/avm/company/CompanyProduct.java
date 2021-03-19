package com.archforce.arc.facility.entity.avm.company;

/**
 * t_company_product
 */
public class CompanyProduct {
    /**
     * id
     */
    private Integer id;

    /**
     * companyId
     */
    private Integer companyId;

    /**
     * productId
     */
    private Integer productId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}