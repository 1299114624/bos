package com.archforce.arc.facility.controller;

import com.archforce.arc.facility.entity.avm.function.Function;
import com.archforce.arc.facility.entity.avm.function.FunctionGroup;
import com.archforce.arc.facility.entity.vo.FunctionVo;
import com.archforce.arc.facility.service.function.FunctionService;
import com.archforce.arc.facility.utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/function")
public class FunctionController {
    @Autowired
    private FunctionService functionService;

    @PostMapping("/getById/{id}")
    public ResBody selectByPrimaryKey(@PathVariable("id") Integer id) {
        return ResBody.ok(functionService.selectByPrimaryKey(id));
    }

    @PostMapping("/add")
    public ResBody insertSelective(@RequestBody FunctionVo functionVo) {
        functionService.insertSelective(functionVo);
        return ResBody.ok();
    }

    @PostMapping("/update")
    public ResBody updateByPrimaryKeySelective(@RequestBody FunctionVo functionVo) {
        functionService.updateByPrimaryKeySelective(functionVo);
        return ResBody.ok();
    }

    @PostMapping("/delete/{id}")
    public ResBody deleteByPrimaryKey(@PathVariable("id") Integer id) {
        functionService.deleteByPrimaryKey(id);
        return ResBody.ok();
    }
}
