package com.archforce.arc.facility.controller;

import com.archforce.arc.facility.entity.avm.Component;
import com.archforce.arc.facility.entity.avm.Product;
import com.archforce.arc.facility.service.component.ComponentService;
import com.archforce.arc.facility.service.product.ProductService;
import com.archforce.arc.facility.utils.PageInfo;
import com.archforce.arc.facility.utils.QueryVo;
import com.archforce.arc.facility.utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/component")
public class ComponentController {
    @Autowired
    private ComponentService componentService;

    @PostMapping("/page")
    public ResBody pageProducts(@RequestBody QueryVo<Component> queryVo) {
        return ResBody.ok(PageInfo.getPageInfo(componentService.getAllProduct(queryVo)));
    }

    @PostMapping("/add")
    public ResBody insertProduct(@RequestBody Component component) {
        componentService.insertSelective(component);
        return ResBody.ok();
    }

    @PostMapping("/update")
    public ResBody updateProduct(@RequestBody Component component) {
        componentService.updateByPrimaryKeySelective(component);
        return ResBody.ok();
    }

    @PostMapping("/deleteBatch")
    public ResBody deleteBatch(@RequestBody List<Integer> ids) {
        componentService.deleteBatch(ids);
        return ResBody.ok();
    }
}
