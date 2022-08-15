package com.buffalocart.testscripts;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.AddUserPage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.UsersPage;
import com.buffalocart.utility.ExcelUtility;
import com.buffalocart.utility.FakerUtility;
import com.buffalocart.utility.TableUtility;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersPageTest extends Base {
    LoginPage loginPage;
    ExcelUtility excelUtility;
    HomePage homePage;
    UsersPage usersPage;
    AddUserPage addUserPage;
    FakerUtility fakerUtility;
    TableUtility tableUtility;

    @Test(priority = 10, description = "TC_010 Verify users title page", groups = {"regression"})
    public void verify_Users_page_title() {
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
        String expecteduserpagetitle = usersPage.getUserPageTitle();
        String actualuserpagetitle = excelUtility.readSingleData(1, 0, "userpage");
        Assert.assertEquals(actualuserpagetitle, expecteduserpagetitle, "Error:Title mismatch");
    }

    @Test(priority = 18, description = "TC_011 Verify  user search with valid data", groups = {"regression"})
    public void verify_user_search_with_valid_data() {
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

  @Test(priority = 19,description = "TC_012 Verify message displayed by  user search with invalid data",groups = {"smoke"})
    public void verify_message_displayed_by_user_search_with_invalid_data(){
      loginPage = new LoginPage(driver);
      excelUtility = new ExcelUtility();
      fakerUtility = new FakerUtility();
      tableUtility=new TableUtility();
      String uname = excelUtility.readSingleData(1, 1, "loginpage");
      loginPage.enterUsername(uname);
      String pass = excelUtility.readSingleData(1, 2, "loginpage");
      loginPage.enterPassword(pass);
      homePage = loginPage.clickOnLoginButton();
      homePage.enterButtonEndTour();
      homePage = homePage.clickOnUserManagement();
      usersPage = homePage.clickOnUserMenu();
      String mail=fakerUtility.emailId();
      usersPage.enterInvalidEmail(mail);
      String actualmessage =usersPage.messageDisplay();
      System.out.println(actualmessage);
      String expectedmessage=excelUtility.readSingleData(1,3,"userpage");
      System.out.println(expectedmessage);
      Assert.assertEquals(actualmessage,expectedmessage,"Error:Incorrect message");
    }

    @Test(priority = 22,description = "TC_019 Verify user can delete a user",groups = "regression")
    public void verify_user_can_delete_a_user(){
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
        usersPage.clickOnDeleteUserButton();
        usersPage=usersPage.clickOnOkButton();
        usersPage.enterSearchValue(mail);
        String actualmessage =usersPage.messageDisplay();
        System.out.println(actualmessage);
        String expectedmessage=excelUtility.readSingleData(1,3,"userpage");
        System.out.println(expectedmessage);
        Assert.assertEquals(actualmessage,expectedmessage,"Error:Incorrect message");
    }



}
