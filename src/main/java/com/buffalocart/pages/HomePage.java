package com.buffalocart.pages;

import com.buffalocart.utility.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends ObjectUtility {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//li[@class='dropdown user user-menu']//a//span")
    WebElement loggedinName;


    @FindBy(xpath = "//a[@class='logo']//span")
    WebElement homeTitle;

    @FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']//strong")
    WebElement date;

    @FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-default btn-flat']")
    WebElement signoutButton;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
    WebElement endTour;

    @FindBy(xpath = " //span[text()='User Management']")
    WebElement userManagement;

    @FindBy(xpath = "//ul[@class='treeview-menu menu-open']//span[@class='title']")
    List<WebElement> userManagementOptions;

    public List<String> getUserManagementOptions() {
        List<String> values = new ArrayList<String>();
        for (int i = 0; i < userManagementOptions.size(); i++) {
            wait.waitUntilVisibilityOfElement(100, driver, userManagementOptions.get(i));
            values.add(page.getElementText(userManagementOptions.get(i)));
        }
        return values;
    }

    public UsersPage clickOnUserMenu() {
        for (int i = 0; i < userManagementOptions.size(); i++) {
            wait.waitUntilVisibilityOfElement(100, driver, userManagementOptions.get(i));
            String value = page.getElementText(userManagementOptions.get(i));
            if (value.equalsIgnoreCase("Users")) {
                page.clickOnElement(userManagementOptions.get(i));
            }
        }
        return new UsersPage(driver);
    }

    public RolesPage clickOnRoles() {
        for (int i = 0; i < userManagementOptions.size(); i++) {
            wait.waitUntilVisibilityOfElement(100, driver, userManagementOptions.get(i));
            String value = page.getElementText(userManagementOptions.get(i));
            if (value.equalsIgnoreCase("Roles")) {
                page.clickOnElement(userManagementOptions.get(i));
            }
        }
        return new RolesPage(driver);
    }

    public SalesPage clickOnSalesCommission() {
        for (int i = 0; i < userManagementOptions.size(); i++) {
            wait.waitUntilVisibilityOfElement(100, driver, userManagementOptions.get(i));
            String value = page.getElementText(userManagementOptions.get(i));
            if (value.equalsIgnoreCase("Sales Commission Agents")) {
                page.clickOnElement(userManagementOptions.get(i));
            }
        }
        return new SalesPage(driver);
    }


    public HomePage clickOnUserManagement() {
        wait.waitUntilVisibilityOfElement(20, driver, userManagement);
        page.clickOnElement(userManagement);
        wait.hardWait(10000);
        return new HomePage(driver);

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
        //wait.waitUntilVisibilityOfElement(20,driver,signoutButton);
        page.clickOnElement(signoutButton);
        return new LoginPage(driver);
    }

}
