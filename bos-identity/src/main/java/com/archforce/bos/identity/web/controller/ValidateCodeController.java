package com.archforce.bos.identity.web.controller;

import com.alibaba.fastjson.JSON;
import com.archforce.arc.facility.utils.ResBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 不需要登录的校验接口
 */
@RestController
public class ValidateCodeController {

    @Value("${identity.login.validateCode:#{''}}")
    private String validateSwitch;

    /**
     * 获取当前的登录方式
     */
    @RequestMapping(path = "/getParam", method = RequestMethod.GET)
    public ResBody getParam() {
        Map<String, String> map = new HashMap<>();
        map.put("validateSwitch", validateSwitch);
        return ResBody.ok(JSON.toJSON(map));
    }
}
