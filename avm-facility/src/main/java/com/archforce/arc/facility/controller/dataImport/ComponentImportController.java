package com.archforce.arc.facility.controller.dataImport;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.archforce.arc.common.log.LogUtils;
import com.archforce.arc.common.utils.ResBody;
import com.archforce.arc.facility.entity.avm.component.ComponentImportTemp;
import com.archforce.arc.facility.entity.common.Files;
import com.archforce.arc.facility.mapper.avm.FilesMapper;
import com.archforce.arc.facility.service.component.ComponentImportTempService;
import com.archforce.arc.facility.service.component.ComponentService;
import com.archforce.arc.facility.util.Constant;
import com.archforce.bos.identity.common.IdentityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;


@RestController
@RequestMapping("/component")
public class ComponentImportController {
    private static final String IMPORT_COMPLETE = "import complete";

    @Value("${upload-dir}")
    private String uploadDir;

    @Autowired
    private ComponentImportTempService componentImportTempService;

    @Autowired
    private FilesMapper filesMapper;

    /**
     * 组件批量新增模板导入
     */
    @PostMapping("/downInfo")
    public ResBody getDownInfo() {
        Files files = filesMapper.getByFileCode(Constant.COMPONENT_TEMPLATE_SUFFIX);
        if (files == null) {
            LogUtils.info(this.getClass(), "组件管理", "下载模板失败,fileCode:{}", Constant.COMPONENT_ERR_TEMPLATE_SUFFIX);
            throw new ArithmeticException("当前组件管理模板不存在，请检查配置");
        }
        return ResBody.ok(files);
    }

    /**
     * 导入基本信息
     * @param jsonStr 报文
     * @return
     */
    @PostMapping("/batchImport")
    public ResBody importComponent(@RequestBody String jsonStr) {
        String resMsg;
        try {
            JSONObject jsonObject = JSON.parseObject(jsonStr);
            String fileId = jsonObject.getString("fileCode");
            File excfile = new File(uploadDir + fileId + ".xlsx");
            if (!excfile.isFile() || !excfile.exists()) {
                excfile = new File(uploadDir + fileId + ".xls");
            }
            resMsg = componentImportTempService.importComponent(fileId, excfile);
        } catch (Exception e) {
            LogUtils.error(this.getClass(), "系统运行错误", "解析excel模板失败，请检查模板是否正确", e);
            return ResBody.error("解析excel模板失败，请检查模板是否正确");
        }
        if (IMPORT_COMPLETE.equals(resMsg)) {
            return ResBody.ok(resMsg);
        }
        return ResBody.error(resMsg);
    }

    @PostMapping("/queryImportResult")
    public ResBody queryImportResult(@RequestBody String jsonStr) {
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        String fileId = jsonObject.getString("fileCode");
        try {
            List<ComponentImportTemp> componentImportTemps = componentImportTempService.selectByFileId(fileId);
            return ResBody.ok(componentImportTemps);
        } catch (Exception e) {
            LogUtils.error(this.getClass(), "系统运行错误", "查询账户导入结果异常", e);
        }
        return ResBody.error("查询账户导入结果异常");
    }

    @PostMapping("/exportError")
    public ResBody exportError(HttpServletResponse response, @RequestBody String jsonStr) {
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        String fileId = jsonObject.getString("fileCode");
        return null;
    }
}
