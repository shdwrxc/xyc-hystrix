package org.xyc.hystrix.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 实现hystrix的基础封装
 * @param <R>
 */
public abstract class AbstractHystrixCommand<R> extends ThreadPoolCommand<R> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractHystrixCommand.class);

    public AbstractHystrixCommand(String groupKey, Object param) {
        super(groupKey, param);
    }

    public AbstractHystrixCommand(String groupKey, String commandKey, Object param) {
        super(groupKey, commandKey, param);
    }

    @Override
    protected R run() throws Exception {
        long startTime = WorkUtils.getCurrentTime();
        logger.info("serial {} start executing.", property.getSerialNo());
        try {
            R r = doWork();
            logger.info("serial {} finish executing. spend {}ms ", property.getSerialNo(), WorkUtils.getSpendTime(startTime));
            storeLog.save(property.setMessage("finish executing").setCurrentTimeMillis());
            return r;
        } catch (Exception e) {
            logger.error("error occurred while executing, caused by {}. {}", e.toString(), property.toLogString());
            logger.error("serial " + property.getSerialNo() + " execute error.", e);
            storeLog.save(property.setLogTypeError().setMessage("error occurred while executing, caused by " + e.toString()).setCurrentTimeMillis());
            throw e;
        }
    }

    /**
     * 具体的业务逻辑
     * @return
     * @throws Exception
     */
    protected abstract R doWork() throws Exception;

    @Override
    public R getFallback() {
        long startTime = WorkUtils.getCurrentTime();
        logger.info("serial {} start fallback.", property.getSerialNo());
        try {
            R r = doFallback();
            logger.info("serial {} finish fallback. spend {}ms ", property.getSerialNo(), WorkUtils.getSpendTime(startTime));
            storeLog.save(property.setLogTypeInfo().setMessage("finish fallback").setCurrentTimeMillis());
            return r;
        } catch (RuntimeException e) {
            logger.error("error occurred while fallback, caused by {}. {}", e.toString(), property.toLogString());
            logger.error("serial " + property.getSerialNo() + " fallback error.", e);
            storeLog.save(property.setLogTypeError().setMessage("error occurred while fallback, caused by " + e.toString()).setCurrentTimeMillis());
            throw e;
        }
    }

    protected R doFallback() {
        throw new UnsupportedOperationException("No fallback available.");
    }
}
