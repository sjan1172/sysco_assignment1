package com.sysco.assignment1.functions;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.sysco.assignment1.common.Constants;
import com.sysco.assignment1.pages.AUTLandingPage;
import com.sysco.assignment1.pages.AUTLoginPage;
import com.sysco.assignment1.utils.DriverSetUpUtil;

/**
 * Created by Rifad on 5/21/18.
 */
public class LoginFunc  {

    public static AUTLandingPage autLandingPage = new AUTLandingPage();
    public static AUTLoginPage autLoginPage = new AUTLoginPage();

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
}
