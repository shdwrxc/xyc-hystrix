package org.xyc.hystrix.api;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Date: 2016/12/30
 */
public class HystrixProperty {

    private long serialNo;
    private String groupKey;
    private String commandKey;
    private String threadPoolKey;
    private Object param;
    private String message;
    private LogType logType = LogType.INFO;
    private long timeMillis;
    private String timeOccurred;

    public static HystrixProperty newProperty() {
        return new HystrixProperty();
    }

    public long getSerialNo() {
        return serialNo;
    }

    public HystrixProperty setSerialNo(long serialNo) {
        this.serialNo = serialNo;
        return this;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public HystrixProperty setGroupKey(String groupKey) {
        this.groupKey = groupKey;
        return this;
    }

    public String getCommandKey() {
        return commandKey;
    }

    public HystrixProperty setCommandKey(String commandKey) {
        this.commandKey = commandKey;
        return this;
    }

    public String getThreadPoolKey() {
        return threadPoolKey;
    }

    public HystrixProperty setThreadPoolKey(String threadPoolKey) {
        this.threadPoolKey = threadPoolKey;
        return this;
    }

    public Object getParam() {
        return param;
    }

    public HystrixProperty setParam(Object param) {
        this.param = param;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public HystrixProperty setMessage(String message) {
        this.message = message;
        return this;
    }

    public LogType getLogType() {
        return logType;
    }

    public HystrixProperty setLogType(LogType logType) {
        this.logType = logType;
        return this;
    }

    public HystrixProperty setLogTypeInfo() {
        this.logType = LogType.INFO;
        return this;
    }

    public HystrixProperty setLogTypeError() {
        this.logType = LogType.ERROR;
        return this;
    }

    public HystrixProperty setCurrentTimeMillis() {
        return setTimeMillis(System.currentTimeMillis());
    }

    public long getTimeMillis() {
        return timeMillis;
    }

    public HystrixProperty setTimeMillis(long timeMillis) {
        this.timeMillis = timeMillis;
        timeOccurred = DateFormatter.format(timeMillis);
        return this;
    }

    public String getTimeOccurred() {
        return timeOccurred;
    }

    public void setTimeOccurred(String timeOccurred) {
        this.timeOccurred = timeOccurred;
    }

    public String toLogString() {
        return "HystrixProperty{" +
                "serialNo=" + serialNo +
                ", groupKey=" + groupKey +
                (commandKey != null ? ", commandKey=" + commandKey : "") +
                (param != null ? ", param=" + WorkUtils.toJsonString(param) : "") +
                '}';
    }

    public enum LogType {
        INFO, ERROR
    }

    private static class DateFormatter {

        static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
            @Override
            public SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            }
        };

        static Date parse(String str) {
            try {
                return sdf.get().parse(str);
            } catch (Exception e) {

            }
            return null;
        }

        static String format(long time) {
            if (time == 0)
                return "";
            try {
                return sdf.get().format(new Date(time));
            } catch (Exception e) {

            }
            return "";
        }
    }
}
