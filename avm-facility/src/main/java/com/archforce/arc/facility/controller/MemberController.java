package com.archforce.arc.facility.controller;

import com.archforce.arc.facility.service.common.MemberService;
import com.archforce.arc.facility.utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/list")
    public ResBody getAllCompanyList() {
        return ResBody.ok(memberService.selectAll());
    }

}
