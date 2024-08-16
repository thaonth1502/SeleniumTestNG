package com.thaonth.keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class WebKeyword {

    private static WebDriver driver;
    private static int EXPLICIT_WAIT_TIMEOUT = 10;
    private static double STEP_TIME = 0.5;
    private static int PAGE_LOAD_TIMEOUT = 40;


    public WebKeyword(WebDriver driver) {
        this.driver = driver;
    }

    public static void sleep(double second){
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForElementVisible(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementToBeClickable(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementToBeSelected(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    public static void waitForElementPresence(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement getWebElement(By by){
        return driver.findElement(by);
    }

    public static Boolean checkElementExists(By by){
        List<WebElement> elementList = driver.findElements(by);
        if (elementList.size() > 0){
            System.out.println("checkElementExits: " + true + "..." + by);
            return true;
        } else {
            System.out.println("checkElementExits: " + false + "..." + by);
            return false;
        }
    }

    public static void logConsole(Object message){
        System.out.println(message);
    }

    public static void openURL(String url){
        driver.get(url);
        sleep(STEP_TIME);
        logConsole("Open: " + url);
    }

    public static void clickElement(By by){
        waitForElementVisible(by);
        sleep(STEP_TIME);
        driver.findElement(by).click();
        logConsole("Click Element: " + by);
    }

    public static String getText(By by){
        waitForElementVisible(by);
        sleep(STEP_TIME);
        return driver.findElement(by).getText();
    }
}
