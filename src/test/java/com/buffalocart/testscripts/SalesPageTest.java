package com.buffalocart.testscripts;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SalesPage;
import com.buffalocart.utility.ExcelUtility;
import com.buffalocart.utility.FakerUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalesPageTest extends Base {
    LoginPage loginPage;
    ExcelUtility excelUtility;
    HomePage homePage;
    SalesPage salesPage;
    FakerUtility fakerUtility;


    @Test(priority = 14, description = "TC_028 Verify  Sales Commission Agents page title", groups = {"regression"})
    public void verify_Sales_Commission_Agents_page_title() {
        loginPage = new LoginPage(driver);
        excelUtility = new ExcelUtility();
        fakerUtility = new FakerUtility();
        String uname = excelUtility.readSingleData(1, 1, "loginpage");
        loginPage.enterUsername(uname);
        String pass = excelUtility.readSingleData(1, 2, "loginpage");
        loginPage.enterPassword(pass);
        homePage = loginPage.clickOnLoginButton();
        homePage.enterButtonEndTour();
        homePage = homePage.clickOnUserManagement();
        salesPage = homePage.clickOnSalesCommission();
        salesPage.clickOnAddAgent();
        String fname = fakerUtility.firstName();
        salesPage.enterFirstName(fname);
        String num = fakerUtility.salesDecimalNumber();
        salesPage.enterSalesPercentage(num);
        salesPage = salesPage.clickOnSaveAgent();
        String actualsalestitle = salesPage.getSalesPageTitle();
        String expectedsalestitle = excelUtility.readSingleData(1, 0, "salespage");
        Assert.assertEquals(actualsalestitle, expectedsalestitle, "Error:Invalid title");
    }

    @Test(priority = 26, description = "TC_031 Verify user can delete a Sales Commission Agents",groups = "regression")
    public void verify_user_can_delete_a_Sales_Commission_Agents() {
        loginPage = new LoginPage(driver);
        excelUtility = new ExcelUtility();
        fakerUtility = new FakerUtility();
        String uname = excelUtility.readSingleData(1, 1, "loginpage");
        loginPage.enterUsername(uname);
        String pass = excelUtility.readSingleData(1, 2, "loginpage");
        loginPage.enterPassword(pass);
        homePage = loginPage.clickOnLoginButton();
        homePage.enterButtonEndTour();
        homePage = homePage.clickOnUserManagement();
        salesPage = homePage.clickOnSalesCommission();
        salesPage.clickOnAddAgent();
        String fname = fakerUtility.firstName();
        salesPage.enterFirstName(fname);
        String num = fakerUtility.salesDecimalNumber();
        salesPage.enterSalesPercentage(num);
        salesPage = salesPage.clickOnSaveAgent();
        salesPage.searchAgent(fname);
        salesPage = salesPage.clickOnDeleteButton();
        salesPage = salesPage.clickOnOkButton();
        String actualmessage = salesPage.getMessage();
        System.out.println(actualmessage);
        String expectedmessage = excelUtility.readSingleData(1, 1, "salespage");
        System.out.println(expectedmessage);
        Assert.assertEquals(actualmessage, expectedmessage, "Error:Displayed message mismatch");
    }

    @Test(priority = 27, description = "TC_030 Verify Edit sales agent details",groups = "regression")
    public void verify_Edit_sales_agent_details() {
        loginPage = new LoginPage(driver);
        excelUtility = new ExcelUtility();
        fakerUtility = new FakerUtility();
        String uname = excelUtility.readSingleData(1, 1, "loginpage");
        loginPage.enterUsername(uname);
        String pass = excelUtility.readSingleData(1, 2, "loginpage");
        loginPage.enterPassword(pass);
        homePage = loginPage.clickOnLoginButton();
        homePage.enterButtonEndTour();
        homePage = homePage.clickOnUserManagement();
        salesPage = homePage.clickOnSalesCommission();
        salesPage.clickOnAddAgent();
        String fname = fakerUtility.firstName();
        salesPage.enterFirstName(fname);
        String num = fakerUtility.salesDecimalNumber();
        salesPage.enterSalesPercentage(num);
        salesPage = salesPage.clickOnSaveAgent();
        salesPage.searchAgent(fname);
        salesPage=salesPage.clickOnEditButton();
        String mail=fakerUtility.emailId();
        salesPage.enterMailId(mail);
        String cnumber=fakerUtility.contactNumber();
        salesPage.enterNumber(cnumber);
        salesPage.clickOnSaveSales();
        List<ArrayList<String>> actualTable_data=salesPage.getTableData();
        System.out.println(actualTable_data);
        String[] data={fname,mail,cnumber,"",num};
        List<ArrayList<String>> expectedTable_data=new ArrayList<ArrayList<String>>();
        expectedTable_data.add(new ArrayList<String>(Arrays.asList(data)));
        System.out.println(expectedTable_data);
        Assert.assertEquals(actualTable_data,expectedTable_data,"Error:Elements not matching");
    }
}


