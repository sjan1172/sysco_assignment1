package com.sysco.assignment1.pages;

import com.sysco.assignment1.common.ElementAttributes;
import com.sysco.assignment1.common.ElementStatus;
import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Shiyam Jannan on 11/19/18.
 */
public class ShoppingCartPage extends BasePage {
    private By panelShoppingCart = By.id("minicartOffcanvas");
    private By btnClose = By.xpath("//div[@class='close']");
    private By cartItem = By.cssSelector("div.minicart-product");
    private By btnCloseCartItem = By.xpath("//a[@title='Remove item']");
    private By lblNoItemsInCart = By.xpath("//div[@class='minicart-items']//*[contains(@class,'subtitle')]");
    private By btnProceedToCheckout = By.xpath("//button[@data-js-minicart='checkout']");

    public ShoppingCartPage(){

    }
    public Boolean isPanelHidden() {
        return syscoLabUIOgm.getAttribute(panelShoppingCart, ElementAttributes.ARIA_HIDDEN).equals(ElementStatus.TRUE);
    }

    public void clickOnCloseIcon(){
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(btnClose));
    }

    public Integer getCartItemCount(){
        syscoLabUIOgm.waitTillElementLoaded(cartItem);
        return syscoLabUIOgm.findElements(cartItem).size();
    }

    public void clickCloseItem(){
        syscoLabUIOgm.sleep(5);
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(btnCloseCartItem));
        syscoLabUIOgm.sleep(3);
    }

    public String getNoItemsInCartText(){
        syscoLabUIOgm.waitTillElementLoaded(lblNoItemsInCart);
        return syscoLabUIOgm.getText(lblNoItemsInCart);
    }

    public int getNumberOfCartItems(){
        return getCartItems().size();
    }

    private List<WebElement> getCartItems(){
        return syscoLabUIOgm.findElements(cartItem);
    }

    public String getCartItemNameByIndex(int index){
        return syscoLabUIOgm.findElements(By.cssSelector("div.minicart-product-details a")).get(index).getText();
    }

    public String getCartItemPriceByIndex(int index){
        return syscoLabUIOgm.findElements(By.cssSelector("div.minicart-product-details span.price")).get(index).getText();
    }

    public void clickProceedToCheckout(){
        syscoLabUIOgm.click(btnProceedToCheckout);
    }
}
