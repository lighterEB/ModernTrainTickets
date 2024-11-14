package com.lightereb.moderntraintickets.member.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.lightereb.moderntraintickets.member.domain.Member;
import com.lightereb.moderntraintickets.member.domain.MemberExample;
import com.lightereb.moderntraintickets.member.mapper.MemberMapper;
import com.lightereb.moderntraintickets.member.service.IMemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements IMemberService {

    @Resource
    private MemberMapper memberMapper;

    @Override
    public int queryCount() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    @Override
    public long register(String mobile) {
        MemberExample example= new MemberExample();
        example.createCriteria().andMobileEqualTo(mobile);
        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        List<Member> members = memberMapper.selectByExample(example);
        if (CollectionUtil.isNotEmpty(members)) {
            throw new RuntimeException("手机号已经注册！");
        }
        memberMapper.insertSelective(member);
        return member.getId();
    }
}
