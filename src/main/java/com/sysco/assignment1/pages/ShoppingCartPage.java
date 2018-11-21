package com.sysco.assignment1.pages;

import com.sysco.assignment1.common.ElementAttributes;
import com.sysco.assignment1.common.ElementStatus;
import org.openqa.selenium.By;

/**
 * Created by Shiyam Jannan on 11/19/18.
 */
public class ShoppingCartPage extends BasePage {
    //Elements under "LOGIN TO MYFIT REWARDS" section
    private By panelShoppingCart = By.id("minicartOffcanvas");
    private By btnClose = By.xpath("//div[@class='close']");
    private By cartItem = By.xpath("//div[@data-role='product-item']");
    private By btnCloseCartItem = By.xpath("//a[@title='Remove item']");
    private By lblNoItemsInCart = By.xpath("//div[@class='minicart-items']//*[contains(@class,'subtitle')]");

    public Boolean isPanelHidden() {
        return syscoLabUIOgm.getAttribute(panelShoppingCart, ElementAttributes.ARIA_HIDDEN).equals(ElementStatus.TRUE);
    }

    public void clickOnCloseIcon(){
        syscoLabUIOgm.waitTillElementLoaded(btnClose);
        syscoLabUIOgm.click(btnClose);
    }

    public Integer getCartItemCount(){
        syscoLabUIOgm.waitTillElementLoaded(cartItem);
        return syscoLabUIOgm.findElements(cartItem).size();
    }

    public void clickCloseItem(){
        syscoLabUIOgm.click(btnCloseCartItem);
    }

    public String getNoItemsInCartText(){
        syscoLabUIOgm.waitTillElementLoaded(lblNoItemsInCart);
        return syscoLabUIOgm.getText(lblNoItemsInCart);
    }
}
