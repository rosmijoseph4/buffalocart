package com.buffalocart.pages;

import com.buffalocart.utility.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class AddUserPage extends ObjectUtility {
    public WebDriver driver;
    public AddUserPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="surname")
    WebElement prefix;

    @FindBy(id="first_name")
    WebElement firstName;

    @FindBy(id="last_name")
    WebElement lastName;

    @FindBy(xpath="//select[@id='role']//option")
    List<WebElement> roles;

    @FindBy(id="username")
    WebElement u_name1;

    @FindBy(id="password")
    WebElement pass_word1;

    @FindBy(id="confirm_password")
    WebElement cpass;

    @FindBy(id="submit_user_button")
    WebElement saveButton;

    @FindBy(id="email-error")
    WebElement errorMessage;

    @FindBy(id="email")
    WebElement email;


    public String getAddUserTitle(){
        String addusertitle=page.getPageTitle(driver);
        return addusertitle;
    }
    public void enterPrefix(String pre_fix){
        page.enterText(prefix,pre_fix);
    }
    public void enterFirstName(String fname){
        page.enterText(firstName,fname);
    }
    public void enterLastName(String lname){
        page.enterText(lastName,lname);
    }
    public void enterEmailId(String mail){
        page.enterText(email,mail);
    }
    public String selectRole(){
        System.out.println(roles.size());
        Random rand=new Random();
        int index=rand.nextInt(roles.size());
        wait.waitUntilVisibilityOfElement(250,driver,roles.get(index));
        String job=page.getElementText(roles.get(index));
        page.clickOnElement(roles.get(index));
        return job;
    }


    public void enterUsername(String u_name){

        page.enterText(u_name1,u_name);
    }
    public void enterPassword(String pass_word){

        page.enterText(pass_word1,pass_word);
    }
    public void enterConfirmPassword(String confirmPassword){
        page.enterText(cpass,confirmPassword);
    }
    public AddUserPage clickOnSave(){
        page.clickOnElement(saveButton);
        return new AddUserPage(driver);
    }
    public UsersPage clickOnSave1(){
        page.clickOnElement(saveButton);
        return new UsersPage(driver);
    }
    public String getErrorMessage(){
        String message=page.getElementText(errorMessage);
        return message;

    }
}
