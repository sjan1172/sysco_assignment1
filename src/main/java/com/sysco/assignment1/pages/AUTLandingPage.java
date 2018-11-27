package com.sysco.assignment1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import java.util.concurrent.TimeUnit;

/**
 * Created by Rifad on 5/21/18.
 */
public class AUTLandingPage extends BasePage{
    private By imgLogo = By.xpath("//img[contains(@src, 'logo.svg')]");
    private By lnkLogin = By.xpath("//a[text()='Login']");
    private By lnkRegister = By.linkText("Register");
    private By lnkContact = By.linkText("Contact");
    private By lnkTrackOrders = By.linkText("Track order");

    private By lblGreetUser = By.xpath("//li[@class=\"greet welcome\"]");

    private By lblCartItemsCount = By.xpath("//div[@class='minicart-wrapper']//span[@class='value']");
    private By iconCart = By.className("minicart-wrapper");

    public AUTLandingPage(){
    }

    public static void loadPage(Capabilities capabilities, String url) {
        syscoLabUIOgm = new SyscoLabWUI(capabilities);
        syscoLabUIOgm.navigateTo(url);
        syscoLabUIOgm.driver.manage().window().fullscreen();
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
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(imgLogo));
    }

    public void clickLoginMenu(){
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(lnkLogin));
        syscoLabUIOgm.sleep(3);
    }

    public void clickRegisterMenu(){
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(lnkRegister));
    }

    public void clickContactMenu(){
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(lnkContact));
    }

    public void clickTrackOrdersMenu(){
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(lnkTrackOrders));
    }

    public String getLoggedInUserGeetingText(){
        try{
            syscoLabUIOgm.waitTillElementLoaded(lblGreetUser);
            return syscoLabUIOgm.getText(lblGreetUser);
        }catch(NoSuchElementException ex){
            return null;
        } catch (TimeoutException ex){
            return null;
        }
    }

    public Boolean isCartItemsCountDisplayed() {
        if(syscoLabUIOgm.isDisplayed(lblCartItemsCount)){
            return true;
        }
        return false;
    }

    public void clickCart(){
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(iconCart));
        syscoLabUIOgm.sleep(3);
    }
}
