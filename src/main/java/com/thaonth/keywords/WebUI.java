package com.thaonth.keywords;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebUI {
    private static WebDriver driver;

    public WebUI(WebDriver driver){
        this.driver = driver;
    }
     public static void sleep(double second) {
            try {
                Thread.sleep((long) (1000 * second));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public static void waitForElementVisible(By by) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }

        public static void waitForElementClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        }

        public static Boolean elementDisplay(By by){
           if (driver.findElement(by).isDisplayed())
               return true;
           else return false;
        }

        public static void clickElement(By by){
            waitForElementClickable(by);
            driver.findElement(by).click();
        }

        public static void inputText(By by, String text){
            driver.findElement(by).sendKeys(text);
        }

        public static void setKey(By by, Keys keys){
        driver.findElement(by).sendKeys(keys);
         }

        public static String getText(By by){
            waitForElementVisible(by);
            return driver.findElement(by).getText().trim();
        }

        public static void waitForElementVisible(WebDriver driver, By by, int second) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }

        public static void waitForElementPresent(WebDriver driver, By by, int second) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));

            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }

        public static void waitForElementClickable(WebDriver driver, By by, int second) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second),  Duration.ofMillis(500));

            wait.until(ExpectedConditions.elementToBeClickable(by));
        }

        public static Boolean checkElementExist(WebDriver driver, By by) {
            List<WebElement> listElement = driver.findElements(by);

            if (!listElement.isEmpty()) {
                System.out.println("Element " + by + " existing.");
                return true;
            } else {
                System.out.println("Element " + by + " NOT exist.");
                return false;
            }
        }

        public static Boolean checkElementExist(WebDriver driver, String xpath) {
            List<WebElement> listElement = driver.findElements(By.xpath(xpath));

            if (!listElement.isEmpty()) {
                System.out.println("Element " + xpath + " existing.");
                return true;
            } else {
                System.out.println("Element " + xpath + " NOT exist.");
                return false;
            }
        }

        public static void waitForElementSelected(WebDriver driver, WebElement element, int second){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeSelected(element));
        }
        public static void waitForElementSelected(WebDriver driver, By by, int second){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second), Duration.ofMillis(500));
        wait.until(ExpectedConditions.elementToBeSelected(by));
        }


        /**
         * Wait for Page loaded
         * Chờ đợi trang tải xong (Javascript tải xong)
         */
        public static void waitForPageLoaded(WebDriver driver) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            //Wait for Javascript to load
            ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return js.executeScript("return document.readyState").toString().equals("complete");
                }
            };

            //Check JS is Ready
            boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

            //Wait Javascript until it is Ready!
            if (!jsReady) {
                System.out.println("Javascript is NOT Ready.");
                //Wait for Javascript to load
                try {
                    wait.until(jsLoad);
                } catch (Throwable error) {
                    error.printStackTrace();
                    Assert.fail("FAILED. Timeout waiting for page load.");
                }
            }
        }

    }

