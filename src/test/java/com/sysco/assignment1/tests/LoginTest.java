package com.sysco.assignment1.tests;


import com.sysco.assignment1.data.LoginData;
import com.sysco.assignment1.functions.Login;
import com.sysco.assignment1.utils.ExcelUtil;
import com.sysco.assignment1.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    @Test
    public void testLogin() throws Exception {

        // Sample way to retrive data from excel
        LoginData loginData = ExcelUtil.getLoginData("$as238l");

        //UI Automation  sample
        Login.loadLoginPage();
        Login.quiteDriver();

    }
}