package com.archforce.arc.facility.mapper.avm;

import com.alibaba.fastjson.JSONArray;
import com.archforce.arc.facility.entity.common.Dict;

import java.util.List;

public interface DictMapper {

    JSONArray selectAllDict();

    List<Dict> selectByCode(Dict dict);

}