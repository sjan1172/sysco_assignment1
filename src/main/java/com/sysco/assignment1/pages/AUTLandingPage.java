package com.sysco.assignment1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;

/**
 * Created by Rifad on 5/21/18.
 */
public class AUTLandingPage extends BasePage{
    private By imgLogo = By.xpath("//img[contains(@src, 'logo.svg')]");
    private By lnkLogin = By.xpath("//a[text()='Login']");
    private By lnkRegister = By.linkText("Register");
    private By lnkContact = By.linkText("Contact");
    private By lnkTrackOrders = By.linkText("Track order");

    public static void loadPage(Capabilities capabilities, String url) {
        syscoLabUIOgm = new SyscoLabWUI(capabilities);
        syscoLabUIOgm.navigateTo(url);
        syscoLabUIOgm.driver.manage().window().maximize();
    }
    
    public void quitDriver() {
        if (syscoLabUIOgm != null) {
            syscoLabUIOgm.quit();
        }
    }

    public Boolean isLogoVisible(){
        return syscoLabUIOgm.isDisplayed(imgLogo);
    }

    public void clickLogo(){
        syscoLabUIOgm.click(imgLogo);
    }

    public void clickLoginMenu(){
        syscoLabUIOgm.click(lnkLogin);
    }

    public void clickRegisterMenu(){
        syscoLabUIOgm.click(lnkRegister);
    }

    public void clickContactMenu(){
        syscoLabUIOgm.click(lnkContact);
    }

    public void clickTrackOrdersMenu(){
        syscoLabUIOgm.click(lnkTrackOrders);
    }


}
