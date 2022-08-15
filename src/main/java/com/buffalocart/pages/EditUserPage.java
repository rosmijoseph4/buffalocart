package com.buffalocart.pages;

import com.buffalocart.utility.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUserPage extends ObjectUtility {
    public WebDriver driver;

    public EditUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="email")
    WebElement editMail;

    @FindBy(id="submit_user_button")
    WebElement updateButton;
    public String getEditUserPageTitle(){
        String edittitle=page.getPageTitle(driver);
        return edittitle;
    }
    public void clearMailId(){
        page.clearText(editMail);
    }
    public void enterNewMail(String newmail){
       page.enterText(editMail,newmail);

    }
    public UsersPage clickOnUpdate(){
        page.clickOnElement(updateButton);
        return new UsersPage(driver);
    }
}
