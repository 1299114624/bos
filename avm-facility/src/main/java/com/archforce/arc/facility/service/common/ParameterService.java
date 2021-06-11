package com.archforce.arc.facility.service.common;

import com.archforce.arc.facility.entity.avm.Parameter;

public interface ParameterService {
    Parameter selectByName(String name);

    /**
     * 组件参数名获取参数值
     */
    String getParameterValue(String name);

    void update(String name, String value);
}
