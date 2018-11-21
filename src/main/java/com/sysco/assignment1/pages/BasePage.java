package com.sysco.assignment1.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;

/**
 * Created by Shiyam on 11/19/18.
 */
public class BasePage {
    protected static SyscoLabUI syscoLabUIOgm;
    private By btnOKModalWindow = By.xpath("//button/span[text()='OK']/..");

    public void clickOKModelWindow(){
        syscoLabUIOgm.waitTillElementLoaded(btnOKModalWindow);
        syscoLabUIOgm.click(btnOKModalWindow);
    }


}
