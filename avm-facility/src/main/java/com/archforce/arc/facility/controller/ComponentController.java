package com.archforce.arc.facility.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/component")
public class ComponentController {
    @GetMapping("list")
    public String listAllComponent() {
        return "哈哈哈哈";
    }
}
