package com.archforce.arc.facility.controller;

import com.archforce.arc.facility.entity.avm.component.Component;
import com.archforce.arc.facility.entity.vo.ComponentVo;
import com.archforce.arc.facility.service.component.ComponentService;
import com.archforce.common.utils.PageInfo;
import com.archforce.common.utils.QueryVo;
import com.archforce.common.utils.ResBody;
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
        return ResBody.ok(PageInfo.getPageInfo(componentService.getAllComponnet(queryVo)));
    }
    @PostMapping("/list")
    public ResBody listProducts() {
        return ResBody.ok(componentService.getAllComponnetList());
    }

    @PostMapping("/add")
    public ResBody insertSelective(@RequestBody ComponentVo componentVo) {
        componentService.insertSelective(componentVo);
        return ResBody.ok();
    }

    @PostMapping("/update")
    public ResBody updateByPrimaryKeySelective(@RequestBody ComponentVo componentVo) {
        componentService.updateByPrimaryKeySelective(componentVo);
        return ResBody.ok();
    }

    @PostMapping("/deleteBatch")
    public ResBody deleteBatch(@RequestBody List<Integer> ids) {
        componentService.deleteBatch(ids);
        return ResBody.ok();
    }
}
