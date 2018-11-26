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
        syscoLabUIOgm.sleep(5);
        syscoLabUIOgm.moveToAndClick(searchedItem);
    }

    public void selectRandomizedSearchItem(){

        syscoLabUIOgm.sleep(10);
        System.out.println("Found Items: "  + getSearchedItems().size());
        Integer selectRandomItemNumber = (int)(Math.random() * getSearchedItems().size() + 1);
        WebElement element = getSearchedItems().get(selectRandomItemNumber);
        syscoLabUIOgm.click(element);
    }
}
