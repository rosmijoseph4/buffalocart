package com.buffalocart.testscripts;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.ResetPasswordPage;
import com.buffalocart.utility.DateUtility;
import com.buffalocart.utility.ExcelUtility;
import com.buffalocart.utility.FakerUtility;
import com.buffalocart.utility.WaitUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {
    LoginPage loginPage;
    ExcelUtility excelUtility;
    HomePage homePage;
    FakerUtility fakerUtility;
    DateUtility dateUtility;
    WaitUtility waitUtility;

    @Test(priority = 1, description = "TC_001 Verify Login page title",groups = {"smoke","regression"})
    public void verify_Login_Page_Title() {
        loginPage = new LoginPage(driver);
        excelUtility=new ExcelUtility();
        String actualtitle = loginPage.getLoginPageTitle();
        System.out.println(actualtitle);
        String expectedtitle = excelUtility.readSingleData(1,0,"loginpage");
        System.out.println(expectedtitle);
        Assert.assertEquals(actualtitle, expectedtitle, "Error:Invalid homepage title");
    }

    @Test(priority = 2, description = "TC_002 Verify user login with valid user credentials",groups = {"smoke","regression"})
    public void verify_user_login_with_valid_user_credentials() {
        loginPage = new LoginPage(driver);
        excelUtility=new ExcelUtility();
        String uname = excelUtility.readSingleData(1,1,"loginpage");
        loginPage.enterUsername(uname);
        System.out.println(uname);
        String pass = excelUtility.readSingleData(1,2,"loginpage");
        loginPage.enterPassword(pass);
        System.out.println(pass);
        homePage = loginPage.clickOnLoginButton();
        homePage.enterButtonEndTour();
        String actualname = homePage.getUserName();
        System.out.println(actualname);
        String expectedname = excelUtility.readSingleData(1,0,"homepage");
        System.out.println(expectedname);
        Assert.assertEquals(actualname, expectedname, "Error:Invalid login");
    }

    @Test(priority = 3, description ="TC_003 Verify the error message displayed for user login with invalid credentials",groups = {"smoke","regression"})
    public void verify_the_error_message_displayed_for_user_login_with_invalid_credentials() {
        loginPage = new LoginPage(driver);
        excelUtility=new ExcelUtility();
       fakerUtility=new FakerUtility();
       String uname= fakerUtility.userName();
       String pass=fakerUtility.password();
       loginPage.enterUsername(uname);
       loginPage.enterPassword(pass);
       homePage= loginPage.clickOnLoginButton();
       String expectedmessage= excelUtility.readSingleData(1,3,"loginpage");
       System.out.println(expectedmessage);
       String actualmessage=loginPage.getErrorMessage();
        System.out.println(actualmessage);
       Assert.assertEquals(actualmessage,expectedmessage,"Error:Error message not displayed");
    }

    @Test(priority = 4,description = "TC_004 Verify whether the user is able to click on Remember me checkbox",groups = {"smoke","regression"})
    public void verify_whetehr_the_user_is_able_to_click_on_Remember_me_checkbox(){
        loginPage = new LoginPage(driver);
        Boolean rememberme=loginPage.selectCheckBox();
        System.out.println(rememberme);
        Assert.assertTrue(rememberme);
    }

    }








