package com.archforce.arc.facility.controller;

import com.archforce.arc.facility.entity.avm.Product;
import com.archforce.arc.facility.service.ProductService;
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
}
