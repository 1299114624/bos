package com.archforce.arc.facility.service.common.impl;

import com.archforce.arc.facility.entity.avm.Parameter;
import com.archforce.arc.facility.mapper.avm.ParameterMapper;
import com.archforce.arc.facility.service.common.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    private ParameterMapper parameterMapper;

    @Override
    public Parameter selectByName(String name) {
        final Parameter parameter = parameterMapper.selectByParamName(name);
        return parameter;
    }

    @Override
    public String getParameterValue(String name) {
        final Parameter parameter = parameterMapper.selectByParamName(name);
        if(parameter == null) return "";
        return parameter.getParaValue();
    }

    @Override
    public void update(String name, String value) {

    }
}
