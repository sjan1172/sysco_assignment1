package com.sysco.assignment1.pages;

import com.sysco.assignment1.common.ElementAttributes;
import com.sysco.assignment1.common.ElementStatus;
import org.openqa.selenium.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shiyam Jannan on 11/19/18.
 */
public class SecureCheckoutPage extends BasePage {
    private By lblGreetUser = By.xpath("//li[@class=\"greet welcome\"]");
    private By btnContinue = By.xpath("//button[@title=\"Continue\"]");
    private By txtPostalCode = By.xpath("//div[@name='shippingAddress.postcode']//input");
    private By txtPhoneNumber = By.xpath("//div[@name='shippingAddress.telephone']//input");
    private By txtAddressLine1 = By.xpath("//div[@name='shippingAddress.street.0']//input");
    private By chkBoxCreditCardOption = By.xpath("//*[contains(text(),'Credit Card')]/ancestor::label");

    private By txtCreditCardField = By.cssSelector("div#braintree_cc_number");
    private By txtCVVField = By.cssSelector("div#braintree_cc_cid");

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

    public void clickContinue(){
        syscoLabUIOgm.click(btnContinue);
    }

    public void enterPostalCode(String text) {
        syscoLabUIOgm.sendKeys(txtPostalCode, text);
        syscoLabUIOgm.sleep(2);
        syscoLabUIOgm.sendKeysWithoutClear(txtPostalCode, Keys.chord(Keys.ARROW_DOWN));
        syscoLabUIOgm.sendKeysWithoutClear(txtPostalCode, Keys.chord(Keys.ENTER));
        syscoLabUIOgm.sleep(2);
    }

    public void enterAddressLine1(String text){
        syscoLabUIOgm.sendKeys(txtAddressLine1, text);
    }

    public void enterPhoneNumber(String text){
        syscoLabUIOgm.sendKeys(txtPhoneNumber, text);
    }

    public void selectCreditCardOption(){
        syscoLabUIOgm.waitTillElementLoaded(chkBoxCreditCardOption);
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(chkBoxCreditCardOption));
    }

    public boolean isCreditCardNumberFieldVisible(){
        return syscoLabUIOgm.isDisplayed(txtCreditCardField);
    }

    public boolean isCreditCardCVVFieldVisible(){
        return syscoLabUIOgm.isDisplayed(txtCVVField);
    }


}
