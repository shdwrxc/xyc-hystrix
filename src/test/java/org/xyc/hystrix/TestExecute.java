package org.xyc.hystrix;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * Date: 2016/12/29
 */
public class TestExecute {

    @Test
    public void testEx1() {
        TestCommand testCommand = new TestCommand("testGroup", "testParam");
        String str = testCommand.execute();
        System.out.println(str);
        Assert.assertNotNull(str);
    }
}
