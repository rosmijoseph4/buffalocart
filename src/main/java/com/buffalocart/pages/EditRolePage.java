package com.buffalocart.pages;

import com.buffalocart.utility.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditRolePage extends ObjectUtility {
    public WebDriver driver;

    public EditRolePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="name")
    WebElement roleCheckBox;

    @FindBy(xpath = "//button[@class='btn btn-primary pull-right']")
    WebElement updateRole;
    public String getEditRolePageTitle(){
        String editroletitle=page.getPageTitle(driver);
        return editroletitle;
    }
    public void clearRole(){
        page.clearText(roleCheckBox);
    }
    public void addNewRole(String newrole){
        page.enterText(roleCheckBox,newrole);

    }
    public RolesPage clickOnUpdateRole(){
        page.clickOnElement(updateRole);
        return new RolesPage(driver);

    }
}
