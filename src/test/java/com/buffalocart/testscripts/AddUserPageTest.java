package com.buffalocart.testscripts;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.AddUserPage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.UsersPage;
import com.buffalocart.utility.ExcelUtility;
import com.buffalocart.utility.FakerUtility;
import com.buffalocart.utility.TableUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddUserPageTest extends Base {
    LoginPage loginPage;
    ExcelUtility excelUtility;
    HomePage homePage;
    UsersPage usersPage;
    AddUserPage addUserPage;
    FakerUtility fakerUtility;
    TableUtility tableUtility;
    @Test(priority = 11,description = "TC_015 Verify  Add Users page title",groups = {"regression"})
    public void verify_Add_Users_page_title(){
        loginPage=new LoginPage(driver);
        excelUtility=new ExcelUtility();
        fakerUtility=new FakerUtility();
        String uname=excelUtility.readSingleData(1,1,"loginpage");
        loginPage.enterUsername(uname);
        String pass=excelUtility.readSingleData(1,2,"loginpage");
        loginPage.enterPassword(pass);
        homePage=loginPage.clickOnLoginButton();
        homePage.enterButtonEndTour();
        homePage.clickOnUserManagement();
        usersPage=homePage.clickOnUserMenu();
        addUserPage=usersPage.clickOnAddUser();
        String fname=fakerUtility.firstName();
        String lname=fakerUtility.lastName();
        String u_name=fakerUtility.userName();
        String pass_word=fakerUtility.password();
        addUserPage.enterFirstName(fname);
        addUserPage.enterLastName(lname);
        addUserPage.selectRole();
        addUserPage.enterUsername(u_name);
        addUserPage.enterPassword(pass_word);
        addUserPage.enterConfirmPassword(pass_word);
        addUserPage=addUserPage.clickOnSave();
        String actualaddusertitle=addUserPage.getAddUserTitle();
        String expectedaddusertitle=excelUtility.readSingleData(1,0,"adduser");
        Assert.assertEquals(actualaddusertitle,expectedaddusertitle,"Error:Title mismatch");
    }

    @Test(priority = 17,description = "TC_013 Verify the error message displayed without filling mandatory fields in add user form",groups = "regression")
    public void verify_the_error_message_displayed_without_filling_mandatory_fields_in_add_user_form(){
        loginPage=new LoginPage(driver);
        excelUtility=new ExcelUtility();
        fakerUtility=new FakerUtility();
        String uname=excelUtility.readSingleData(1,1,"loginpage");
        loginPage.enterUsername(uname);
        String pass=excelUtility.readSingleData(1,2,"loginpage");
        loginPage.enterPassword(pass);
        homePage=loginPage.clickOnLoginButton();
        homePage.enterButtonEndTour();
        homePage.clickOnUserManagement();
        usersPage=homePage.clickOnUserMenu();
        addUserPage=usersPage.clickOnAddUser();
        String fname=fakerUtility.firstName();
        String lname=fakerUtility.lastName();
        String u_name=fakerUtility.userName();
        String pass_word=fakerUtility.password();
        addUserPage.enterFirstName(fname);
        addUserPage.enterLastName(lname);
        addUserPage.selectRole();
        addUserPage.enterUsername(u_name);
        addUserPage.enterPassword(pass_word);
        addUserPage.enterConfirmPassword(pass_word);
        addUserPage=addUserPage.clickOnSave();
        String actualmessage=addUserPage.getErrorMessage();
        String expectedmessage=excelUtility.readSingleData(1,1,"adduser");
        Assert.assertEquals(actualmessage,expectedmessage,"Error:Invalid message");
    }

    @Test(priority = 28,description = "TC_016 Verify  user can add user details",groups = "smoke")
    public void verify_user_can_add_user_details(){
        loginPage = new LoginPage(driver);
        excelUtility = new ExcelUtility();
        fakerUtility = new FakerUtility();
        tableUtility = new TableUtility();
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
        String[] data={u_name,fname.concat(" "+lname),job,mail};
        List<ArrayList<String>> expectedTable_data=new ArrayList<ArrayList<String>>();
        expectedTable_data.add(new ArrayList<String>(Arrays.asList(data)));
        List<ArrayList<String>> actualTable_data=usersPage.getTableData();
        System.out.println(expectedTable_data);
        System.out.println(actualTable_data);
        Assert.assertEquals(actualTable_data,expectedTable_data,"Error:Invalid data");
    }
}
