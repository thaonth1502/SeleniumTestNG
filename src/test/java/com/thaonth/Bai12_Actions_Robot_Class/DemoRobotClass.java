package com.thaonth.Bai12_Actions_Robot_Class;

import com.thaonth.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DemoRobotClass extends BaseTest {


    @Test
        public void inputText() throws InterruptedException, AWTException {

            driver.get("https://anhtester.com/");

            sleep(1);
            Robot robot = new Robot();
            WebElement inputCourseElement = driver.findElement(By.name("key"));
            inputCourseElement.click();
            // Nhập từ khóa selenium
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_S);
            sleep(0.5);
            robot.keyPress(KeyEvent.VK_E);
            sleep(0.5);
            robot.keyPress(KeyEvent.VK_L);
            sleep(0.5);
            robot.keyPress(KeyEvent.VK_E);
            sleep(0.5);
            robot.keyPress(KeyEvent.VK_N);
            sleep(0.5);
            robot.keyPress(KeyEvent.VK_I);
            sleep(0.5);
            robot.keyPress(KeyEvent.VK_U);
            sleep(0.5);
            robot.keyPress(KeyEvent.VK_M);
            sleep(1);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_ENTER);

            sleep(2);
        }
    }

