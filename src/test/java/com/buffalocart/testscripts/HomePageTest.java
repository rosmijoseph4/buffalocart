package com.buffalocart.testscripts;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.utility.DateUtility;
import com.buffalocart.utility.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePageTest extends Base {
    LoginPage loginPage;
    ExcelUtility excelUtility;
    HomePage homePage;
    DateUtility dateUtility;

    @Test(priority = 6, description = "TC_006 Verify home page tilte",groups = {"regression"})
    public void Verify_home_page_tilte() {
        loginPage = new LoginPage(driver);
        excelUtility = new ExcelUtility();
        String uname = excelUtility.readSingleData(1, 1, "loginpage");
        loginPage.enterUsername(uname);
        String pass = excelUtility.readSingleData(1, 2, "loginpage");
        loginPage.enterPassword(pass);
        homePage = loginPage.clickOnLoginButton();
        homePage.enterButtonEndTour();
        String actualhomepagetitle = homePage.getHomePageTitle();
        String expectedhomepagetitle = excelUtility.readSingleData(1, 1, "homepage");
        Assert.assertEquals(actualhomepagetitle, expectedhomepagetitle, "error:Invalid homepage Title");
    }

    @Test(priority = 7, description = "TC_007 Verify date displeyed in home page",groups = {"regression"})
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
        String actualdate = homePage.dateDisplay();
        Assert.assertEquals(actualdate, expecteddate, "Error:Invalid dates");
    }

    @Test(priority = 1, description = "TC_008 Verify whether user is navigating to login page by clicking on Sign out button",groups = {"regression"})
    public void Verify_whether_user_is_navigating_to_login_page_by_clicking_on_Sign_out_button() throws InterruptedException {
        loginPage = new LoginPage(driver);
        excelUtility = new ExcelUtility();
        String uname = excelUtility.readSingleData(1, 1, "loginpage");
        loginPage.enterUsername(uname);
        String pass = excelUtility.readSingleData(1, 2, "loginpage");
        loginPage.enterPassword(pass);
        homePage = loginPage.clickOnLoginButton();
        homePage=homePage.enterButtonEndTour();
        homePage=homePage.clickOnUser();
        loginPage=homePage.clickOnSignoutButton();
        String expectedtitle= excelUtility.readSingleData(1,0,"loginpage");
        String actual_title= loginPage.getLoginPageTitle();
        Assert.assertEquals(actual_title,expectedtitle,"Error:Title mismatch");
    }
    @Test(priority = 9,description = "TC_009 Verify the Usermangement sub tabs",groups = {"regression"})
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
        List<String> actual_options=homePage.getUserManagementOptions();
        List<String> expected_options=excelUtility.getExcelAsArrayList("UserManagementPage");
        Assert.assertEquals(actual_options,expected_options,"Error:Invalid Options");
    }
    }


