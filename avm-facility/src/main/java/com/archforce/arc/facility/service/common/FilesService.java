package com.archforce.arc.facility.service.common;

import com.archforce.arc.facility.entity.common.Files;
public interface FilesService{


    int deleteByPrimaryKey(Integer id);

    int insert(Files record);

    Files selectByPrimaryKey(Integer id);

}
