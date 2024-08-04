package com.thaonth.Bai11_AssertTestNG;

import com.thaonth.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssert extends BaseTest {
    @Test(priority = 1)
    public void testCheckPageTitle(){

        driver.get("https://anhtester.com");

        String expectedTitle = "Anh Tester Automation Testing";
        String originalTitle = driver.getTitle();

        //Soft Assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(originalTitle,expectedTitle,"Tieu de trang login khong dung");

        driver.findElement(By.xpath("//a[@id='btn-login']")).click();
        String headerLogin =  driver.findElement(By.xpath("//h2[normalize-space()='Login']")).getText();

        softAssert.assertEquals(headerLogin,"Login1111", "Tieu de trang khong dung");

        //Goi assertAll thi moi thong ke duoc ket qua phia tren
        softAssert.assertAll();
    }
}

