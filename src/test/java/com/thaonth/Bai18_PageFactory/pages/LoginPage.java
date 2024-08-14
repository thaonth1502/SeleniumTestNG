package com.thaonth.Bai18_PageFactory.pages;

import com.thaonth.constants.ConfigData;
import com.thaonth.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    // Khai báo driver cục bộ tỏng chính class này
    private WebDriver driver;
    private WebDriverWait wait;

    //Khai báo các element dạng đối tượng By ( phương thức tìm kiếm)
    @FindBy(xpath = "//h1[normalize-space()='Login']")  WebElement headerPage;
    @FindBy(xpath = "//input[@id='email']") WebElement inputEmail;
    @FindBy(xpath = "//input[@id='password']")  WebElement inputPassword;
    @FindBy(xpath = "//a[normalize-space()='Forgot Password?']")    WebElement linkForgotPassword;
    @FindBy(xpath = "//button[normalize-space()='Login']")  WebElement btnLogin;
    @FindBy(xpath = "//div[contains(@class,'alert alert-danger')]") WebElement errorMessage;
    @FindBy(xpath = "//span[normalize-space()='Dashboard']")         WebElement menuDashboard;


    // Hàm xây dựng cho từng class page
    public LoginPage(WebDriver driver){
        this.driver = driver;   //Nhận giá trị driver từ bên ngoài khi khởi tạo class

        PageFactory.initElements(driver, this);
    }


    //Khai báo các hàm xử lý thuộc trang Login

    public void enterEmail(String email){
        inputEmail.sendKeys(email);
    }

    public void enterPassword(String password){
        inputPassword.sendKeys(password);
    }

    public void clickLoginButton(){
        btnLogin.click();
    }

    public void loginCRM(String email, String password){
        driver.get(ConfigData.URL);
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public void verifyLoginSuccess(){
        WebUI.waitForPageLoaded(driver);
        Assert.assertTrue(menuDashboard.isDisplayed(), "FAIL, Can not redirect to Dashboard page");
        Assert.assertEquals(driver.getCurrentUrl(), "https://crm.anhtester.com/admin/", "FAIL, The current URL is not matching");
    }

    public void verifyLoginFail(String expectedMessage){
        WebUI.waitForPageLoaded(driver);
       // Assert.assertTrue(WebUI.checkElementExist(driver, errorMessage), "FAIL, The error message not display");
        Assert.assertEquals(errorMessage.getText(), expectedMessage, "FAIL, The content of error message is not matching" );
    }
}
