package com.archforce.arc.facility.service.cache;

import com.archforce.arc.facility.entity.vo.FunctionVo;
import com.archforce.arc.facility.mapper.avm.FunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class FunctionCache {
    @Autowired
    FunctionMapper functionMapper;

    private Map<String, FunctionVo> functionVoMap = new ConcurrentHashMap<>();

    private List<FunctionVo> allFunctions;

    @PostConstruct
    public void load() {
        allFunctions = functionMapper.selectAllFunctionVo();
        functionVoMap.clear();
        for (FunctionVo functionVo : allFunctions) {
            functionVoMap.put(functionVo.getFunctionCode(), functionVo);
        }
    }

    public List<FunctionVo> getAllFunctions() {
        return allFunctions;
    }

    public FunctionVo getByCode(String code) {
        return functionVoMap.get(code);
    }
}
