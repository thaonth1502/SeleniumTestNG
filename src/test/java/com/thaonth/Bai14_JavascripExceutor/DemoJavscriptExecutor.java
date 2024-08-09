package com.thaonth.Bai14_JavascripExceutor;

import com.thaonth.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoJavscriptExecutor extends BaseTest {

        @Test
        public void jsExecutorDemo01()  {
            // Creating the JavascriptExecutor interface object
            JavascriptExecutor js = (JavascriptExecutor) driver;

            driver.get("https://anhtester.com/");
            sleep(2);

            // Click on "Website Testing" module using JavascriptExecutor
            WebElement button = driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']"));
            js.executeScript("arguments[0].click();", button);
            sleep(2);

            // Get page title and Domain using JavascriptExecutor
            String titleText = js.executeScript("return document.title;").toString();
            System.out.println("Page Title is: " + titleText);

            String domainName = js.executeScript("return document.domain;").toString();
            System.out.println("Domain is: " + domainName);

            // Add Alert window using JavascriptExecutor
            js.executeScript("alert('Successfully Logged In');");

            sleep(2);
        }

    @Test
    public void jsExecutorDemo02() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://crm.anhtester.com/admin/authentication");
        sleep(2);

        // sendKeys text on input
        js.executeScript("document.getElementById('email').setAttribute('value','admin@example.com');");
        js.executeScript("document.getElementById('password').setAttribute('value','123456');");

        js.executeScript("document.getElementsByClassName('btn-primary')[0].click()");
        sleep(2);
    }

    @Test
    public void jsExecutorDemo03() throws InterruptedException {

        driver.get("https://anhtester.com/");
        sleep(2);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement webElement = driver.findElement(By.xpath("//h2[contains(text(),'Kiến thức Automation Testing')]"));

        //Scroll to element
        //Giá trị true là nằm phía trên
        //Giá trị false là nằm phía dưới
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);

        sleep(2);
    }

    @Test
    public void jsExecutorDemo04() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        sleep(2);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
        js.executeScript("arguments[0].style.border='3px solid red'", inputEmail);
        inputEmail.sendKeys("admin@example.com");
        sleep(2);
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        js.executeScript("arguments[0].style.border='3px solid red'", inputPassword);
        inputPassword.sendKeys("123456");
        sleep(2);
        WebElement buttonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        js.executeScript("arguments[0].style.border='3px solid red'", buttonLogin);
        inputEmail.click();

        sleep(2);
    }

    }

