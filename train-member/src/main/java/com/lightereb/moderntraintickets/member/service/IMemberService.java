package com.lightereb.moderntraintickets.member.service;

import com.lightereb.moderntraintickets.common.resp.Result;

public interface IMemberService {

    int queryCount();

    Result<String> register(String mobile);
}
