package com.lightereb.moderntraintickets.common.exception;

import com.lightereb.moderntraintickets.common.enums.BusinessExceptionEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    private BusinessExceptionEnum e;

    private String msg;

    public BusinessException(BusinessExceptionEnum e) {
        this.e = e;
    }

    public BusinessException(String msg) {
        this.msg = msg;
    }

}
