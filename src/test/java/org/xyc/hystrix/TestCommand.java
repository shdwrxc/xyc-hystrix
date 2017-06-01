package org.xyc.hystrix;

import org.xyc.hystrix.api.AbstractHystrixCommand;

/**
 * Created by CCC on 2016/3/21.
 */
public class TestCommand extends AbstractHystrixCommand<String> {

    public TestCommand(String groupKey, Object param) {
        super(groupKey, param);
    }

    @Override
    protected String doWork() throws Exception {
        return "success";
    }

    @Override
    protected String doFallback() {
        return "fail";
    }
}
