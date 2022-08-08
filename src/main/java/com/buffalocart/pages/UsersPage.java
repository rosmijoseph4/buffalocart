package com.buffalocart.pages;

import com.buffalocart.utility.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class UsersPage extends ObjectUtility {
    public WebDriver driver;

    public UsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//small[text()='Manage users']")
    WebElement userTitle;

    public String getUserPageTitle(){
        String userpagetitle=page.getPageTitle(driver);
        return userpagetitle;
    }
    }
