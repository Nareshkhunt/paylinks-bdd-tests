package com.paylinks;

import com.paylinks.driver.DriverManager;
import com.paylinks.utilities.CommonUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends DriverManager {
    DriverManager driverManager = new DriverManager();
    public static String testDataPropertyFile = "testData.properties";

    @Before
    public void setUp() throws IllegalAccessException {
        CommonUtils.loadTestDataProp(testDataPropertyFile);
        driverManager.runOnLocalBrowser(CommonUtils.BROWSER_INSTANCE);
        driverManager.goToUrl(CommonUtils.ENV_URL);
        driverManager.maxBrowser();
        driverManager.applyImlicitWait();

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            driverManager.takeScreenshot(scenario);
        }
        driverManager.closeBrowser();
    }
}
