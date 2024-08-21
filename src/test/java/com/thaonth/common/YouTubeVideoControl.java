package com.thaonth.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class YouTubeVideoControl {

    WebDriver driver;
    @BeforeMethod
    public void createDriver(){
        driver =  new ChromeDriver();
        driver.get("https://www.youtube.com/watch?v=zHPNfLB2Tds");
    }
    @Test
    public void playVideoYoutube(){
        WebElement btnPlay = driver.findElement(By.xpath("(//div[@class='ytp-chrome-bottom']/descendant::a)/following-sibling::button"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000 * 10));
        String title =  btnPlay.getAttribute("title");
//            while (title.contains("Play")) {
                btnPlay.click();
                WebElement autoPlay = driver.findElement(By.xpath("//div[@class='ytp-autonav-toggle-button']"));
                autoPlay.click();
                wait.until(ExpectedConditions.attributeContains(btnPlay,"title", "Replay"));
                driver.navigate().refresh();
//            }
    }
    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }


}
