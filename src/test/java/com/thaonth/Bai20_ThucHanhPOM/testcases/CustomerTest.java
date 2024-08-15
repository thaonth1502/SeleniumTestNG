package com.thaonth.Bai20_ThucHanhPOM.testcases;

import com.thaonth.Bai20_ThucHanhPOM.pages.CommonPage;
import com.thaonth.Bai20_ThucHanhPOM.pages.CustomerPage;
import com.thaonth.Bai20_ThucHanhPOM.pages.DashboardPage;
import com.thaonth.Bai20_ThucHanhPOM.pages.LoginPage;
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
        customerPage.clickAddNewButton();
        customerPage.inputDataAddNewCustomerForm("15082024 Anh Tester");
        customerPage.clickSaveButton();
      //  customerPage.checkCustomerDetail("ThaoNTH");
    }
}
