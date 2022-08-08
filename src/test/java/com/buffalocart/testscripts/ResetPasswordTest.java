package com.buffalocart.testscripts;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.ResetPasswordPage;
import com.buffalocart.utility.ExcelUtility;
import com.buffalocart.utility.FakerUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResetPasswordTest extends Base {
    LoginPage loginPage;
    ResetPasswordPage resetPasswordPage;
    FakerUtility fakerUtility;
    ExcelUtility excelUtility;
    @Test(priority = 5,description = "TC_005 Verify error meesage displyed on  Reset Password page with invalid email id",groups = {"smoke","regression"})
    public void Verify_error_meesage_displyed_on_Reset_Password_page_with_invalid_email_id(){
        loginPage=new LoginPage(driver);
        resetPasswordPage=loginPage.clickOnForgotPassword();
        fakerUtility=new FakerUtility();
        excelUtility=new ExcelUtility();
        String mail=fakerUtility.emailId();
        resetPasswordPage.enterEmailId(mail);
        resetPasswordPage.clickOnResetLinkButton();
        String actualerrormessage=resetPasswordPage.getResetErrorMessage();
        System.out.println(actualerrormessage);
        String expectederrormessage= excelUtility.readSingleData(1,0,"resetpasswordpage");
        System.out.println(expectederrormessage);
        Assert.assertEquals(actualerrormessage,expectederrormessage,"Error:Message not displayed");
    }
}
