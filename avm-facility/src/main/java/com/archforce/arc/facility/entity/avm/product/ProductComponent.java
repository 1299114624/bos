package com.archforce.arc.facility.entity.avm.product;

/**
 * t_product_component
 */
public class ProductComponent {
    /**
     * id
     */
    private Integer id;

    /**
     * productId
     */
    private Integer productId;

    /**
     * componentId
     */
    private Integer componentId;

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

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }
}