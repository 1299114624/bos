package com.archforce.bos.identity.mapper;

import com.archforce.bos.identity.entity.RoleResource;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleResourceMapper {
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

    int insert(RoleResource record);

    int batchInsert(@Param("list") List<RoleResource> list);
}