package com.thaonth.Bai22_23_ThucHanh.pages;

import com.thaonth.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class CustomerPage extends CommonPage {
    private WebDriver driver;

    public CustomerPage(WebDriver driver){
        super(driver);
        this.driver = driver;
//        new WebUI(driver);
    }

    By btnAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    By headerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    By inputSearchCustomer = By.xpath("//div[@id='clients_filter']//input[@placeholder ='Search...']");
    By firstItemCustomerName = By.xpath("//tbody/tr[1]/td[3]/a");
    By inputCompany = By.xpath("//input[@id='company']");
    By inpVat = By.xpath("//input[@id='vat']");
    By inputWebsite = By.xpath("//input[@id='website']");
    By inputPhone = By.xpath("//input[@id='phonenumber']");
    By dropdownGroup = By.xpath("//button[@data-id='groups_in[]']");
    By inputGroup = By.xpath("//button[@data-id='groups_in[]']/following-sibling::div//input");
    By dropdownCurrency = By.xpath("//button[@data-id='default_currency']");
    By inputCurrency = By.xpath("//button[@data-id='default_currency']/following-sibling::div//input");
    By selectDefaultLanguage = By.xpath("//button[@data-id='default_language']");
    By inputCity = By.xpath("//input[@id='city']");
    By inputStage = By.xpath("//input[@id='state']");
    By inputCode = By.xpath("//input[@id='zip']");
    By dropdownCountry = By.xpath("//button[@data-id='country']");
    By inputCountry = By.xpath("//button[@data-id='country']/following-sibling::div//input");
    By btnSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");
    By alertMessage = By.xpath("//span[@class='alert-title']");
    By totalCustomer = By.xpath("//span[normalize-space() = 'Total Customers']/preceding-sibling::span");


    //Ham xư ly cho Customer Page
    public String getTotalCustomer(){
        WebUI.waitForPageLoaded(driver);
        return WebUI.getText(totalCustomer);
    }

    public void clickAddNewButton(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(btnAddNewCustomer);

    }
    public void clickSaveButton(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(btnSave);
        WebUI.sleep(2);
        //Verify alert Message
        Assert.assertTrue(WebUI.elementDisplay(alertMessage),"FAIL!!! Alert Message not display");
        Assert.assertEquals(WebUI.getText(alertMessage), "Customer added successfully.", "FAIL!!! Content alert message not match");
    }

    public void inputDataAddNewCustomerForm(String customerName){
        WebUI.inputText(inputCompany, customerName);
        WebUI.inputText(inpVat, "10");
        WebUI.inputText(inputWebsite, "htts://anhtester.com");
        WebUI.inputText(inputPhone, "023456789");
        WebUI.clickElement(dropdownGroup);
        WebUI.sleep(1);
        WebUI.inputText(inputGroup, "VIP");
        WebUI.setKey(inputGroup, Keys.ENTER);
        WebUI.clickElement(dropdownGroup);
        WebUI.sleep(1);
        WebUI.clickElement(dropdownCurrency);
        WebUI.inputText(inputCurrency, "USD");
        WebUI.sleep(1);
        WebUI.setKey(inputCurrency, Keys.ENTER);
        WebUI.clickElement(dropdownCurrency);
        selectLanguage("Vietnamese");
        WebUI.inputText(inputCity, "Hanoi");
        WebUI.inputText(inputStage, "Caugiay");
        WebUI.inputText(inputCode, "100000");
        WebUI.clickElement(dropdownCountry);
        WebUI.sleep(1);
        WebUI.inputText(inputCountry, "Vietnam");
        WebUI.sleep(1);
        WebUI.setKey(inputCountry, Keys.ENTER);
    }

    public void selectLanguage(String language){
       // WebUI.clickElement(selectDefaultLanguage);
        driver.findElement(selectDefaultLanguage).click();
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath("//span[normalize-space()='"+language+"']"));
        WebUI.sleep(1);

    }

    public void checkCustomerInTableList(String customerName){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(menuCustomers);
        WebUI.waitForPageLoaded(driver);
        WebUI.inputText(inputSearchCustomer, customerName);
        WebUI.sleep(1);

        //Check customer name display in table
        Assert.assertTrue(WebUI.elementDisplay(firstItemCustomerName), "FAIL!! Customer Name is display");
        Assert.assertEquals(WebUI.getText(firstItemCustomerName),customerName, "FAIL!!! Customer name not match.");
    }
    public void checkCustomerDetail(String customerName){
        //Check customer detail in customer page
        WebUI.clickElement(firstItemCustomerName);
        Assert.assertEquals(driver.findElement(inputCompany).getAttribute("value"),customerName, "FAIL!!! The Customer Name not match");
        Assert.assertEquals(driver.findElement(inpVat).getAttribute("value"),"10", "FAIL!!! The VAT not match");
        Assert.assertEquals(driver.findElement(inputWebsite).getAttribute("value"),"htts://anhtester.com", "FAIL!!! The website not match");
        Assert.assertEquals(driver.findElement(inputPhone).getAttribute("value"),"023456789", "FAIL!!! The Phone number not match");
        Assert.assertEquals(driver.findElement(dropdownGroup).getAttribute("title"),"VIP", "FAIL!!! The Group not match");
        Assert.assertEquals(driver.findElement(dropdownCurrency).getAttribute("title"),"USD", "FAIL!!! The Currency not match");
        Assert.assertEquals(driver.findElement(inputCity).getAttribute("value"),"Hanoi" , "FAIL!!! The city not match");
        Assert.assertEquals(driver.findElement(inputStage).getAttribute("value"),"Caugiay" , "FAIL!!! The Stage not match");
        Assert.assertEquals(driver.findElement(selectDefaultLanguage).getAttribute("title"),"Vietnamese", "FAIL!!! The Language not match");
    }
}
