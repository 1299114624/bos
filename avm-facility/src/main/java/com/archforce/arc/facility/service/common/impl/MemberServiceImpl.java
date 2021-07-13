package com.archforce.arc.facility.service.common.impl;

import com.archforce.arc.facility.mapper.avm.MemberMapper;
import com.archforce.arc.facility.service.common.MemberService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.archforce.arc.facility.entity.common.Member;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Override
    public Member selectByPrimaryKey(Integer id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Member> selectAll() {
        return memberMapper.selectAll();
    }

}
