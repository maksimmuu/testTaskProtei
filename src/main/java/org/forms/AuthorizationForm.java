package org.forms;

import org.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.utils.DriverUtils;

public class AuthorizationForm extends BaseForm {

    private final WebElement emailTextBox = DriverManager.getDriver().findElement(By.xpath("//input[contains(@id,'loginEmail')]"));
    private final WebElement passwordTextBox = DriverManager.getDriver().findElement(By.xpath("//input[contains(@id,'loginPassword')]"));
    private final WebElement authButton = DriverManager.getDriver().findElement(By.xpath("//button[contains(@id,'authButton')]"));
    private final By emailFormatErrorLabel = By.xpath("//div[contains(@id,'emailFormatError')]");
    private final By invalidEmailPasswordLabel = By.xpath("//div[contains(@id,'invalidEmailPassword')]");

    public AuthorizationForm() {
        super(DriverManager.getDriver().findElement(By.xpath("//button[contains(@id,'auth')]")), "Authorization form");
    }

    public void enterEmail(String email) {
        emailTextBox.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void clickAuthButton() {
        authButton.click();
    }

    public boolean emailFormatErrorIsPresent() {
        return DriverUtils.isElementPresent(emailFormatErrorLabel);
    }

    public boolean invalidEmailPasswordIsPresent() {
        return DriverUtils.isElementPresent(invalidEmailPasswordLabel);
    }
}