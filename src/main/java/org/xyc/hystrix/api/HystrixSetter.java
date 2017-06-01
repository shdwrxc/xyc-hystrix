package org.xyc.hystrix.api;

/**
 * Created by CCC on 2016/3/21.
 */
public class HystrixSetter {

    /** 判断是否启用缓存 */
    public static String defaultCacheEnable = "false";
    /** 默认端口超时设置 */
    public static String defaultTimeout = "1800000";
    /** 默认接口健康情况收集时间，计算这段时间范围内的错误率百分比，默认为500毫秒，扩展到10秒 */
    public static String defaultMetricsHealthSnapshotIntervalInMilliseconds = "10000";
    /** 触发接口熔断的错误次数。低于这个错误次数就不会触发熔断。*/
    public static String defaultCircuitBreakerRequestVolumeThreshold = "50";
    /** 在触发熔断后接口将等待100000毫秒后再次尝试调用。*/
    public static String defaultCircuitBreakerSleepWindowInMilliseconds = "100000";
    /** 熔断触发后是否拒绝所有请求。*/
    public static String defaultCircuitBreakerForceOpen = "false";
    /** 默认最大支持的并发数，如果超出这个并发数的请求将会被拒绝。*/
    public static String defaultExecutionIsolationSemaphoreMaxConcurrentRequests = "500";
    /** 默认最大支持的回滚并发数，如果超出这个并发数的回滚请求将会被拒绝。*/
    public static String defaultFallbackIsolationSemaphoreMaxConcurrentRequests = "50";
    /** 默认最大线程池。计算方式: (每秒请求书 * 高峰时99.5%的平均响应时间) + 向上预留5个线程即可 */
    public static String defaultCorePoolSize = "10";
    /** 默认最大队列等待数。 建议计算一个正确容量的线程池，而不建议采用队列等待方式。*/
    public static String defaultMaxQueueSize = "-1";

    public void setDefaultCacheEnable(String defaultCacheEnable) {
        HystrixSetter.defaultCacheEnable = defaultCacheEnable;
    }

    public void setDefaultTimeout(String defaultTimeout) {
        HystrixSetter.defaultTimeout = defaultTimeout;
    }

    public void setDefaultMetricsHealthSnapshotIntervalInMilliseconds(String defaultMetricsHealthSnapshotIntervalInMilliseconds) {
        HystrixSetter.defaultMetricsHealthSnapshotIntervalInMilliseconds = defaultMetricsHealthSnapshotIntervalInMilliseconds;
    }

    public void setDefaultCircuitBreakerRequestVolumeThreshold(String defaultCircuitBreakerRequestVolumeThreshold) {
        HystrixSetter.defaultCircuitBreakerRequestVolumeThreshold = defaultCircuitBreakerRequestVolumeThreshold;
    }

    public void setDefaultCircuitBreakerSleepWindowInMilliseconds(String defaultCircuitBreakerSleepWindowInMilliseconds) {
        HystrixSetter.defaultCircuitBreakerSleepWindowInMilliseconds = defaultCircuitBreakerSleepWindowInMilliseconds;
    }

    public void setDefaultCircuitBreakerForceOpen(String defaultCircuitBreakerForceOpen) {
        HystrixSetter.defaultCircuitBreakerForceOpen = defaultCircuitBreakerForceOpen;
    }

    public void setDefaultExecutionIsolationSemaphoreMaxConcurrentRequests(String defaultExecutionIsolationSemaphoreMaxConcurrentRequests) {
        HystrixSetter.defaultExecutionIsolationSemaphoreMaxConcurrentRequests = defaultExecutionIsolationSemaphoreMaxConcurrentRequests;
    }

    public void setDefaultFallbackIsolationSemaphoreMaxConcurrentRequests(String defaultFallbackIsolationSemaphoreMaxConcurrentRequests) {
        HystrixSetter.defaultFallbackIsolationSemaphoreMaxConcurrentRequests = defaultFallbackIsolationSemaphoreMaxConcurrentRequests;
    }

    public void setDefaultCorePoolSize(String defaultCorePoolSize) {
        HystrixSetter.defaultCorePoolSize = defaultCorePoolSize;
    }

    public void setDefaultMaxQueueSize(String defaultMaxQueueSize) {
        HystrixSetter.defaultMaxQueueSize = defaultMaxQueueSize;
    }
}
