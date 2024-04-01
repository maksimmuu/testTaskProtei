package org.tests;

import org.dataProviders.TestAuthDataProvider;
import org.model.AuthData;
import org.steps.AuthorizationFormSteps;
import org.testng.annotations.Test;

public class TestCaseAuthorization extends BaseTest {

    @Test(dataProvider = "getTestAuthData", dataProviderClass = TestAuthDataProvider.class)
    public void testAuthorization(AuthData authData) {
        AuthorizationFormSteps authorizationFormSteps = new AuthorizationFormSteps();
        authorizationFormSteps.login(authData);
        authorizationFormSteps.checkAuthentication();
    }
}

