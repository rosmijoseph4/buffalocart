package com.buffalocart.pages;

import com.buffalocart.utility.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RolesPage extends ObjectUtility {
    public WebDriver driver;
    public RolesPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
    WebElement addRole;

    @FindBy(xpath = "//table[@id=\"roles_table\"]/tbody/tr[7]/td[2]/a")
    WebElement editRoleButton;

      @FindBy(xpath = "//table[@id='roles_table']/tbody/tr/td//a[@class='btn btn-xs btn-primary']")
    WebElement editRoleButton1;

    @FindBy(xpath="//input[@class='form-control input-sm']")
    WebElement searchButton;

    @FindBy(xpath="//table[@id='roles_table']/tbody/tr/td")
    WebElement roleOfUser;
    @FindBy(xpath = "//table[@id='roles_table']/tbody/tr/td[@class='sorting_1']")
    WebElement roleUpdate;

    @FindBy(xpath = "//table[@id='roles_table']/tbody/tr/td[2]//button[@class='btn btn-xs btn-danger delete_role_button']")
    WebElement deleteRoleButton;

    @FindBy(xpath ="//button[@class='swal-button swal-button--confirm swal-button--danger']" )
    WebElement deleteOkButton;

    @FindBy(xpath = "//table[@id='roles_table']/tbody/tr/td[@class='dataTables_empty']")
    WebElement roleMessage;
    public AddRolePage clickOnAddRole(){
        page.clickOnElement(addRole);
        return new AddRolePage(driver);
    }
    public String getRolesPageTitle(){
        String rolespagetitle=page.getPageTitle(driver);
        return rolespagetitle;
    }
    public EditRolePage clickOnEditRole(){
       // wait.waitUntilVisibilityOfElement(100,driver,editRoleButton);
        page.clickOnElement(editRoleButton);
        return new EditRolePage(driver);
    }
    public EditRolePage clickOnEditRole1(){
        wait.waitUntilVisibilityOfElement(100,driver,editRoleButton1);
        page.clickOnElement(editRoleButton1);
        return new EditRolePage(driver);
    }
    public void searchRole(String userrole){
        page.enterText(searchButton,userrole);

    }
    public String getRoleOfUser(){
        wait.waitUntilVisibilityOfElement(100,driver,roleOfUser);
        String rolesearch=page.getElementText(roleOfUser);
        return rolesearch;
    }
    public String newRole(){
        wait.waitUntilVisibilityOfElement(100,driver,roleUpdate);
       String updatedrole= page.getElementText(roleUpdate);
       return updatedrole;
    }
    public RolesPage clickOnDeleteRoleButton(){
        wait.waitUntilVisibilityOfElement(100,driver,deleteRoleButton);
        page.clickOnElement(deleteRoleButton);
        return new RolesPage(driver);
    }
    public RolesPage clickOnOkButton(){
        page.clickOnElement(deleteOkButton);
        return new RolesPage(driver);
    }
    public String messageDisplay(){
        wait.waitUntilVisibilityOfElement(20,driver,roleMessage);
        String rmessage=page.getElementText(roleMessage);
        return rmessage;
    }

}
