package com.archforce.arc.facility.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.archforce.arc.facility.entity.avm.component.Component;
import com.archforce.arc.facility.entity.vo.ComponentVo;
import com.archforce.arc.facility.service.common.DictService;
import com.archforce.arc.facility.service.component.ComponentService;
import com.archforce.arc.facility.util.ExcelExportUtils;
import com.archforce.arc.common.utils.PageInfo;
import com.archforce.arc.common.utils.QueryVo;
import com.archforce.arc.common.utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/component")
public class ComponentController {
    @Autowired
    private ComponentService componentService;

    @Autowired
    private DictService dictService;

    @PostMapping("/page")
    public ResBody pageProducts(@RequestBody QueryVo<Component> queryVo) {
        return ResBody.ok(PageInfo.getPageInfo(componentService.getAllComponnet(queryVo)));
    }
    @PostMapping("/list")
    public ResBody listProducts() {
        return ResBody.ok(componentService.getAllComponnetList());
    }

    @PostMapping("/add")
    public ResBody insertSelective(@RequestBody ComponentVo componentVo) {
        componentService.insertSelective(componentVo);
        return ResBody.ok();
    }

    @PostMapping("/update")
    public ResBody updateByPrimaryKeySelective(@RequestBody ComponentVo componentVo) {
        componentService.updateByPrimaryKeySelective(componentVo);
        return ResBody.ok();
    }

    @PostMapping("/deleteBatch")
    public ResBody deleteBatch(@RequestBody List<Integer> ids) {
        componentService.deleteBatch(ids);
        return ResBody.ok();
    }

    @PostMapping("/export")
    public void export(@RequestBody QueryVo<Component> query, HttpServletResponse response) {
        query.resetPage();
        query.getPage().setPageNumber(-1);
        List<ComponentVo> list = componentService.getAllComponnet(query);
        Map<String, String> languageTypeMap = dictService.selectDictMap("LanguageType");
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("componentName", "组件名称");
        dataMap.put("componentEnglishName", "组件英文全称");
        dataMap.put("languageType", "开发语言");
        dataMap.put("description", "组件说明");
        dataMap.put("chargeman", "组件负责人");
        dataMap.put("designSvnAddress", "设计文档SVN地址");
        dataMap.put("addTime", "创建时间");
        dataMap.put("updateTime", "最新修改时间");
        String excelName = "excel/componentList.xls";
        String fileName = "组件管理" + DateUtil.format(new Date(), "yyyyMMdd");
        JSONArray jsonArray = new JSONArray();
        if (!CollectionUtils.isEmpty(list)) {
            jsonArray = (JSONArray) JSON.toJSON(list);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject newItem = jsonArray.getJSONObject(i);
            if (newItem.get("addTime") != null) {
                newItem.put("addTime", dateFormat.format((Date) newItem.get("addTime")));
            }
            if (newItem.get("updateTime") != null) {
                newItem.put("updateTime", dateFormat.format((Date) newItem.get("updateTime")));
            }
            String languageType = languageTypeMap.get(newItem.get("languageType"));
            newItem.put("languageType", languageType == null ? "" : languageType);
        }
        dataMap.put("data", jsonArray);
        final InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(excelName);
        ExcelExportUtils.excelExport(fileName+".xls",dataMap,resourceAsStream,response);
    }
}
