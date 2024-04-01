package org.utils;

import org.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class DriverUtils {

    public static boolean isElementPresent(By elementLocator) {
        try {
            return !DriverManager.getDriver().findElements(elementLocator).isEmpty();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}