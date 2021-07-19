package com.archforce.arc.facility.service.common.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.archforce.arc.facility.mapper.avm.FilesMapper;
import com.archforce.arc.facility.entity.common.Files;
import com.archforce.arc.facility.service.common.FilesService;
@Service
public class FilesServiceImpl implements FilesService{

    @Resource
    private FilesMapper filesMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return filesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Files record) {
        return filesMapper.insert(record);
    }

    @Override
    public Files selectByPrimaryKey(Integer id) {
        return filesMapper.selectByPrimaryKey(id);
    }

}
