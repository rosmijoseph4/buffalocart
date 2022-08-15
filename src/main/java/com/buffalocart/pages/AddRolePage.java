package com.buffalocart.pages;

import com.buffalocart.utility.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRolePage extends ObjectUtility {
    public WebDriver driver;

    public AddRolePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="name")
    WebElement roleAdd;

    @FindBy(xpath="//button[@class='btn btn-primary pull-right']")
    WebElement saveButton;
    public String getAddRolePageTitle(){
        String addRoletitle=page.getPageTitle(driver);
        return addRoletitle;
    }
    public void enterRole(String userrole){
        page.enterText(roleAdd,userrole);
    }
    public RolesPage clickOnSaveRole(){
        page.clickOnElement(saveButton);
        return new RolesPage(driver);
    }
}
