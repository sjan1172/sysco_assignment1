package com.sysco.assignment1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MenuOptions extends BasePage {

    private By menuOptionMen = By.xpath("//a[@title='Mens']/..");
    private By menuOptionWomens = By.xpath("//a[@title='Womens']");
    private By menuOptionKids = By.xpath("//a[@title='Kids']");
    private By menuOptionSocks = By.xpath("//a[@title='Socks']");
    private By menuOptionMyFIT = By.xpath("//a[@title='MyFIT']");
    public MenuOptions() {

    }

    public void gotoCategory(String categoryName) {
        String searchPattern = "//div[contains(@class,'open')]//a[@title='%s']";
        WebElement element = syscoLabUIOgm.findElement(By.xpath(String.format(searchPattern, categoryName)));
        syscoLabUIOgm.click(element);
    }

    public void gotoMensMenu() {
        syscoLabUIOgm.sleep(5);
        syscoLabUIOgm.click(menuOptionMen);
        syscoLabUIOgm.sleep(3);
    }

    public void gotoKidsMenu() {
        syscoLabUIOgm.click(menuOptionKids);
    }

    public void gotoWomensMenu() {
        syscoLabUIOgm.click(menuOptionWomens);
    }

    public void gotoSocksMenu() {
        syscoLabUIOgm.click(menuOptionSocks);
    }

    public void gotoMyFITSMenu() {
        syscoLabUIOgm.click(menuOptionMyFIT);
    }
}
