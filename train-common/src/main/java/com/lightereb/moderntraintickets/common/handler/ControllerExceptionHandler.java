package com.lightereb.moderntraintickets.common.handler;

import com.lightereb.moderntraintickets.common.exception.BusinessException;
import com.lightereb.moderntraintickets.common.resp.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 * author: lighterEB
 * date: 2024-12-07
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 系统异常
     * @param e 系统异常
     * @return 结果
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<String> handleException(final Exception e) {
        LOG.error("系统异常：{}", e.getMessage());
        return Result.failed(e.getMessage());
    }


    /**
     * 业务异常
     * @param e 业务异常
     * @return 结果
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Result<String> handleException(final BusinessException e) {
        Object msg =  e.getMessage() == null ? e.getE().getDesc() : e.getMessage();
        LOG.error("业务异常：{}", msg);
        return Result.failed(msg.toString());
    }

    /**
     * 校验异常
     * @param e 校验异常
     * @return 结果
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public Result<String> handleException(final BindException e) {
        String defaultMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        LOG.error("校验异常：{}", defaultMessage, e);
        return Result.failed(defaultMessage);
    }
}
