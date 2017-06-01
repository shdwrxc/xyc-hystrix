package org.xyc.hystrix.api.log;

import org.xyc.hystrix.api.HystrixProperty;

/**
 * 重要日志的操作类
 * Created by IntelliJ IDEA.
 * Date: 2016/12/30
 */
public interface StoreLog {

    boolean save(HystrixProperty info);
}
