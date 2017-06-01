package org.xyc.hystrix.api;

import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * Date: 2016/12/28
 */
public abstract class ThreadPoolCommand<R> extends BaseHystrixCommand<R> {

    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolCommand.class);

    public ThreadPoolCommand(String groupKey, Object param) {
        super(initThreadPoolSetter(groupKey));
        property.setGroupKey(groupKey).setParam(param).setMessage("generate a command");
        logger.info("generate a command. {}", property.toLogString());
        storeLog.save(property.setCurrentTimeMillis());

    }

    public ThreadPoolCommand(String groupKey, String commandKey, Object param) {
        super(initThreadPoolSetter(groupKey, commandKey));
        property.setGroupKey(groupKey).setCommandKey(commandKey).setParam(param).setMessage("generate a command");
        logger.info("generate a command. {}", property.toLogString());
        storeLog.save(property.setCurrentTimeMillis());
    }

    protected static Setter initThreadPoolSetter(String groupKey, String commandKey) {
        return initThreadPoolSetter(groupKey).andCommandKey(HystrixCommandKey.Factory.asKey(commandKey));
    }

    protected static Setter initThreadPoolSetter(String groupKey) {
        return initSetter(groupKey)
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                        .withRequestCacheEnabled(Boolean.valueOf(HystrixSetter.defaultCacheEnable))
                        .withMetricsHealthSnapshotIntervalInMilliseconds(Integer.valueOf(HystrixSetter.defaultMetricsHealthSnapshotIntervalInMilliseconds))
                        .withCircuitBreakerRequestVolumeThreshold(Integer.valueOf(HystrixSetter.defaultCircuitBreakerRequestVolumeThreshold))
                        .withCircuitBreakerSleepWindowInMilliseconds(Integer.valueOf(HystrixSetter.defaultCircuitBreakerSleepWindowInMilliseconds))
                        .withExecutionTimeoutInMilliseconds(Integer.valueOf(HystrixSetter.defaultTimeout))
                        .withCircuitBreakerForceOpen(Boolean.valueOf(HystrixSetter.defaultCircuitBreakerForceOpen))
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(Integer.valueOf(HystrixSetter.defaultExecutionIsolationSemaphoreMaxConcurrentRequests))
                        .withFallbackIsolationSemaphoreMaxConcurrentRequests(Integer.valueOf(HystrixSetter.defaultFallbackIsolationSemaphoreMaxConcurrentRequests)))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(Integer.valueOf(HystrixSetter.defaultCorePoolSize))
                        .withMaxQueueSize(Integer.valueOf(HystrixSetter.defaultMaxQueueSize))
                        .withQueueSizeRejectionThreshold(Integer.valueOf(HystrixSetter.defaultMaxQueueSize)));
    }
}
