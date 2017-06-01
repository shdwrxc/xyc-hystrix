package org.xyc.hystrix.api;

import java.util.concurrent.atomic.AtomicLong;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Created by IntelliJ IDEA.
 * Date: 2016/12/29
 */
public class WorkUtils {

    private static final AtomicLong serialNo = new AtomicLong();

    /**
     * 获取序列号
     * @return
     */
    public static long generateSerialNo () {
        return serialNo.getAndIncrement();
    }

    /**
     * 获取初始时间
     * 用于计算操作的耗时
     * @return
     */
    public static long getCurrentTime() {
        return System.nanoTime();
    }

    /**
     * 计算操作间的耗时
     * @param startTime
     * @return
     */
    public static long getSpendTime(long startTime) {
        return (System.nanoTime() - startTime) / 1000000;
    }

    /**
     * json转换
     * @param object
     * @return
     */
    public static String toJsonString(Object object) {
        return JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
    }
}
