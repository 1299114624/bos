package com.archforce.arc.facility.service.cache;

import com.archforce.arc.facility.entity.vo.FunctionVo;
import com.archforce.arc.facility.mapper.avm.FunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class FunctionCache {
    @Autowired
    FunctionMapper functionMapper;

    private Map<Integer, FunctionVo> functionVoMap = new ConcurrentHashMap<>();

    private List<FunctionVo> allFunctions;

    @PostConstruct
    public void load() {
        allFunctions = functionMapper.selectAllFunctionVo();
        functionVoMap.clear();
        for (FunctionVo functionVo : allFunctions) {
            functionVoMap.put(functionVo.getId(), functionVo);
        }
    }

    public List<FunctionVo> getAllFunctions() {
        return allFunctions;
    }

    public FunctionVo getById(Integer id) {
        return functionVoMap.get(id);
    }

    public List<FunctionVo> getByIds(String ids) {
        ArrayList<String> idList = new ArrayList<>(Arrays.asList(ids.split(",")));
        List<FunctionVo> collect = idList.stream().map(item -> {
            return functionVoMap.get(Integer.parseInt(item));
        }).collect(Collectors.toList());
        return collect;
    }
}
