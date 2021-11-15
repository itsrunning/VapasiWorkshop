package TestNG;

import org.testng.annotations.*;

public class TestNGClassBasedAnnotations {

    @BeforeClass
    public void setUp() {
        System.out.println("Setup Done for all the Tests");
    }

    @BeforeMethod
    public void beforeTestAnnotation()
    {
        System.out.println("I run before  every test");
    }

    @Test
    public void testFast() {
        System.out.println("Fast test");
    }

    @Test
    public void testSlow() {
        System.out.println("Slow test");
    }

    @AfterMethod
    public void afterTestAnnotation()
    {
        System.out.println("I run before  every test");
    }


}
