package com.sysco.assignment1.pages;

import org.openqa.selenium.By;

import com.syscolab.qe.core.ui.SyscoLabUI;

/**
 * Created by Shiyam on 11/19/18.
 */
public class AUTLoginPage extends BasePage {
    //Elements under "LOGIN TO MYFIT REWARDS" section
    private By txtEmail = By.xpath("//input[@id='email']");
    private By txtPassword = By.xpath("//input[@id='pass']");
    private By lnkForgotPassword = By.partialLinkText("Forgot Your Password?");
    private By btnLogin = By.id("send2");

    public void enterEmail(String email) {
        syscoLabUIOgm.sendKeys(txtEmail, email);
    }

    public void enterPassword(String password) {
        syscoLabUIOgm.sendKeys(txtPassword, password);
    }

    public void clickFogotPassword(){
        syscoLabUIOgm.click(lnkForgotPassword);
    }

    public void clickLogin(){
        syscoLabUIOgm.click(btnLogin);
    }
}