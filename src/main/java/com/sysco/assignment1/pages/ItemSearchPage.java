package com.sysco.assignment1.pages;

import com.sysco.assignment1.common.ElementAttributes;
import com.sysco.assignment1.common.ElementStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Shiyam Jannan on 11/19/18.
 */
public class ItemSearchPage extends BasePage {

    private By searchedItemsContainer = By.xpath("//ul[contains(@class,'product-items')]");
    private By searchedItem = By.xpath("//ul[contains(@class,'product-items')]/li//div[contains(@class,'product-item-details')]");

    public ItemSearchPage(){

    }
    public void waitForSearchedItemsLoaded(){
        syscoLabUIOgm.waitTillElementLoaded(searchedItemsContainer);
    }

    public List<WebElement> getSearchedItems(){
        return syscoLabUIOgm.findElements(searchedItem);
    }

    public void selectFirstSearchItem(){
        syscoLabUIOgm.click(searchedItem);
    }

    public void selectRandomizedSearchItem(){
        Integer searchedItems = getSearchedItems().size();
        System.out.println("Found Items: "  + searchedItems);
        Integer selectRandomItemIndex = (int)(Math.random() * searchedItems + 1) -1;
        System.out.println("Selecting Item Index: "  + selectRandomItemIndex);
        WebElement element = getSearchedItems().get(selectRandomItemIndex);
        element.click();
    }
}
