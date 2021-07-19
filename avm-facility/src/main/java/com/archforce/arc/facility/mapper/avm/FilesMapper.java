package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.common.Files;

public interface FilesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Files record);

    Files selectByPrimaryKey(Integer id);

    Files getByFileCode(String fileCode);
}