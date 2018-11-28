package com.sysco.assignment1.pages;

import org.openqa.selenium.*;

public class SecureCheckoutPage extends BasePage {
    private By lblGreetUser = By.xpath("//li[@class=\"greet welcome\"]");
    private By btnContinue = By.xpath("//button[@title=\"Continue\"]");
    private By txtPostalCode = By.xpath("//div[@name='shippingAddress.postcode']//input");
    private By txtPhoneNumber = By.xpath("//div[@name='shippingAddress.telephone']//input");
    private By txtAddressLine1 = By.xpath("//div[@name='shippingAddress.street.0']//input");
    private By chkBoxCreditCardOption = By.xpath("//*[contains(text(),'Credit Card')]/ancestor::label");
    private By errMesasgeUnableToSaveShippingInformation = By.xpath("//div[@data-role=\"checkout-messages\"]//div[contains(text(),'Unable to save shipping information. Please check input data.')]");
    private By iconLoader = By.id("checkout-loader");

    private By lblRequiredField = By.xpath("//span[text()='This is a required field.']");

    private By txtCreditCardField = By.cssSelector("div#braintree_cc_number");
    private By txtCVVField = By.cssSelector("div#braintree_cc_cid");

    public String getLoggedInUserGeetingText() {
        try {
            syscoLabUIOgm.waitTillElementLoaded(lblGreetUser);
            return syscoLabUIOgm.getText(lblGreetUser);
        } catch (NoSuchElementException ex) {
            return null;
        } catch (TimeoutException ex) {
            return null;
        }
    }

    public void clickContinue() {
        syscoLabUIOgm.waitTillElementDisappear(iconLoader);
        syscoLabUIOgm.sleep(5);
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(btnContinue));
    }

    public void enterPostalCode(String text) {
        syscoLabUIOgm.sendKeys(txtPostalCode, text);
        syscoLabUIOgm.sleep(2);
        syscoLabUIOgm.sendKeysWithoutClear(txtPostalCode, Keys.chord(Keys.ARROW_DOWN));
        syscoLabUIOgm.sendKeysWithoutClear(txtPostalCode, Keys.chord(Keys.ENTER));
        syscoLabUIOgm.sleep(2);
    }

    public void enterAddressLine1(String text) {
        syscoLabUIOgm.sendKeys(txtAddressLine1, text);
    }

    public void enterPhoneNumber(String text) {
        syscoLabUIOgm.sendKeys(txtPhoneNumber, text);
    }

    public void selectCreditCardOption() {
        syscoLabUIOgm.waitTillElementLoaded(chkBoxCreditCardOption);
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(chkBoxCreditCardOption));
    }

    public boolean isCreditCardNumberFieldVisible() {
        return syscoLabUIOgm.isDisplayed(txtCreditCardField);
    }

    public boolean isCreditCardCVVFieldVisible() {
        return syscoLabUIOgm.isDisplayed(txtCVVField);
    }

    public boolean isRequiredFieldMessagesPresent() {
        if (syscoLabUIOgm.findElements(lblRequiredField).size() > 0) {
            return true;
        }
        return false;
    }

    public boolean isUnableToSaveShippingInformationVisible() {
        try {
            syscoLabUIOgm.waitTillElementLoaded(syscoLabUIOgm.findElement(errMesasgeUnableToSaveShippingInformation));
            return syscoLabUIOgm.isDisplayed(errMesasgeUnableToSaveShippingInformation);
        } catch (NoSuchElementException ex) {
            return false;
        } catch (TimeoutException ex) {
            return false;
        } catch (StaleElementReferenceException ex) {
            return false;
        } catch (WebDriverException ex) {
            return false;
        }
    }

}
