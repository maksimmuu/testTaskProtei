package org.steps;

import org.forms.AuthorizationForm;
import org.model.AuthData;
import org.testng.asserts.SoftAssert;

public class AuthorizationFormSteps {

    private final AuthorizationForm authorizationForm;

    public AuthorizationFormSteps() {
        authorizationForm = new AuthorizationForm();
    }

    public void login(AuthData authData) {
        authorizationForm.enterEmail(authData.getEmail());
        authorizationForm.enterPassword(authData.getPassword());
        authorizationForm.clickAuthButton();
    }

    public void checkAuthentication() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(authorizationForm.emailFormatErrorIsPresent(), "Ошибка авторизации: Неверный формат email");
        softAssert.assertFalse(authorizationForm.invalidEmailPasswordIsPresent(), "Ошибка авторизации: Неверный email/password");
        softAssert.assertAll();
    }
}