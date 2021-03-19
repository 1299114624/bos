package com.archforce.arc.facility.controller;

import com.alibaba.fastjson.JSONArray;
import com.archforce.arc.facility.service.common.DictService;
import com.archforce.arc.facility.utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DictController {
    @Autowired
    private DictService dictService;

    @PostMapping("/allDicts")
    public ResBody allDicts() {
        JSONArray allDict = dictService.selectAllDict();
        return ResBody.ok(allDict);
    }

}
