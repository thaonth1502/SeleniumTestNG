package com.thaonth.B13_Alert_Popup_iFrame;

import com.thaonth.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class HandlePopup extends BaseTest {

    @Test
    public void demoOpenTab(){
        driver.get("https://anhtester.com");
        sleep(2);
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://google.com");
        sleep(2);
    }

    @Test
    public void demoOpenWindow(){
        driver.get("https://anhtester.com");
        sleep(2);
        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://google.com");
        sleep(2);
    }

    @Test
    public void demoNotSwitchToTab() {
        driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");
        sleep(2);
        driver.findElement(By.xpath("//a[normalize-space()='Like us On Facebook']")).click();
        sleep(2);
        //Sau khi chuyển hướng sang Tab mới thì getText cái element nào đó
        System.out.println(driver.findElement(By.xpath("(//span[normalize-space() = 'See more on Facebook'])[1]")).getText());
        sleep(1);
    }

    @Test
    public void testSwitchToPopupWithForLoop(){
        driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");
        sleep(2);
        driver.findElement(By.xpath("//a[normalize-space()='Like us On Facebook']")).click();
        sleep(2);

        //Lưu lại window đầu tiên
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);

        //Lấy tất cả ccs mã định danh Tab Window

        Set<String> windows = driver.getWindowHandles();

        for (String window : windows){
            System.out.println(window);
            if(!mainWindow.equals(window)){

                driver.switchTo().window(window);
                System.out.println("Đã chuyển đến cửa sổ mới");
                driver.switchTo().window(window).getTitle();
                driver.switchTo().window(window).getCurrentUrl();
                sleep(1);

                System.out.println(driver.findElement(By.xpath("(//span[normalize-space() = 'See more on Facebook'])[1]")).getText());
                sleep(1);
                driver.close();
            }
        }
        //Chuyển về cửa số chính
        driver.switchTo().window(mainWindow);
        System.out.println("Đã chuyển về window chính: " + driver.getCurrentUrl());
        sleep(1);
    }

    @Test
    public void testSwitchToPopupWithPosition(){
        driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");
        sleep(2);
        driver.findElement(By.xpath("//a[normalize-space()='Like us On Facebook']")).click();
        sleep(2);

        //Lưu lại window đầu tiên
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);

        //Lấy tất cả ccs mã định danh Tab Window

        Set<String> windows = driver.getWindowHandles();
        //Chuyen huong den cua so cu th

        String firstWindow = (String) windows.toArray()[0];
        System.out.println("Fisrt Window: " + firstWindow);

        String secondWindow = (String) windows.toArray()[1];
        System.out.println("Second Window: " + secondWindow);

        //Chuyen huong den cua so thu 2
        driver.switchTo().window(secondWindow);
        System.out.println("Đã chuyển đến cửa sổ mới");
        driver.switchTo().window(secondWindow).getTitle();
        driver.switchTo().window(secondWindow).getCurrentUrl();
        sleep(1);

        System.out.println(driver.findElement(By.xpath("(//span[normalize-space() = 'See more on Facebook'])[1]")).getText());
        sleep(1);

        //Tat cua so thu 2
        driver.close();
        //Chuyển về cửa số chính
        driver.switchTo().window(mainWindow);
        System.out.println("Đã chuyển về window chính: " + driver.getCurrentUrl());
        sleep(1);
    }
}
