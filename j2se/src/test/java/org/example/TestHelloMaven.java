package org.example;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Agiroy
 * @date 2022/5/28 16:42
 * @effect
 */

public class TestHelloMaven {
    @Test
    public void testAdd(){
        HelloMaven helloMaven = new HelloMaven();
        int res = helloMaven.add(3, 3);
        Assert.assertEquals(6,res);
    }

    @Test
    public void testAdd2(){
        HelloMaven helloMaven = new HelloMaven();
        int res = helloMaven.add(3, 4);
        Assert.assertEquals(7,res);
    }

}
