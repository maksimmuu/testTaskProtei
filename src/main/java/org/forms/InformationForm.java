package org.forms;

import org.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.utils.DriverUtils;

import java.util.List;

public class InformationForm extends BaseForm {

    private final WebElement emailTextBox = DriverManager.getDriver().findElement(By.xpath("//input[contains(@id,'dataEmail')]"));
    private final WebElement nameTextBox = DriverManager.getDriver().findElement(By.xpath("//input[contains(@id,'dataName')]"));
    private final WebElement addButton = DriverManager.getDriver().findElement(By.xpath("//button[contains(@id,'dataSend')]"));
    private final List<WebElement> gendersList = DriverManager.getDriver().findElements(By.xpath("//select[contains(@id,'dataGender')]/option"));
    private final List<WebElement> checkBoxVariantList = DriverManager.getDriver().findElements(By.xpath("//div[./input[contains(@type,'checkbox')]]"));
    private final List<WebElement> radioVariantList = DriverManager.getDriver().findElements(By.xpath("//div[./input[contains(@type,'radio')]]"));
    private final By childInputLocator = By.xpath("./input");
    private final By confirmAddInfoButton = By.xpath("//button[contains(text(),'Ok')]");
    private final By recordInTheInfoTable = By.xpath("//tbody//tr");
    private final By emailFormatErrorLabel = By.xpath("//div[contains(@id,'emailFormatError')]");
    private final By blankNameErrorLabel = By.xpath("//div[contains(@id,'blankNameError')]");

    public InformationForm() {
        super(DriverManager.getDriver().findElement(By.xpath("//div[contains(@id,'inputsPage')]")), "Information form");
    }

    public void enterEmail(String email) {
        emailTextBox.sendKeys(email);
    }

    public void enterName(String name) {
        nameTextBox.sendKeys(name);
    }

    public void clickAddButton() {
        addButton.click();
    }

    public List<WebElement> getRecordsInTheTable() {
        return DriverManager.getDriver().findElements(recordInTheInfoTable);
    }

    public void clickConfirmAddInfo() {
        if (DriverUtils.isElementPresent(confirmAddInfoButton)) {
            DriverManager.getDriver().findElement(confirmAddInfoButton).click();
        }
    }

    public void selectGender(String gender) {
        for (WebElement genderElement : gendersList) {
            if (genderElement.getText().contains(gender)) {
                genderElement.click();
            }
        }
    }

    public void selectCheckBoxVariant(String variant) {
        for (WebElement variantElement : checkBoxVariantList) {
            if (variantElement.getText().contains(variant)) {
                variantElement.findElement(childInputLocator).click();
            }
        }
    }

    public void selectRadioVariant(String variant) {
        for (WebElement variantElement : radioVariantList) {
            if (variantElement.getText().contains(variant)) {
                variantElement.findElement(childInputLocator).click();
            }
        }
    }

    public boolean emailFormatErrorIsPresent() {
        return DriverUtils.isElementPresent(emailFormatErrorLabel);
    }

    public boolean blankNameErrorIsPresent() {
        return DriverUtils.isElementPresent(blankNameErrorLabel);
    }
}