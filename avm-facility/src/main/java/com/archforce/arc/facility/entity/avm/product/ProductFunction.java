package com.archforce.arc.facility.entity.avm.product;

/**
 * t_product_function
 */
public class ProductFunction {
    /**
     * id
     */
    private Integer id;

    /**
     * productId
     */
    private Integer productId;

    /**
     * functionId
     */
    private Integer functionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }
}