package com.archforce.arc.facility.controller;

import com.archforce.arc.facility.entity.avm.product.Product;
import com.archforce.arc.facility.service.product.ProductService;
import com.archforce.arc.facility.utils.PageInfo;
import com.archforce.arc.facility.utils.QueryVo;
import com.archforce.arc.facility.utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/page")
    public ResBody pageProducts(@RequestBody QueryVo<Product> queryVo) {
        return ResBody.ok(PageInfo.getPageInfo(productService.getAllProduct(queryVo)));
    }

    @PostMapping("/list")
    public ResBody listProducts() {
        return ResBody.ok(productService.getAllProductList());
    }

    @PostMapping("/add")
    public ResBody insertProduct(@RequestBody Product product) {
        productService.insertSelective(product);
        return ResBody.ok();
    }

    @PostMapping("/update")
    public ResBody updateProduct(@RequestBody Product product) {
        productService.updateByPrimaryKeySelective(product);
        return ResBody.ok();
    }

    @PostMapping("/deleteBatch")
    public ResBody deleteBatch(@RequestBody List<Integer> ids) {
        productService.deleteBatch(ids);
        return ResBody.ok();
    }
}
