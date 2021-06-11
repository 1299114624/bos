package com.archforce.bos.identity.service.impl;

import com.archforce.bos.identity.service.IdentityParameterService;
import org.springframework.stereotype.Service;

/**
 * 用于获取BOS中的t_parameter的参数
 */
@Service("defaultParameterService")
public class IdentityParameterServiceImpl implements IdentityParameterService {

    @Override
    public String getParameterValue(String name) {
        return null;
    }
}
