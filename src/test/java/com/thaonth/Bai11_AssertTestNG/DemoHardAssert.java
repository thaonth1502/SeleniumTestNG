package com.thaonth.Bai11_AssertTestNG;

import com.thaonth.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoHardAssert extends BaseTest {
    @Test(priority = 1)
    public void testCheckPageTitle(){

        driver.get("https://anhtester.com");

        String expectedTitle = "Anh Tester Automation Testing";
        String originalTitle = driver.getTitle();

        //Hard Assert
        Assert.assertEquals(originalTitle,expectedTitle,"Title page not right");
        Assert.assertTrue(driver.findElement(By.xpath("//a[@id='btn-login']")).isDisplayed(),"Login button isn't display");
        driver.findElement(By.xpath("//a[@id='btn-login']")).click();
        String headerLogin =  driver.findElement(By.xpath("//h2[normalize-space()='Login']")).getText();

        Assert.assertEquals(headerLogin,"Login", "Tieu de trang khong dung");
    }
}
