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

public class RolesPageTest extends Base {
    LoginPage loginPage;
    ExcelUtility excelUtility;
    HomePage homePage;
    RolesPage rolesPage;
    FakerUtility fakerUtility;
    AddRolePage addRolePage;

@Test(priority = 12,description = "TC_021 Verify Roles page title",groups = {"regression"})
    public void verify_Roles_page_title(){
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
    String actualrolespagetitle=rolesPage.getRolesPageTitle();
    String Expectedrolespagetitle=excelUtility.readSingleData(1,0,"rolespage");
    Assert.assertEquals(actualrolespagetitle,Expectedrolespagetitle,"Error:Title mismatch");
    }

    @Test(priority = 25,description = "TC_026 Verify user can delete a role from the list",groups = "regression")
    public void verify_user_can_delete_a_role_from_the_list(){
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
        rolesPage.clickOnDeleteRoleButton();
        rolesPage=rolesPage.clickOnOkButton();
        String actualmessage =rolesPage.messageDisplay();
        String expectedmessage=excelUtility.readSingleData(1,1,"rolespage");
        Assert.assertEquals(actualmessage,expectedmessage,"Error:Incorrect message");
}

@Test(priority = 29,description = "TC_027 Verify whether the added role in Role page is listed in roles field in user add page",groups = "regression")
    public void verify_whether_the_added_role_in_Role_page_is_listed_in_roles_field_in_user_add_page(){
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
    String newrole= rolesPage.newRole();
    Assert.assertEquals(userrole,newrole,"Error:Roles not matching");
}
}
