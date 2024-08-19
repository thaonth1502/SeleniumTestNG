package com.thaonth.Bai24_Parameter_MultiBrowser.pages;

import com.thaonth.keywords.WebKeywords;
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
        WebKeywords.waitForPageLoaded();
        WebKeywords.clickElement(menuCustomers);
        return new CustomerPage(driver);
    }

    public DashboardPage clickMenuDashboard(){
        WebKeywords.waitForPageLoaded();
        WebKeywords.clickElement(menuDashboard);
        return new DashboardPage(driver);
    }

    public ProjectPage clickMenuProjects(){
        WebKeywords.waitForPageLoaded();
        WebKeywords.clickElement(menuProjects);
        return new ProjectPage(driver);
    }

}
