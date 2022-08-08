package com.buffalocart.pages;

import com.buffalocart.utility.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends ObjectUtility {
    public WebDriver driver;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="email")
    WebElement email;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement resetLinkbutton;

    @FindBy(xpath = "//span[@class='help-block']//strong")
    WebElement resetPageErrorMessage;

    public void enterEmailId(String mail){
        page.enterText(email,mail);
    }
    public void clickOnResetLinkButton(){
        page.clickOnElement(resetLinkbutton);
    }
    public String getResetErrorMessage(){
        String errormesage=page.getElementText(resetPageErrorMessage);
        return errormesage;
    }

}
