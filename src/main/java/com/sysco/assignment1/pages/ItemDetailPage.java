package com.sysco.assignment1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Shiyam Jannan on 11/19/18.
 */
public class ItemDetailPage extends BasePage {

    private By productOptionsWrapper = By.id("product-options-wrapper");
    private By availableSize = By.xpath("//div[contains(@class,'active')]/div[not(contains(@class,'outofstock'))]");
    private By btnAddToCart = By.id("product-addtocart-button");

    public void waitForItemPageLoaded(){
//        syscoLabUIOgm.waitTillElementLoaded(productOptionsWrapper, 30);
    }

    public List<WebElement> getAvailableSizes(){
//        waitForItemPageLoaded();
        return syscoLabUIOgm.findElements(availableSize);
    }

    public void selectAvailableSize(WebElement element){
        syscoLabUIOgm.click(element);
    }

    public void clickAddToCart(){
        syscoLabUIOgm.click(btnAddToCart);
    }
}
