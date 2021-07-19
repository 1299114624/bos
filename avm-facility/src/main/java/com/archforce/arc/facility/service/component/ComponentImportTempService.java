package com.archforce.arc.facility.service.component;

import com.archforce.arc.facility.entity.avm.component.ComponentImportTemp;

import java.io.File;
import java.util.List;

public interface ComponentImportTempService{

    int deleteByPrimaryKey(Long id);

    int insert(ComponentImportTemp record);

    ComponentImportTemp selectByPrimaryKey(Long id);

    List<ComponentImportTemp> selectByFileId(String fileId);

    /**
     * 导入账户基本信息
     * @param fileId
     * @param file
     * @return
     */
    String importComponent(String fileId, File file);
}
