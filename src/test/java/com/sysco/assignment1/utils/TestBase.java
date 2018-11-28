package com.sysco.assignment1.utils;

import com.syscolab.qe.core.reporting.SyscoLabListener;
import com.syscolab.qe.core.reporting.SyscoLabQCenter;
import com.syscolab.qe.core.reporting.SyscoLabReporting;
import com.sysco.assignment1.common.Constants;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.*;
import static com.sysco.assignment1.functions.UserFunc.autLandingPage;

@Listeners(SyscoLabListener.class)
public class TestBase {
    private SyscoLabListener testListeners;
    private SyscoLabQCenter syscoLabQCenter;

    @BeforeClass
    public void init() {
        testListeners = new SyscoLabListener();
        syscoLabQCenter = new SyscoLabQCenter();
    }

    @BeforeMethod
    public void beforeTest() {
        System.out.println("Test Running " + this.getClass().toString());
        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;

            autLandingPage.loadPage(capabilities, Constants.APP_URL);
        } else {
            autLandingPage.loadPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        System.out.println("Test Finished " + this.getClass().toString());
        autLandingPage.quitDriver();
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp(ITestContext iTestContext) {
        try {
            syscoLabQCenter.setProjectName(Constants.TEST_PROJECT);
            syscoLabQCenter.setEnvironment(Constants.TEST_ENV);

            syscoLabQCenter.setRelease(Constants.TEST_RELEASE);
            syscoLabQCenter.setModule(iTestContext.getAttribute("feature").toString());
            syscoLabQCenter.setFeature(iTestContext.getAttribute("feature").toString());
            syscoLabQCenter.setClassName(iTestContext.getClass().getName());

            if (Constants.UPDATE_DASHBOARD)
                SyscoLabReporting.generateJsonFile(SyscoLabListener.getResults(), syscoLabQCenter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
