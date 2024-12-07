package com.lightereb.moderntraintickets.member.service;

import com.lightereb.moderntraintickets.common.resp.Result;
import com.lightereb.moderntraintickets.member.dto.request.MemberRegisterRequest;

public interface IMemberService {

    int queryCount();

    Result<String> register(MemberRegisterRequest memberRegisterRequest);
}
