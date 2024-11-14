package com.lightereb.moderntraintickets.member.service.impl;

import com.lightereb.moderntraintickets.member.mapper.MemberMapper;
import com.lightereb.moderntraintickets.member.service.IMemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements IMemberService {

    @Resource
    private MemberMapper memberMapper;

    @Override
    public int queryCount() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }
}
