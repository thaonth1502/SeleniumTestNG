package com.thaonth.Bai10_AnnotationTestNG;

import org.testng.annotations.*;

public class DemoAnnotation {

    @Test(groups = {"testOne"})
    public void testCase1(){
    System.out.println("Test Case 1");
}

    @Test(groups = {"testTwo"})
    public void testCase2(){
        System.out.println("Test Case 2");
    }



    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterSuite
    public void afterClass(){
        System.out.println("After Class");
    }

    @BeforeGroups(groups = {"testOne"})
    public void beforeGroupOne(){
        System.out.println("Before Group testOne");
    }

    @AfterGroups(groups = {"testOne"})
    public void afterGroupOne(){
        System.out.println("After Group testOne");
    }

    @BeforeGroups(groups = {"testTwo"})
    public void beforeGroupTwo(){
        System.out.println("Before Group testTwo");
    }

    @AfterGroups(groups = {"testTwo"})
    public void afterGroupTwo(){
        System.out.println("After Group testTwo");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }
}
