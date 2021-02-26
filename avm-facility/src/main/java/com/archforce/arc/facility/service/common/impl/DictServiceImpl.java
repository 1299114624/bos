package com.archforce.arc.facility.service.common.impl;

import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.archforce.arc.facility.mapper.avm.DictMapper;
import com.archforce.arc.facility.service.common.DictService;
@Service
public class DictServiceImpl implements DictService{

    @Resource
    private DictMapper dictMapper;

    @Override
    public JSONArray selectAllDict() {
        JSONArray allDict = dictMapper.selectAllDict();
        return allDict;
    }
}
