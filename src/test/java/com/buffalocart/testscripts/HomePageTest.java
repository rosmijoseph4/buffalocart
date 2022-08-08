package com.buffalocart.testscripts;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.utility.DateUtility;
import com.buffalocart.utility.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends Base {
    LoginPage loginPage;
    ExcelUtility excelUtility;
    HomePage homePage;
    DateUtility dateUtility;

    @Test(priority = 6, description = "TC_006 Verify home page tilte",groups = {"smoke","regression"})
    public void Verify_home_page_tilte() {
        loginPage = new LoginPage(driver);
        excelUtility = new ExcelUtility();
        String uname = excelUtility.readSingleData(1, 1, "loginpage");
        loginPage.enterUsername(uname);
        String pass = excelUtility.readSingleData(1, 2, "loginpage");
        loginPage.enterPassword(pass);
        homePage = loginPage.clickOnLoginButton();
        //homePage.enterButtonEndTour();
        String actualhomepagetitle = homePage.getHomePageTitle();
        System.out.println(actualhomepagetitle);
        String expectedhomepagetitle = excelUtility.readSingleData(1, 1, "homepage");
        System.out.println(expectedhomepagetitle);
        Assert.assertEquals(actualhomepagetitle, expectedhomepagetitle, "error:Invalid homepage Title");
    }

    @Test(priority = 7, description = "TC_007 Verify date displeyed in home page",groups = {"smoke","regression"})
    public void Verify_date_displeyed_in_home_page() {
        loginPage = new LoginPage(driver);
        excelUtility = new ExcelUtility();
        String uname = excelUtility.readSingleData(1, 1, "loginpage");
        loginPage.enterUsername(uname);
        String pass = excelUtility.readSingleData(1, 2, "loginpage");
        loginPage.enterPassword(pass);
        homePage = loginPage.clickOnLoginButton();
        dateUtility = new DateUtility();
        String expecteddate = dateUtility.getCurrentDate();
        System.out.println(expecteddate);
        String actualdate = homePage.dateDisplay();
        System.out.println(actualdate);
        Assert.assertEquals(actualdate, expecteddate, "Error:Invalid dates");
    }

    @Test(priority = 1, description = "TC_008 Verify whether user is navigating to login page by clicking on Sign out button",groups = {"smoke","regression"})
    public void Verify_whether_user_is_navigating_to_login_page_by_clicking_on_Sign_out_button() throws InterruptedException {
        loginPage = new LoginPage(driver);
        excelUtility = new ExcelUtility();
        String uname = excelUtility.readSingleData(1, 1, "loginpage");
        loginPage.enterUsername(uname);
        String pass = excelUtility.readSingleData(1, 2, "loginpage");
        loginPage.enterPassword(pass);
        homePage = loginPage.clickOnLoginButton();
        homePage.enterButtonEndTour();
        homePage.clickOnUser();
        homePage.clickOnSignoutButton();
        String expectedtitle= excelUtility.readSingleData(1,0,"loginpage");
        System.out.println(expectedtitle);
        String actualtitle= loginPage.getLoginPageTitle();
        System.out.println(actualtitle);
        Assert.assertEquals(actualtitle,expectedtitle,"Error:Title mismatch");
    }
    @Test(priority = 9,description = "TC_009 Verify the Usermangement sub tabs",groups = {"smoke","regression"})
    public void verify_the_Usermangement_sub_tabs(){
        loginPage = new LoginPage(driver);
        excelUtility = new ExcelUtility();
        String uname = excelUtility.readSingleData(1, 1, "loginpage");
        loginPage.enterUsername(uname);
        String pass = excelUtility.readSingleData(1, 2, "loginpage");
        loginPage.enterPassword(pass);
        homePage = loginPage.clickOnLoginButton();
        homePage.enterButtonEndTour();
        homePage=homePage.clickOnUserManagement();
        Boolean actual_user=homePage.getUser();
        System.out.println(actual_user);
        Assert.assertTrue(actual_user);
        Boolean actual_roles=homePage.getRoles();
        System.out.println(actual_roles);
        Assert.assertTrue(actual_roles);
        Boolean actual_sales=homePage.getSales();
        System.out.println(actual_sales);
        Assert.assertTrue(actual_sales);
    }

}
