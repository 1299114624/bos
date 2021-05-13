package com.archforce.arc.facility.entity.avm.product;

import com.archforce.arc.facility.entity.avm.component.Component;

public class ProductComponentInfo extends Component {
    private Integer productId;
    private Integer productComponentId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductComponentId() {
        return productComponentId;
    }

    public void setProductComponentId(Integer productComponentId) {
        this.productComponentId = productComponentId;
    }
}
