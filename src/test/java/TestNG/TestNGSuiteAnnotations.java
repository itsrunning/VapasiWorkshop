package TestNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGSuiteAnnotations {

    @BeforeSuite
    public void beforeSuiteAnnotation()
    {
        System.out.println("I run Before the suite");
    }
    @AfterSuite
    public void afterSuiteAnnotation()
    {
        System.out.println("I run After the suite");
    }

    @Test
    public void testShouldBelongToSuite()
    {
        System.out.println("I belong to a suite ran from testng_groups.xml");
    }
}
