package com.archforce.arc.facility.controller;

import com.archforce.arc.facility.entity.avm.product.ProductComponent;
import com.archforce.arc.facility.entity.avm.product.ProductComponentInfo;
import com.archforce.arc.facility.service.product.ProductComponentService;
import com.archforce.common.utils.PageInfo;
import com.archforce.common.utils.QueryVo;
import com.archforce.common.utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productComponent")
public class ProductComponentController {
    @Autowired
    private ProductComponentService productComponentService;

    @PostMapping("/getProductCom")
    public ResBody getComByProduct(@RequestBody QueryVo<ProductComponentInfo> queryVo) {
        return ResBody.ok(PageInfo.getPageInfo(productComponentService.getProductCom(queryVo)));
    }

    @PostMapping("/getDisProductCom")
    public ResBody getDisComByProduct(@RequestBody ProductComponentInfo productComponentInfo) {
        return ResBody.ok(productComponentService.getDisProductCom(productComponentInfo));
    }

    @PostMapping("/addProductCom")
    public ResBody addProductCom(@RequestBody List<ProductComponent> productComponents) {
        return ResBody.ok(productComponentService.batchInsert(productComponents));
    }

    @PostMapping("/delete/{id}")
    public ResBody deleteByPrimaryKey(@PathVariable("id") Integer id) {
        productComponentService.deleteByPrimaryKey(id);
        return ResBody.ok();
    }
}
