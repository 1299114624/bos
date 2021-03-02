package com.archforce.arc.facility.controller;

import com.archforce.arc.facility.service.function.FunctionGroupService;
import com.archforce.arc.facility.utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/functionGroup")
public class FunctionGroupController {
    @Autowired
    FunctionGroupService functionGroupService;

    @PostMapping("/showTree")
    public ResBody showTree() {
        return ResBody.ok(functionGroupService.showTree());
    }
}
