package com.archforce.arc.facility.service.common;

import com.archforce.arc.facility.entity.common.Member;

import java.util.List;

public interface MemberService {

    Member selectByPrimaryKey(Integer id);
    List<Member> selectAll();
}
