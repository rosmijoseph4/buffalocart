package com.buffalocart.pages;

import com.buffalocart.utility.ObjectUtility;
import com.buffalocart.utility.TableUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class UsersPage extends ObjectUtility {
    public WebDriver driver;

    public UsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//small[text()='Manage users']")
    WebElement userTitle;

    @FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
    WebElement addUser;

    @FindBy(xpath = "//table[@id=\"users_table\"]/tbody/tr[2]/td[5]/a[1]")
    WebElement editUser;

    @FindBy(xpath="//input[@class='form-control input-sm']")
    WebElement searchBox;

    @FindBy(xpath="//table[@id='users_table']/tbody/tr/td//a[@class='btn btn-xs btn-primary']")
    WebElement edit;

    @FindBy(xpath="//table[@id=\"users_table\"]/tbody/tr/td[4]")
    WebElement table;


    @FindBy(xpath = "//table[@id='users_table']/tbody/tr")
    List<WebElement> rawElements;
    @FindBy(xpath = "//table[@id='users_table']/tbody/tr/td")
    List<WebElement> cellElements;

    @FindBy(xpath = "//table[@id='users_table']/tbody/tr/td[text()='No matching records found']")
    WebElement message;

    @FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-default btn-flat']")
    WebElement signOutButton;

    //@FindBy(xpath = "//span[text()='Aju Mathew']")
    @FindBy(xpath = "//li[@class='dropdown user user-menu']//a//span")
    WebElement loggedinName;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
    WebElement endTour;

    @FindBy(xpath="//table[@id='users_table']/tbody/tr/td[4]")
    WebElement emailId;

    @FindBy(xpath="//table[@id='users_table']/tbody/tr/td[5]//button[@class='btn btn-xs btn-danger delete_user_button']")
    WebElement deleteUserButton;

    @FindBy(xpath = "//div[@class='swal-button-container']//button[@class='swal-button swal-button--confirm swal-button--danger']")
    WebElement okButton;
    @FindBy(xpath = "//li[@class='dropdown user user-menu']//a[@class='dropdown-toggle']")
    WebElement userName1;



    public List<ArrayList<String>> getTableData(){
        List<ArrayList<String>> tableData = tableUtility.getGridData(rawElements, cellElements);
        return tableData;

    }

    public void enterSearchValue(String mail) {
        wait.waitUntilVisibilityOfElement(500,driver,searchBox);
        page.enterText(searchBox, mail);
        wait.hardWait(10000);
    }

    public void enterSearchNewValue(String newmail) {
        wait.waitUntilVisibilityOfElement(500,driver,searchBox);
        page.enterText(searchBox, newmail);
        wait.hardWait(10000);
    }
    public String newMailId(){
     String id=page.getElementText(emailId);
     return id;
    }


    public String getEmailIdfromTable(){
             String tableid=page.getElementText(table);
             return tableid;
         }

        public AddUserPage clickOnAddUser(){
            page.clickOnElement(addUser);
            return new AddUserPage(driver);
        }
        public EditUserPage clickOnEditUser(){
            wait.waitUntilVisibilityOfElement(100,driver,editUser);
            page.clickOnElement(editUser);
            return new EditUserPage(driver);
        }
        public EditUserPage clickOnEdit(){
        page.clickOnElement(edit);
        return new EditUserPage(driver);
        }

    public String getUserPageTitle(){
        String userpagetitle=page.getPageTitle(driver);
        return userpagetitle;
    }
    public void enterInvalidEmail(String mail){
        page.enterText(searchBox,mail);
    }
    public String messageDisplay(){
        wait.waitUntilVisibilityOfElement(20,driver,message);
        String displaymessage=page.getElementText(message);
        return displaymessage;
    }

    public LoginPage clickOnSignOutButton(){
        wait.hardWait(10000);
        page.clickUsingJavaScript(driver,userName1);
        wait.waitUntilVisibilityOfElement(500,driver,signOutButton);
        page.clickOnElement(signOutButton);
        return new LoginPage(driver);
    }
    public UsersPage clickOnUser(){
        //wait.waitUntilVisibilityOfElement(20,driver,signoutButton);
        page.clickOnElement(loggedinName);
        //wait.waitUntilVisibilityOfElement(20,driver,signoutButton);
        return new UsersPage(driver);
    }
    public UsersPage enterButtonEndTour(){
        page.clickOnElement(endTour);
        return new UsersPage(driver);
    }
   public UsersPage clickOnDeleteUserButton(){
        page.clickOnElement(deleteUserButton);
        return new UsersPage(driver);
   }
   public UsersPage clickOnOkButton(){
        page.clickOnElement(okButton);
       return new UsersPage(driver);
   }
}
