package com.archforce.arc.facility.controller;

import com.archforce.arc.facility.entity.avm.function.FunctionGroup;
import com.archforce.arc.facility.service.function.FunctionGroupService;
import com.archforce.common.utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/functionGroup")
public class FunctionGroupController {
    @Autowired
    private FunctionGroupService functionGroupService;

    @PostMapping("/showTree")
    public ResBody showTree() {
        return ResBody.ok(functionGroupService.showTree());
    }

    @PostMapping("/checkAddType/{id}")
    public ResBody checkAddType(@PathVariable("id") Integer id) {
        return ResBody.ok(functionGroupService.checkAddType(id));
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
//    public ResBody deleteByPrimaryKey(@RequestBody Map<String, List<Integer>> paramMap, @PathVariable("id") Integer id) {
    public ResBody deleteByPrimaryKey(@PathVariable("id") Integer id) {
        functionGroupService.deleteByPrimaryKey(id);
        return ResBody.ok();
    }
}
