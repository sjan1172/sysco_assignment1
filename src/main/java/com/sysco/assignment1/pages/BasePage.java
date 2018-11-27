package com.sysco.assignment1.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;

/**
 * Created by Shiyam on 11/19/18.
 */
public class BasePage {
    public static SyscoLabUI syscoLabUIOgm;
    private By btnOKModalWindow = By.xpath("//button/span[text()='OK']/..");

    public BasePage(){

    }
    public void clickOKModelWindow(){
        syscoLabUIOgm.waitTillElementLoaded(btnOKModalWindow);
        syscoLabUIOgm.click(btnOKModalWindow);
    }

    public void pageRefresh(){
        syscoLabUIOgm.driver.navigate().refresh();
    }

    public void pause(Integer delay){
        syscoLabUIOgm.sleepInMiliSeconds(delay);
    }

}
