package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.common.Member;

import java.util.List;

public interface MemberMapper {
    Member selectByPrimaryKey(Integer id);
    List<Member> selectAll();
}