package com.archforce.arc.facility.controller;

import com.archforce.arc.facility.service.product.ProductFunctionService;
import com.archforce.common.utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productFunction")
public class ProductFunctionController {
    @Autowired
    ProductFunctionService productFunctionService;

    @PostMapping("/getProductFunction/{productId}")
    public ResBody getProductFunction(@PathVariable("productId") Integer productId) {
        return ResBody.ok(productFunctionService.getProductFunction(productId));
    }
}
