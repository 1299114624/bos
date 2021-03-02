package com.archforce.arc.facility.service.cache;

import com.archforce.arc.facility.entity.vo.FunctionVo;
import com.archforce.arc.facility.mapper.avm.FunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

public class FunctionCache {
    @Autowired
    FunctionMapper functionMapper;

    private List<FunctionVo> allFunctions;

    @PostConstruct
    public void load() {
//        allFunctions = functionMapper
    }
}
