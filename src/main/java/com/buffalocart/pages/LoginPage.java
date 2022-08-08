package com.buffalocart.pages;

import com.buffalocart.utility.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class LoginPage extends ObjectUtility {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="username")
    WebElement userName;

    @FindBy(id="password")
    WebElement password;

    @FindBy(xpath = "//div[@class='form-group']//div[@class='col-md-8 col-md-offset-4']//button[@class='btn btn-primary']")
    WebElement loginButton;

    @FindBy(xpath = "//strong[text()='These credentials do not match our records.']")
    WebElement errorMessage;

    @FindBy(xpath = "//input[@name='remember']")
    WebElement checkBox;

    @FindBy(xpath = "//a[@class='btn btn-link']")
    WebElement link;



    public String getLoginPageTitle(){
        String title= page.getPageTitle(driver);
        return title;
    }
    public void enterUsername(String uname){
        page.enterText(userName,uname);
    }
    public void enterPassword(String pass){
        page.enterText(password,pass);
    }

    public String getErrorMessage() {
       String message= page.getElementText(errorMessage);
        return message;

    }
    public Boolean selectCheckBox(){
        page.clickOnElement(checkBox);
        if(checkBox.isSelected()){
            return true;
        }
        else{
            return false;
        }
    }
    public HomePage clickOnLoginButton(){
        page.clickOnElement(loginButton);
       // wait.waitUntilVisibilityOfElement(20,driver,loginButton);
        return new HomePage(driver);
    }
    public LoginPage clickOnInvalidLoginButton(){
        page.clickOnElement(loginButton);
        return new LoginPage(driver);
    }
    public ResetPasswordPage clickOnForgotPassword(){
          page.clickOnElement(link);
        return new ResetPasswordPage(driver);
    }
}
