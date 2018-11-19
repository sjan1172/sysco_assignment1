package com.sysco.assignment1.tests;

import com.sysco.assignment1.functions.LoginFunc;
import com.sysco.assignment1.utils.TestBase;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavigateToMAccountTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Checkout - Navigate to My Account");
    }

    @Test
    public void testLogin() throws Exception {
        //Navigate to My Account
        LoginFunc.loadPage();
        LoginFunc.getLogin("williamjacob802@gmail.com", "0okmNHY6");
        LoginFunc.quiteDriver();
    }
}