package com.buffalocart.testscripts;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.*;
import com.buffalocart.utility.ExcelUtility;
import com.buffalocart.utility.FakerUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditUserPageTest extends Base {
    LoginPage loginPage;
    ExcelUtility excelUtility;
    HomePage homePage;
    UsersPage usersPage;
    EditUserPage editUserPage;
    AddUserPage addUserPage;
    FakerUtility fakerUtility;
    @Test(priority = 15,description = "TC017 Verify Edit User page title",groups = "regression")
    public void verify_Edit_User_page_title(){
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
        String job = addUserPage.selectRole();
        addUserPage.enterUsername(u_name);
        addUserPage.enterPassword(pass_word);
        addUserPage.enterConfirmPassword(pass_word);
        usersPage = addUserPage.clickOnSave1();
        usersPage.enterSearchValue(mail);
        editUserPage=usersPage.clickOnEdit();
        String actualedittitle=editUserPage.getEditUserPageTitle();
        String expectededittitle=excelUtility.readSingleData(1,0,"edituser");
        Assert.assertEquals(actualedittitle,expectededittitle,"Error:Invalid title");
    }

    @Test(priority = 21,description = "TC_018 Verify  user can edit the user details",groups = "regression")
    public void verify_user_can_edit_the_user_details(){
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
        String job = addUserPage.selectRole();
        addUserPage.enterUsername(u_name);
        addUserPage.enterPassword(pass_word);
        addUserPage.enterConfirmPassword(pass_word);
        usersPage = addUserPage.clickOnSave1();
        usersPage.enterSearchValue(mail);
        editUserPage=usersPage.clickOnEdit();
        editUserPage.clearMailId();
        String newmail=fakerUtility.emailIdNew();
        String expectedmail=newmail;
        editUserPage.enterNewMail(newmail);
        editUserPage.clickOnUpdate();
        usersPage.enterSearchNewValue(newmail);
        String actualmail=usersPage.newMailId();
        Assert.assertEquals(actualmail,expectedmail,"Error:Mailid's mismatch");
    }
}
