package com.buffalocart.testscripts;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.*;
import com.buffalocart.utility.ExcelUtility;
import com.buffalocart.utility.FakerUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditRolePageTest extends Base {
    LoginPage loginPage;
    ExcelUtility excelUtility;
    HomePage homePage;
    RolesPage rolesPage;
    EditRolePage editRolePage;
    AddRolePage addRolePage;
    FakerUtility fakerUtility;
    @Test(priority = 16,description = "TC_024 Verify Edit Role page title",groups = "regression")
    public void verify_Edit_Role_page_title(){
        loginPage = new LoginPage(driver);
        excelUtility = new ExcelUtility();
        FakerUtility fakerUtility=new FakerUtility();
        String uname = excelUtility.readSingleData(1, 1, "loginpage");
        loginPage.enterUsername(uname);
        String pass = excelUtility.readSingleData(1, 2, "loginpage");
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
        editRolePage=rolesPage.clickOnEditRole1();
        String actualeditrolepagetitle=editRolePage.getEditRolePageTitle();
        String expectededitrolepagetitle=excelUtility.readSingleData(1,0,"editrole");
        Assert.assertEquals(actualeditrolepagetitle,expectededitrolepagetitle,"Error:Title mismatch");
    }

    @Test(priority = 24,description = "TC_025 Verify user can update  a role",groups = "regression")
    public void verify_user_can_update_a_role(){
        loginPage = new LoginPage(driver);
        excelUtility = new ExcelUtility();
        fakerUtility=new FakerUtility();
        String uname = excelUtility.readSingleData(1, 1, "loginpage");
        loginPage.enterUsername(uname);
        String pass = excelUtility.readSingleData(1, 2, "loginpage");
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
        editRolePage=rolesPage.clickOnEditRole1();
        editRolePage.clearRole();
        String newrole=fakerUtility.roleNew();
        editRolePage.addNewRole(newrole);
        rolesPage=editRolePage.clickOnUpdateRole();
        rolesPage.searchRole(newrole);
        String atualrole=rolesPage.newRole();
        Assert.assertEquals(atualrole,newrole,"Error:Roles mismatch");
    }
}
