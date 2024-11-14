package com.lightereb.moderntraintickets.member.controller;

import com.lightereb.moderntraintickets.member.service.IMemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Resource
    private IMemberService memberService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/count")
    public Integer count() {
        return memberService.queryCount();
    }
}
