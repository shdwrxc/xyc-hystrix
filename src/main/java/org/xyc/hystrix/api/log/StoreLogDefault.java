package org.xyc.hystrix.api.log;

import org.xyc.hystrix.api.HystrixProperty;

/**
 * Created by IntelliJ IDEA.
 * Date: 2017/1/3
 */
public class StoreLogDefault implements StoreLog {

    @Override
    public boolean save(HystrixProperty info) {
        return true;
    }
}
