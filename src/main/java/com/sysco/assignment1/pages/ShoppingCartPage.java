package com.sysco.assignment1.pages;

import com.sysco.assignment1.common.ElementAttributes;
import com.sysco.assignment1.common.ElementStatus;
import org.openqa.selenium.By;

/**
 * Created by Shiyam Jannan on 11/19/18.
 */
public class ShoppingCartPage extends BasePage {
    private By panelShoppingCart = By.id("minicartOffcanvas");
    private By btnClose = By.xpath("//div[@class='close']");
    private By cartItem = By.xpath("//div[@data-role='product-item']");
    private By btnCloseCartItem = By.xpath("//a[@title='Remove item']");
    private By lblNoItemsInCart = By.xpath("//div[@class='minicart-items']//*[contains(@class,'subtitle')]");

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
}
