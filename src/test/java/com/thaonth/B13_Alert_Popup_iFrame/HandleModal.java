package com.thaonth.B13_Alert_Popup_iFrame;

import com.thaonth.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HandleModal extends BaseTest {

    @Test
    public void demoModal(){
        driver.get("https://demo.seleniumeasy.com/bootstrap-modal-demo.html");

        System.out.println("Click Launch modal button");
        driver.findElement(By.xpath("//a[@href='#myModal0']")).click();
        WebElement modalContainer  =  driver.findElement(By.xpath("//div[@id='myModal0']//div[@class='modal-dialog']"));
        System.out.println(driver.findElement(By.xpath("//div[@id='myModal0']//div[@class = 'modal-body']")).getText());
        WebElement modalContent = modalContainer.findElement(By.xpath("//div[@id='myModal0']//a[normalize-space()='Save changes']"));
    }
}
