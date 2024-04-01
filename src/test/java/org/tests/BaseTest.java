package org.tests;

import org.constants.ConfigConstants;
import org.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(ConfigConstants.PATH_TO_HTML_FILE);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
