package br.com.claudiobs07.newfeatures.switchs;

import org.junit.Assert;
import org.junit.Test;

public class SwitchDemoTest {

    @Test
    public void testSwitchViaArrow() {
        Assert.assertEquals(2, SwitchDemo.getValueViaArrow("c"));
    }

    @Test
    public void testYield() {
        Assert.assertEquals(2, SwitchDemo.getValueViaYield("c"));
    }

}