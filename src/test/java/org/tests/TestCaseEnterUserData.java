package org.tests;

import org.constants.TestConstants;
import org.dataProviders.TestUserDataProvider;
import org.model.AuthData;
import org.model.UserInfo;
import org.steps.AuthorizationFormSteps;
import org.steps.InformationFormStep;
import org.testng.annotations.Test;

public class TestCaseEnterUserData extends BaseTest {

    @Test(dataProvider = "getTestUserData", dataProviderClass = TestUserDataProvider.class)
    public void testEnterUserData(UserInfo userInfo) {
        AuthData authData = new AuthData();
        authData.setEmail(TestConstants.CORRECT_EMAIL);
        authData.setPassword(TestConstants.CORRECT_PASSWORD);

        AuthorizationFormSteps authorizationFormSteps = new AuthorizationFormSteps();
        authorizationFormSteps.login(authData);
        authorizationFormSteps.checkAuthentication();

        InformationFormStep informationFormStep = new InformationFormStep();
        informationFormStep.enterDataIntoForm(userInfo);
        informationFormStep.checkAddInfo();
    }
}
