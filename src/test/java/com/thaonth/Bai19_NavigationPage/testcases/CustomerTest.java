package com.thaonth.Bai19_NavigationPage.testcases;

import com.thaonth.Bai19_NavigationPage.pages.CommonPage;
import com.thaonth.Bai19_NavigationPage.pages.CustomerPage;
import com.thaonth.Bai19_NavigationPage.pages.DashboardPage;
import com.thaonth.Bai19_NavigationPage.pages.LoginPage;
import com.thaonth.common.BaseTest;
import com.thaonth.constants.ConfigData;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    CommonPage commonPage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testAddNewCustomer(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.logInCRM(ConfigData.EMAIL, ConfigData.PASSWORD);

        customerPage = loginPage.clickMenuCustomer();
        customerPage.inputDataAddNewCustomerForm("ThaoNTH");
        customerPage.checkCustomerDetail("ThaoNTH");




    }
}
