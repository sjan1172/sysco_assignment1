package com.sysco.assignment1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Shiyam Jannan on 11/19/18.
 */
public class ItemDetailPage extends BasePage {

    private By productOptionsWrapper = By.className("product-info-main");
    private By availableSize = By.xpath("//div[contains(@class,'active')]/div[not(contains(@class,'outofstock'))][contains(@class,'swatch-option')]");
    private By btnAddToCart = By.id("product-addtocart-button");

    public ItemDetailPage(){

    }
    public void waitForItemPageLoaded(){
        System.out.println("Page Load - Started");
        syscoLabUIOgm.waitTillElementLoaded(productOptionsWrapper, 15);
        System.out.println("Page Load - End");
    }

    public List<WebElement> getAvailableSizes(){
        waitForItemPageLoaded();
        syscoLabUIOgm.sleep(5);
        return syscoLabUIOgm.findElements(availableSize);
    }

    public void selectAvailableSize(){
        System.out.println("Found Available Sizes: "  + getAvailableSizes().size());
        Integer selectRandomItemNumber = (int)(Math.random() * (getAvailableSizes().size()-1) + 1);
        syscoLabUIOgm.click(getAvailableSizes().get(selectRandomItemNumber));
    }

    public void clickAddToCart(){
        syscoLabUIOgm.waitTillElementLoaded(btnAddToCart, 15);
        syscoLabUIOgm.click(btnAddToCart);
    }
}
