package com.lightereb.moderntraintickets.common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@AllArgsConstructor
@ToString
public enum BusinessExceptionEnum {
    MEMBER_MOBILE_EXIST("手机号已注册");

    private final String desc;
}
