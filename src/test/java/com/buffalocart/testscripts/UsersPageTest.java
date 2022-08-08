package com.buffalocart.testscripts;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.UsersPage;
import com.buffalocart.utility.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersPageTest extends Base {
    LoginPage loginPage;
    ExcelUtility excelUtility;
    HomePage homePage;
    UsersPage usersPage;
    @Test(priority = 10,description = "TC_010 Verify users title page",groups = {"smoke","regression"})
    public void verify_Users_page_title(){
        loginPage = new LoginPage(driver);
        excelUtility=new ExcelUtility();
        String uname = excelUtility.readSingleData(1,1,"loginpage");
        loginPage.enterUsername(uname);
        String pass = excelUtility.readSingleData(1,2,"loginpage");
        loginPage.enterPassword(pass);
        homePage = loginPage.clickOnLoginButton();
        homePage.enterButtonEndTour();
        homePage=homePage.clickOnUserManagement();
        usersPage=homePage.clickOnUsers();
        String expecteduserpagetitle=usersPage.getUserPageTitle();
        System.out.println(expecteduserpagetitle);
        String actualuserpagetitle=excelUtility.readSingleData(1,0,"userpage");
        System.out.println(actualuserpagetitle);
        Assert.assertEquals(actualuserpagetitle,expecteduserpagetitle,"Error:Title mismatch");
    }
}
