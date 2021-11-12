package com.spree;

import org.testng.annotations.*;

public class TestNGTestsSample {

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
    public void aFastTest() {
        System.out.println("Fast test");
    }

    @Test
    public void aSlowTest() {
        System.out.println("Slow test");
    }


//    @BeforeMethod
//    public void beforeAnnotation()
//    {
//        System.out.println("i run before a method");
//    }

//    @AfterMethod
//    public void afterMethodAnnotation()
//    {
//        System.out.println("I run after method");
//    }





    @AfterTest
    public void afterTestAnnotation()
    {
        System.out.println("I run after every  test");
    }

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

//    @BeforeGroups(groups = { "slow" })
//    public void beforeGroupAnnotation()
//    {
//        System.out.println("I run before the group");
//    }
//
//    @AfterGroups(groups = { "slow" })
//    public void afterGroupAnnotation()
//    {
//        System.out.println("I run after the group group");
//    }

}
