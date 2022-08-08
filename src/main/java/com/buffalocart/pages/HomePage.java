package com.buffalocart.pages;

import com.buffalocart.utility.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class HomePage extends ObjectUtility{
    public WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()='Aju Mathew']")
            WebElement loggedinName;

    @FindBy(xpath="//a[@class='logo']//span")
    WebElement homeTitle;

    @FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']//strong")
    WebElement date;

    @FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-default btn-flat']")
    WebElement signoutButton;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
    WebElement endTour;
    @FindBy(xpath =" //span[text()='User Management']" )
    WebElement userManagement;

    //@FindBy(xpath ="\" //span[text()='Users'" )
    @FindBy(xpath = "//*[normalize-space(text())='Users']")
    WebElement users;

    @FindBy(xpath = "//*[normalize-space(text())='Roles']")
    WebElement roles;

    @FindBy(xpath = "//*[normalize-space(text())='Sales Commission Agents']")
    WebElement sales;



    public Boolean getUser(){
        page.getElementsDisplayed(users);
        //page.getElementIsEnabled(users);
        return true;
    }
    public Boolean getRoles(){
        page.getElementsDisplayed(roles);
        //page.getElementIsEnabled(roles);
        return true;
    }
    public Boolean getSales(){
        page.getElementsDisplayed(sales);
       // page.getElementIsEnabled(sales);
        return true;
    }

    public HomePage clickOnUserManagement(){
        page.clickOnElement(userManagement);
        wait.waitUntilVisibilityOfElement(20,driver,userManagement);
        return new HomePage(driver);

    }
    public UsersPage clickOnUsers(){
        page.clickOnElement(users);
        wait.waitUntilVisibilityOfElement(20,driver,users);
        return new UsersPage(driver);

    }


    public HomePage enterButtonEndTour(){
        page.clickOnElement(endTour);
        return new HomePage(driver);
    }
    public String getUserName(){
        String text= page.getElementText(loggedinName);
        return text;
    }
    public String getHomePageTitle(){
        String homepagetitle=page.getPageTitle(driver);
        return homepagetitle;
    }
    public String dateDisplay(){
        String homepagedate=page.getElementText(date);
        return homepagedate;

    }

    public HomePage clickOnUser(){
        page.clickOnElement(loggedinName);
        return new HomePage(driver);
    }
    public LoginPage clickOnSignoutButton(){
        page.clickOnElement(signoutButton);
        return new LoginPage(driver);
    }

}
