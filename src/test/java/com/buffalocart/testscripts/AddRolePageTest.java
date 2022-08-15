package com.buffalocart.testscripts;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.AddRolePage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.RolesPage;
import com.buffalocart.utility.ExcelUtility;
import com.buffalocart.utility.FakerUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRolePageTest extends Base {
    LoginPage loginPage;
    ExcelUtility excelUtility;
    HomePage homePage;
    RolesPage rolesPage;
    AddRolePage addRolePage;
    FakerUtility fakerUtility;
@Test(priority = 13,description = "TC_022 Verify Add Roles page title",groups = {"regression"})
    public void verify_Add__Roles_page_title(){
    loginPage = new LoginPage(driver);
    excelUtility=new ExcelUtility();
    fakerUtility=new FakerUtility();
    String uname = excelUtility.readSingleData(1,1,"loginpage");
    loginPage.enterUsername(uname);
    String pass = excelUtility.readSingleData(1,2,"loginpage");
    loginPage.enterPassword(pass);
    homePage = loginPage.clickOnLoginButton();
    homePage.enterButtonEndTour();
    homePage=homePage.clickOnUserManagement();
    rolesPage=homePage.clickOnRoles();
    addRolePage=rolesPage.clickOnAddRole();
    String userrole=fakerUtility.role();
    addRolePage.enterRole(userrole);
    rolesPage=addRolePage.clickOnSaveRole();
    addRolePage=rolesPage.clickOnAddRole();
    String actualaddrolepagetitle=addRolePage.getAddRolePageTitle();
    System.out.println(actualaddrolepagetitle);
    String expectedaddrolepagetitle=excelUtility.readSingleData(1,0,"addrole");
    System.out.println(expectedaddrolepagetitle);
    Assert.assertEquals(actualaddrolepagetitle,expectedaddrolepagetitle,"Error:Title mismatch");
}

@Test(priority=23,description = "TC_023 Verify  user can add roles",groups = "smoke")
    public void verify_user_can_add_roles(){
        loginPage = new LoginPage(driver);
        excelUtility=new ExcelUtility();
        fakerUtility=new FakerUtility();
        String uname = excelUtility.readSingleData(1,1,"loginpage");
        loginPage.enterUsername(uname);
        String pass = excelUtility.readSingleData(1,2,"loginpage");
        loginPage.enterPassword(pass);
        homePage = loginPage.clickOnLoginButton();
        homePage.enterButtonEndTour();
        homePage=homePage.clickOnUserManagement();
        rolesPage=homePage.clickOnRoles();
        addRolePage=rolesPage.clickOnAddRole();
        String userrole=fakerUtility.role();
        addRolePage.enterRole(userrole);
        rolesPage=addRolePage.clickOnSaveRole();
        rolesPage.searchRole(userrole);
        String expectedrole=userrole;
        String actualrole=rolesPage.getRoleOfUser();
        Assert.assertEquals(actualrole,expectedrole,"Error:Role mismatch");
}
}
