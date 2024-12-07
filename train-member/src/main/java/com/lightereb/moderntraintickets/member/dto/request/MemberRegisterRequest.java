package com.lightereb.moderntraintickets.member.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户注册请求类
 */
@Data
public class MemberRegisterRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 手机号
     */
    @NotBlank(message = "【手机号】不能为空")
    private String mobile;
}
