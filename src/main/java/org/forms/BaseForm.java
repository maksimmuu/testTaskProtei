package org.forms;

import org.openqa.selenium.WebElement;

public class BaseForm {

    protected final WebElement uniqueElement;
    protected final String namePage;

    public BaseForm(WebElement uniqueElement, String nameForm) {
        this.uniqueElement = uniqueElement;
        this.namePage = nameForm;
    }
}