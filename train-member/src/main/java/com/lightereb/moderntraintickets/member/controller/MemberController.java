package com.lightereb.moderntraintickets.member.controller;

import com.lightereb.moderntraintickets.common.resp.Result;
import com.lightereb.moderntraintickets.member.dto.request.MemberRegisterRequest;
import com.lightereb.moderntraintickets.member.service.IMemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private IMemberService memberService;

    @RequestMapping("/register")
    public Result<String> register(@Valid MemberRegisterRequest memberRegisterRequest) {
        return memberService.register(memberRegisterRequest);
    }
}
