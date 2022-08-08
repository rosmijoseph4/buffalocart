package com.buffalocart.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

    public class PageUtility {
    public String getPageTitle(WebDriver driver){
        String title= driver.getTitle();
        return title;
    }
    public void clickOnElement(WebElement element){
        element.click();

    }
    public void enterText(WebElement element,String text){
        element.sendKeys(text);

    }
    public String getAttributeValue(WebElement element,String attribute){
        String value=element.getAttribute(attribute);
        return value;

    }
    public String getElementText(WebElement element){
        String text=element.getText();
        return text;
    }
    public void closeAllTabs(WebDriver driver){
        driver.quit();
    }
    public void closeTab(WebDriver driver){
        driver.close();
    }
    public void clearText(WebElement element) {
        element.clear();
    }
    public void getSelectByValue(WebElement element, String value) {
        Select s = new Select(element);
        s.selectByValue(value);
    }
    public void getSelectByIndex(WebElement element, int index) {
        Select s = new Select(element);
        s.selectByIndex(index);
    }
    public void getSelectByVisibleText(WebElement element, String value) {
        Select s = new Select(element);
        s.selectByVisibleText(value);
    }
    public WebElement getFirstElementSelected(WebElement element) {
        Select s = new Select(element);
        WebElement element1 = s.getFirstSelectedOption();
        return element1;
    }
    public List<WebElement> getAllSelectedElements(WebElement element) {
        Select s = new Select(element);
        List<WebElement> elements = s.getAllSelectedOptions();
        return elements;
    }

    public List<WebElement> getAllElements(WebElement element) {
        Select s = new Select(element);
        List<WebElement> elements = s.getOptions();
        return elements;
    }

    public void mouseHoverElement(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }

    public void dragAndDropElement(WebDriver driver, WebElement source, WebElement destination) {
        Actions act = new Actions(driver);
        act.dragAndDrop(source, destination).perform();
    }

    public void rightClickElement(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.contextClick(element).perform();
    }

    public void doubleClickElement(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.doubleClick(element).perform();
    }

    public void clickByUsingJavascript(WebDriver driver, String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    //    public void enterValueUsingJavascript(WebDriver driver,String script){
//        JavascriptExecutor js=(JavascriptExecutor) driver;
//        js.executeScript(script);
    //
    public String getWindowId(WebDriver driver) {
        String value = driver.getWindowHandle();
        return value;
    }

    public Set<String> getAllWindowIds(WebDriver driver) {
        Set<String> value = driver.getWindowHandles();
        return value;
    }

    public void switchToWindowDemo(WebDriver driver, String window) {
        driver.switchTo().window(window);
    }

    public void simpleAlertAcceptDemo(WebDriver driver) {
        Alert al = driver.switchTo().alert();
        al.accept();
    }

    public void simpleAlertDismissDemo(WebDriver driver) {
        Alert al = driver.switchTo().alert();
        al.dismiss();
    }
    public Boolean getElementIsEnabled(WebElement element){
        return true;
    }
    public Boolean getElementsDisplayed(WebElement element){
        return true;
    }


}
