package com.thaonth.Bai20_ThucHanhPOM.pages;

import com.thaonth.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage {
    private WebDriver driver;

    public CommonPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    //Elements
    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    public By menuSales = By.xpath("//li[@class='menu-item-sales']");
    public By iconNotification = By.xpath("//a[contains(@class,'notifications-icon')]");

    public CustomerPage clickMenuCustomer(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(menuCustomers);
        return new CustomerPage(driver);
    }

    public DashboardPage clickMenuDashboard(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(menuDashboard);
        return new DashboardPage(driver);
    }

    public ProjectPage clickMenuProjects(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(menuProjects);
        return new ProjectPage(driver);
    }

}
