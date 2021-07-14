package com.archforce.arc.facility.service.common;

import com.alibaba.fastjson.JSONArray;
import com.archforce.arc.facility.entity.common.Dict;

import java.util.List;
import java.util.Map;

public interface DictService{

    JSONArray selectAllDict();

    List<Dict> selectByCode(String categoryCode);

    Map<String, String> selectDictMap(String categoryCode);
}
