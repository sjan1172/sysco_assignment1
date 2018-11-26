package com.sysco.assignment1.functions;

import com.sysco.assignment1.pages.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sysco.assignment1.common.Constants;
import com.sysco.assignment1.utils.DriverSetUpUtil;

/**
 * Created by Rifad on 5/21/18.
 */
public class UserFunc  {

    public static AUTLandingPage autLandingPage = new AUTLandingPage();
    public static AUTLoginPage autLoginPage = new AUTLoginPage();
    public static MenuOptions menuOptions = new MenuOptions();
    public static ItemSearchPage itemSearchPage = new ItemSearchPage();
    public static ItemDetailPage itemDetailPage = new ItemDetailPage();

    public static void loadPage() {

        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;

            autLandingPage.loadPage(capabilities, Constants.APP_URL);
        } else {
            autLandingPage.loadPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }


    public static void quiteDriver() {
        autLandingPage.quitDriver();
    }

    public static void navigateToLoginPage(){
        autLandingPage.clickLoginMenu();
    }

    public static void navigateToRegisterPage(){
        autLandingPage.clickRegisterMenu();
    }

    public static void navigateToContactPage(){
        autLandingPage.clickContactMenu();
    }

    public static void navigateToTrackOrdersPage(){
        autLandingPage.clickTrackOrdersMenu();
    }

    public static void getLogin(String email, String password){
        autLandingPage.clickLoginMenu();
        autLoginPage.enterEmail(email);
        autLoginPage.enterPassword(password);
        autLoginPage.clickLogin();
    }

    /**
     * Created By: Shiyam Jannan
     * Inputs: expectedText as String
     * Output: true/false
     * Purpose: This verification method return true if given text is equals to currently loggedIn displayed text.
     * Else returns false.
     */
    public static Boolean verifyWhetherCorrectUserLoggedIn(String expectedText){
        if(expectedText.equals(autLandingPage.getLoggedInUserGeetingText())){
            return true;
        }
        else{
            return false;
        }
    }

    public static void addRandomItemFromMensCategoryToCart(String categoryName){

        menuOptions.gotoMensMenu();
        menuOptions.gotoCategory(categoryName);
        itemSearchPage.waitForSearchedItemsLoaded();
        itemSearchPage.selectRandomizedSearchItem();
        itemDetailPage.selectAvailableSize(); //Selecting first
        itemDetailPage.clickAddToCart();
        itemDetailPage.pause(5000);


    }

    public static void refreshPage() {
        autLandingPage.pageRefresh();
    }
}
