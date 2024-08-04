package com.thaonth.Bai10_AnnotationTestNG;

import com.thaonth.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ManageCustomer extends BaseTest {

    @Test(description = "Testcase add new Customer")
    public void testCreateCustomer(){
        //Login
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        sleep(2);

        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='New Customer']")).click();
        sleep(2);



    }
}
