package org.steps;

import org.forms.InformationForm;
import org.model.UserInfo;
import org.testng.asserts.SoftAssert;

public class InformationFormStep {

    private final InformationForm informationForm;

    public InformationFormStep() {
        informationForm = new InformationForm();
    }

    public void enterDataIntoForm(UserInfo userInfo) {
        informationForm.enterEmail(userInfo.getEmail());
        informationForm.enterName(userInfo.getName());
        informationForm.selectGender(userInfo.getGender());
        informationForm.selectCheckBoxVariant(userInfo.getCheckBoxVariant());
        informationForm.selectRadioVariant(userInfo.getRadioVariant());
        informationForm.clickAddButton();
        informationForm.clickConfirmAddInfo();
    }

    public void checkAddInfo() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(informationForm.emailFormatErrorIsPresent(), "Неверный формат Email");
        softAssert.assertFalse(informationForm.blankNameErrorIsPresent(), "Поле 'Имя' не может быть пустым");
        softAssert.assertTrue(!informationForm.getRecordsInTheTable().isEmpty(), "Информационная запись не добавлена в таблицу");
        softAssert.assertAll();
    }
}