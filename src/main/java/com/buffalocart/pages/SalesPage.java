package com.buffalocart.pages;

import com.buffalocart.utility.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class SalesPage extends ObjectUtility {
    public WebDriver driver;

    public SalesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//button[@class='btn btn-primary btn-modal pull-right']")
    WebElement addAgentButton;

    @FindBy(id="first_name")
    WebElement agentName;

    @FindBy(id="cmmsn_percent")
    WebElement percentage;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement saveButton;

    @FindBy(xpath = "//table[@id='sales_commission_agent_table']/tbody/tr/td[6]//button[2]")
    WebElement deleteButton;

    @FindBy(xpath = "//button[@class='swal-button swal-button--confirm swal-button--danger']")
    WebElement buttonOk;

    @FindBy(xpath = "//label//input[@class='form-control input-sm']")
    WebElement searchAgent;

    @FindBy(xpath = "//table[@id='sales_commission_agent_table']/tbody/tr/td[6]//button[1]")
    WebElement editButton;

    @FindBy(xpath = "//table[@id='sales_commission_agent_table']/tbody/tr/td[@class='dataTables_empty']")
    WebElement errorMessageSales;

    @FindBy(id="contact_no")
    WebElement cnum;

    @FindBy(id="email")
    WebElement salesMail;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement salesSave;

    @FindBy(xpath = "//table[@id='sales_commission_agent_table']/tbody/tr/td[@class='sorting_1']")
    WebElement searchAgent1;

    @FindBy(xpath = "//table[@id='sales_commission_agent_table']/tbody/tr")
    List<WebElement> rawElements;

    @FindBy(xpath = "//table[@id='sales_commission_agent_table']/tbody/tr/td")
    List<WebElement> cellElements;
    public String getSalesPageTitle(){
        String salestitle=page.getPageTitle(driver);
        return salestitle;
    }
    public List<ArrayList<String>> getTableData(){
        wait.hardWait(5000);
        List<ArrayList<String>> tableData = tableUtility.getGridData(rawElements, cellElements);
        return tableData;
    }
    public List<String> getTableData1() {
        //System.out.println(userManagementOptions.size());
        List<String> values = new ArrayList<String>();
        for (int i = 0; i < cellElements.size(); i++) {
            wait.waitUntilVisibilityOfElement(100, driver, cellElements.get(i));
            values.add(page.getElementText(cellElements.get(i)));
        }
        return values;
    }
    public SalesPage clickOnAddAgent(){
        wait.waitUntilVisibilityOfElement(20,driver,addAgentButton);
        page.clickOnElement(addAgentButton);
        return new SalesPage(driver);
    }
    public void enterFirstName(String fname){
       //wait.waitUntilVisibilityOfElement(20,driver,agentName);
        wait.hardWait(10000);
       page.enterText(agentName,fname);
    }
    public void enterSalesPercentage(String num){
        page.enterText(percentage,num);
    }
    public SalesPage clickOnSaveAgent(){
        wait.waitUntilVisibilityOfElement(20,driver,saveButton);
        page.clickOnElement(saveButton);
        return new SalesPage(driver);
    }
    public SalesPage clickOnDeleteButton(){
        wait.waitUntilVisibilityOfElement(20,driver,deleteButton);
        page.clickOnElement(deleteButton);
        return new SalesPage(driver);
    }
    public SalesPage clickOnOkButton(){
        wait.waitUntilVisibilityOfElement(20,driver,buttonOk);
        page.clickOnElement(buttonOk);
        return new SalesPage(driver);
    }
    public void searchAgent(String fname){
        //wait.waitUntilVisibilityOfElement(20,driver,searchAgent);
        wait.hardWait(10000);
        page.enterText(searchAgent,fname);
    }
    public void searchAgent(){
        //wait.waitUntilVisibilityOfElement(20,driver,searchAgent);
        //wait.hardWait(10000);
        page.clickOnElement(searchAgent1);
    }
    public String getMessage(){
        wait.hardWait(10000);
       // wait.waitUntilVisibilityOfElement(20,driver,errorMessageSales);
        String salesmessage=page.getElementText(errorMessageSales);
        return salesmessage;
    }
    public SalesPage clickOnEditButton(){
        wait.hardWait(10000);
       // wait.waitUntilVisibilityOfElement(1000,driver,editButton);
        page.clickOnElement(editButton);
        return new SalesPage(driver);
    }
    public void enterMailId(String mail){
        wait.hardWait(10000);
        page.enterText(salesMail,mail);
    }
    public void enterNumber(String cnumber){
        wait.hardWait(10000);
        page.enterText(cnum,cnumber);
    }
    public SalesPage clickOnSaveSales(){
        page.clickOnElement(salesSave);
        return new SalesPage(driver);
    }

}
