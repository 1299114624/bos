package com.archforce.bos.identity.mapper;

import com.archforce.bos.identity.entity.UserRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    int delete(UserRole record);

    int insert(UserRole record);

    int batchInsert(@Param("list") List<UserRole> list);
}