package com.archforce.arc.facility.service.component.impl;

import cn.hutool.json.JSONUtil;
import com.archforce.arc.common.exception.ApplicationException;
import com.archforce.arc.common.exception.FileHandlerException;
import com.archforce.arc.common.log.LogUtils;
import com.archforce.arc.facility.entity.avm.component.Component;
import com.archforce.arc.facility.entity.vo.ComponentVo;
import com.archforce.arc.facility.enums.errorCode.ComponentErrorCodeEnum;
import com.archforce.arc.facility.mapper.avm.ComponentMapper;
import com.archforce.arc.facility.util.ExcelUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.archforce.arc.facility.entity.avm.component.ComponentImportTemp;
import com.archforce.arc.facility.mapper.avm.ComponentImportTempMapper;
import com.archforce.arc.facility.service.component.ComponentImportTempService;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.archforce.arc.facility.enums.errorCode.ComponentErrorCodeEnum.DATA_DB_ERROR;

@Service
public class ComponentImportTempServiceImpl implements ComponentImportTempService{

    @Resource
    private ComponentMapper componentMapper;

    @Resource
    private ComponentImportTempMapper componentImportTempMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return componentImportTempMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ComponentImportTemp record) {
        return componentImportTempMapper.insert(record);
    }

    @Override
    public ComponentImportTemp selectByPrimaryKey(Long id) {
        return componentImportTempMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ComponentImportTemp> selectByFileId(String fileId) {
        if (StringUtils.isBlank(fileId)) {
            return null;
        }
        return componentImportTempMapper.selectByFileId(fileId);
    }

    @Override
    public String importComponent(String fileId, File file) {
        try {
            processExcel(fileId, file);
        } catch (Exception e) {
            throw new ApplicationException("excel导入失败");
        }
        return "import complete";
    }

    /**
     * 读取excel内容
     * @param fileId
     * @param file
     */
    private void processExcel(String fileId, File file) {
        List<Map<String, String>> excelDatas;
        try {
            excelDatas = ExcelUtils.parseExcel(file);
        } catch (Exception e) {
            throw new FileHandlerException("解析Excel文件异常", e);
        }
        if (CollectionUtils.isEmpty(excelDatas)) {
            return;
        }
        int index = 1;
        for (Map<String, String> excelData : excelDatas) {
            processComponentInfo(index, excelData, fileId);
            index++;
        }
    }

    /**
     * 获取临时信息
     * @param index
     * @param excelData
     * @param fileId
     */
    private void processComponentInfo(int index, Map<String, String> excelData, String fileId) {
        ComponentImportTemp componentImportTemp = new ComponentImportTemp();
        //从第三行开始记录
        componentImportTemp.setLineNumber(String.valueOf(index + 2));
        componentImportTemp.setComponentName(excelData.get("组件名称"));
        componentImportTemp.setFileId(fileId);
        ComponentVo componentVo = createComponent(excelData);
        componentImportTemp.setComponentInfo(JSONUtil.toJsonStr(componentVo));
        Map<String, ComponentErrorCodeEnum> errorMap = verifyData(componentVo);
        Map<String, String> newErrorMap = new HashMap<>();
        for (Map.Entry<String, ComponentErrorCodeEnum> enumEntry : errorMap.entrySet()) {
            newErrorMap.put(enumEntry.getKey(), enumEntry.getValue().getErrorCode() + ":" + enumEntry.getValue().getDesc());
        }
        if (!newErrorMap.isEmpty()) {
            componentImportTemp.setErrorInfo(JSONUtil.toJsonStr(newErrorMap));
            componentImportTemp.setIsSuccess("N");
            componentImportTempMapper.insert(componentImportTemp);
            return;
        }
        componentImportTemp.setIsSuccess("Y");
        try {
            addTransactional(componentVo);
        } catch (Exception e) {
            LogUtils.error(this.getClass(),"系统运行错误", String.format("excel数据新增组件信息失败===>%s", excelData.get("组件名称")), e);
            newErrorMap.put("组件信息", DATA_DB_ERROR.getErrorCode() + ":" + DATA_DB_ERROR.getDesc());
            componentImportTemp.setErrorInfo(JSONUtil.toJsonStr(newErrorMap));
            componentImportTemp.setIsSuccess("N");
        }
        componentImportTempMapper.insert(componentImportTemp);
    }

    //校验
    private Map<String, ComponentErrorCodeEnum> verifyData(ComponentVo componentVo) {
        Map<String, ComponentErrorCodeEnum> errorMap = new HashMap<>();
        // 校验组件名称是否存在
        vertifyComponentName(componentVo, errorMap);
        return errorMap;
    }

    private ComponentVo createComponent(Map<String, String> excelData) {
        ComponentVo componentVo = new ComponentVo();
        componentVo.setComponentEnglishName(excelData.get("组件英文全称"));
        componentVo.setComponentName(excelData.get("组件名称"));
        componentVo.setComponentCode(excelData.get("组件类型").equals("通用组件") ? "0" : "1");
        componentVo.setDescription(excelData.get("组件说明"));
        componentVo.setDesignSvnAddress(excelData.get("设计文档SVN地址"));
        componentVo.setRequireSvnAddress(excelData.get("需求文档SVN地址"));
        return componentVo;
    }

    /**
     * 添加事务
     * @param componentVo
     */
    @Transactional(rollbackFor = Exception.class)
    public void addTransactional(ComponentVo componentVo) {
        Component component = componentMapper.selectByComponentName(componentVo.getComponentName());
        if (component == null) {
            componentMapper.insertSelective(componentVo);
        }
    }

    private void vertifyComponentName(ComponentVo componentVo, Map<String, ComponentErrorCodeEnum> errorMap) {
        if (StringUtils.isBlank(componentVo.getComponentName())) {
            return;
        }
        Component component = componentMapper.selectByComponentName(componentVo.getComponentName());
        if (null != component) {
            errorMap.put("组件名称", ComponentErrorCodeEnum.COMPONENT_NAME_EXIT);
        }
    }
}
