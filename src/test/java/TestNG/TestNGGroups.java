package TestNG;

import org.testng.annotations.Test;

public class TestNGGroups {

    @Test(groups = { "sanity" })
    public void testlogin() {
        System.out.println("I belong to Sanity group");
    }


    @Test(groups = { "regression" })
    public void testProductDescription() {
        System.out.println("I belong to regression group");
    }
}
