package com.archforce.arc.facility.service.common.impl;

import com.archforce.arc.facility.service.common.ParameterService;
import com.archforce.bos.identity.service.IdentityParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("IdentityParameterService")
public class IdentityParameterServiceImpl implements IdentityParameterService {

    /**
     * BOS 的数据字典服务
     */
    @Autowired
    private ParameterService parameterService;

    @Override
    public String getParameterValue(String name) {
        return parameterService.getParameterValue(name);
    }
}
