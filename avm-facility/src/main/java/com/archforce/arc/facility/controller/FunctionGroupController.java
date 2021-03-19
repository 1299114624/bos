package com.archforce.arc.facility.controller;

import com.archforce.arc.facility.entity.avm.function.FunctionGroup;
import com.archforce.arc.facility.entity.avm.product.Product;
import com.archforce.arc.facility.service.function.FunctionGroupService;
import com.archforce.arc.facility.utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/functionGroup")
public class FunctionGroupController {
    @Autowired
    private FunctionGroupService functionGroupService;

    @PostMapping("/showTree")
    public ResBody showTree() {
        return ResBody.ok(functionGroupService.showTree());
    }

    @PostMapping("/add")
    public ResBody insertSelective(@RequestBody FunctionGroup functionGroup) {
        functionGroupService.insertSelective(functionGroup);
        return ResBody.ok();
    }

    @PostMapping("/update")
    public ResBody updateByPrimaryKeySelective(@RequestBody FunctionGroup functionGroup) {
        functionGroupService.updateByPrimaryKeySelective(functionGroup);
        return ResBody.ok();
    }

    @PostMapping("/delete/{id}")
    public ResBody deleteByPrimaryKey(@RequestBody Map<String, List<Integer>> paramMap,
            @PathVariable("id") Integer id) {
        functionGroupService.deleteByPrimaryKey(id, paramMap);
        return ResBody.ok();
    }
}
