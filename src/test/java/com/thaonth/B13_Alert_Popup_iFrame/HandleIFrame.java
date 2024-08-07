package com.thaonth.B13_Alert_Popup_iFrame;

import com.thaonth.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandleIFrame extends BaseTest {

    @Test
    public void testIFrame01(){
        driver.navigate().to("https://anhtester.com/contact");
        sleep(1);
        System.out.println("iFrame total: " + driver.findElements(By.tagName("iframe")).size());

        driver.switchTo().frame(0);

        System.out.println(driver.findElement(By.tagName("title")).getText());

        driver.switchTo().parentFrame(); //Chuyển về nội dung chính không thuộc iframe nào

        //2. Switch to iframe icon of Messenger
//        driver.switchTo().frame(1); //Thẻ iframe thứ hai
//        driver.findElement(By.tagName("svg")).click(); //Nhấn icon để ẩn messenger chat đi

        sleep(2);

    }
}
