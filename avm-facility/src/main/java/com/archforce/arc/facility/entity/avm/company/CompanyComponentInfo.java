package com.archforce.arc.facility.entity.avm.company;

import com.archforce.arc.facility.entity.avm.component.Component;

public class CompanyComponentInfo extends Component {
    private Integer companyId;
    private Integer productId;

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
