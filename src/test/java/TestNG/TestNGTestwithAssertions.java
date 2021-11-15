package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestNGTestwithAssertions {

    @Test
    public void testShouldPassAssertions()
    {
        Assert.assertEquals("India","India","If Values do not match");
        Assert.assertTrue(true,"Message if the value is not true");
        Assert.assertFalse(false,"Message if the value is not false");

    }

    @Test
    public void testShouldFailAssertions()
    {
        Assert.assertEquals("India","india","If Values do not match");
        Assert.assertTrue(false,"Message if the value is not true");
        Assert.assertFalse(true,"Message if the value is not false");

    }
}
