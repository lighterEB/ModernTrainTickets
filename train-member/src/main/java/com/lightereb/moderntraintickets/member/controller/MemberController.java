package com.lightereb.moderntraintickets.member.controller;

import com.lightereb.moderntraintickets.common.resp.Result;
import com.lightereb.moderntraintickets.member.service.IMemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private IMemberService memberService;

    @RequestMapping("/register")
    public Result<String> register(String mobile) {
        return memberService.register(mobile);
    }
}
