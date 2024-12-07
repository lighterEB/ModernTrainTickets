package com.lightereb.moderntraintickets.member.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.lightereb.moderntraintickets.common.enums.BusinessExceptionEnum;
import com.lightereb.moderntraintickets.common.exception.BusinessException;
import com.lightereb.moderntraintickets.common.resp.Result;
import com.lightereb.moderntraintickets.common.util.SnowUtil;
import com.lightereb.moderntraintickets.member.domain.Member;
import com.lightereb.moderntraintickets.member.domain.MemberExample;
import com.lightereb.moderntraintickets.member.dto.request.MemberRegisterRequest;
import com.lightereb.moderntraintickets.member.mapper.MemberMapper;
import com.lightereb.moderntraintickets.member.service.IMemberService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements IMemberService {
    private static final Logger LOG = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Resource
    private MemberMapper memberMapper;

    @Override
    public int queryCount() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    @Override
    public Result<String> register(MemberRegisterRequest memberRegisterRequest) {
        String mobile = memberRegisterRequest.getMobile();
        MemberExample example= new MemberExample();
        example.createCriteria().andMobileEqualTo(mobile);
        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile);
        try {
            List<Member> members = memberMapper.selectByExample(example);
            if (CollectionUtil.isNotEmpty(members)) {
                throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
            }
            memberMapper.insertSelective(member);
        } catch (BusinessException e){
            throw e;
        } catch (Exception e) {
            LOG.error("注册手机号时发生异常：{}", e.getMessage());
            throw new BusinessException(e.getMessage());
        }

        return Result.ok();
    }
}
