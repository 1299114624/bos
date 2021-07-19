package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.component.ComponentImportTemp;

import java.util.List;

public interface ComponentImportTempMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ComponentImportTemp record);

    ComponentImportTemp selectByPrimaryKey(Long id);

    List<ComponentImportTemp> selectByFileId(String fileId);
}