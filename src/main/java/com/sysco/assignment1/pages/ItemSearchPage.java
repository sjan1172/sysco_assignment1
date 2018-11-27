package com.sysco.assignment1.pages;

import com.sysco.assignment1.models.CartItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Shiyam Jannan on 11/19/18.
 */
public class ItemSearchPage extends BasePage {

    private By searchedItemsContainer = By.xpath("//ul[contains(@class,'product-items')]");
    private By searchedItem = By.xpath("//ul[contains(@class,'product-items')]/li//div[contains(@class,'product-item-details')]");

    private By itemName = By.cssSelector("a.product-item-link");
    private By itemPrice = By.xpath("//span[contains(@id,'product-price')]");

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

    public CartItem selectRandomizedSearchItem(){
        Integer searchedItems = getSearchedItems().size();
        System.out.println("Found Items: "  + searchedItems);
        Integer selectRandomItemIndex = (int)(Math.random() * searchedItems + 1) -1;
        System.out.println("Selecting Item Index: "  + selectRandomItemIndex);
        WebElement element = getSearchedItems().get(selectRandomItemIndex);
        CartItem cartItem = getSelectedItemDetails(selectRandomItemIndex);
        element.click();
        return cartItem;
    }

    public CartItem getSelectedItemDetails(int selectRandomItemIndex){
        //Getting Item Name
        WebElement selectedItemNameElement = syscoLabUIOgm.findElements(itemName).get(selectRandomItemIndex);
        String itemName = syscoLabUIOgm.getText(selectedItemNameElement);

        //Getting Item Price
        WebElement selectedItemPriceElement = syscoLabUIOgm.findElements(itemPrice).get(selectRandomItemIndex);
        String itemPrice = syscoLabUIOgm.getText(selectedItemPriceElement);

        return new CartItem(itemName, itemPrice);
    }
}
