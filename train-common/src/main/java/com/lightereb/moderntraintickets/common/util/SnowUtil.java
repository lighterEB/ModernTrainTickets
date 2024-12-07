package com.lightereb.moderntraintickets.common.util;

import cn.hutool.core.util.IdUtil;

/**
 * hutool雪花算法封装
 */
public class SnowUtil {

    /**
     * 数据中心
     */
    private static long dataCenterId = 1;
    /**
     * 机器标识
     */
    private static long workerId = 1;

    public static long getSnowflakeNextId() {
        return IdUtil.getSnowflake(workerId,dataCenterId).nextId();
    }

    public static String getSnowflakeNextIdStr() {
        return IdUtil.getSnowflake(workerId,dataCenterId).nextIdStr();
    }
}
