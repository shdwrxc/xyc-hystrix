package org.xyc.hystrix.api;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import org.xyc.hystrix.api.log.StoreLog;
import org.xyc.hystrix.api.log.StoreLogDefault;

/**
 * Created by IntelliJ IDEA.
 * Date: 2016/12/28
 */
public abstract class BaseHystrixCommand<R> extends HystrixCommand<R> {

    protected HystrixProperty property;

    protected StoreLog storeLog;

    protected BaseHystrixCommand(Setter setter) {
        super(setter);
        property = HystrixProperty.newProperty().setSerialNo(WorkUtils.generateSerialNo());
//        storeLog = SpringContext.getBean(StoreLog.class);
        if (storeLog == null) {
            storeLog = new StoreLogDefault();
        }
    }

    protected static Setter initSetter(String groupKey) {
        return Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey));
    }

    /**
     * 令分组用于对依赖操作分组,便于统计,汇总等. CommandGroup是每个命令最少配置的必选参数，
     * 在不指定ThreadPoolKey的情况下，字面值用于对不同依赖的线程池/信号区分.相同的groupkey和commandKey会公用同一个缓存。
     * @param groupKey
     * @param commandKey
     * @return
     */
    protected static Setter initSetter(String groupKey, String commandKey) {
        return Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey))
                .andCommandKey(HystrixCommandKey.Factory.asKey(commandKey));
    }
}
