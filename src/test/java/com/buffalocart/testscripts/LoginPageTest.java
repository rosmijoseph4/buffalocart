package com.buffalocart.testscripts;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.*;
import com.buffalocart.utility.*;
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
    UsersPage usersPage;
    AddUserPage addUserPage;

    @Test(priority = 1, description = "TC_001 Verify Login page title",groups = {"regression"})
    public void verify_Login_Page_Title() {
        loginPage = new LoginPage(driver);
        excelUtility=new ExcelUtility();
        String actualtitle = loginPage.getLoginPageTitle();
        String expectedtitle = excelUtility.readSingleData(1,0,"loginpage");
        Assert.assertEquals(actualtitle, expectedtitle, "Error:Invalid homepage title");
    }

    @Test(priority = 2, description = "TC_002 Verify user login with valid user credentials",groups = {"smoke"})
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
        String expectedname = excelUtility.readSingleData(1,0,"homepage");
        Assert.assertEquals(actualname, expectedname, "Error:Invalid login");
    }

    @Test(priority = 3, description ="TC_003 Verify the error message displayed for user login with invalid credentials",groups = {"regression"})
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
        String actualmessage=loginPage.getErrorMessage();
        Assert.assertEquals(actualmessage,expectedmessage,"Error:Error message not displayed");
    }

    @Test(priority = 4,description = "TC_004 Verify whether the user is able to click on Remember me checkbox",groups = {"regression"})
    public void verify_whetehr_the_user_is_able_to_click_on_Remember_me_checkbox(){
        loginPage = new LoginPage(driver);
        Boolean rememberme=loginPage.selectCheckBox();
        Assert.assertTrue(rememberme);
    }

    @Test(priority = 20,description = "TC_014 Verify user login with newly added user",groups = "regression")
    public void verify_user_login_with_newly_added_user(){
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
        usersPage = homePage.clickOnUserMenu();
        addUserPage = usersPage.clickOnAddUser();
        String fname = fakerUtility.firstName();
        String lname = fakerUtility.lastName();
        String mail = fakerUtility.emailId();
        String u_name = fakerUtility.userName();
        String pass_word = fakerUtility.password();
        addUserPage.enterFirstName(fname);
        addUserPage.enterLastName(lname);
        addUserPage.enterEmailId(mail);
        addUserPage.selectRole();
        addUserPage.enterUsername(u_name);
        addUserPage.enterPassword(pass_word);
        addUserPage.enterConfirmPassword(pass_word);
        usersPage = addUserPage.clickOnSave1();
        usersPage=usersPage.clickOnUser();
        loginPage=usersPage.clickOnSignOutButton();
        loginPage.enterUsername1(u_name);
        loginPage.enterPassword1(pass_word);
        homePage= loginPage.clickOnLoginButton();
        String actualname=homePage.getUserName();
        String expectedname=fname.concat(" "+lname);
        Assert.assertEquals(actualname,expectedname,"Error:Mismatch in username");
    }
}








