package com.archforce.arc.facility.service.common.impl;

import com.alibaba.fastjson.JSONArray;
import com.archforce.arc.facility.entity.common.Dict;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.archforce.arc.facility.mapper.avm.DictMapper;
import com.archforce.arc.facility.service.common.DictService;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DictServiceImpl implements DictService{

    @Resource
    private DictMapper dictMapper;

    @Override
    public JSONArray selectAllDict() {
        JSONArray allDict = dictMapper.selectAllDict();
        return allDict;
    }

    @Override
    public List<Dict> selectByCode(String categoryCode) {
        Dict dict = new Dict();
        dict.setCategoryCode(categoryCode);
        return dictMapper.selectByCode(dict);
    }

    @Override
    public Map<String, String> selectDictMap(String categoryCode) {
        List<Dict> dictList = selectByCode(categoryCode);
        Map<String, String> dictMap = new HashMap<>();
        if (CollectionUtils.isEmpty(dictList)) {
            return new HashMap<>();
        }
        for (Dict dict : dictList) {
            dictMap.put(dict.getDictValue(), dict.getDictName());
        }
        return dictMap;
    }
}
