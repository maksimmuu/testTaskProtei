package org.dataProviders;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.constants.ConfigConstants;
import org.model.UserInfo;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class TestUserDataProvider {

    @DataProvider
    public Object[][] getTestUserData() {
        JsonElement jsonData = null;
        try {
            jsonData = JsonParser.parseReader(new FileReader(ConfigConstants.PATH_TO_TEST_USERDATA));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        JsonElement dataSet = jsonData.getAsJsonObject().get("userInfo");
        List<UserInfo> testData = new Gson().fromJson(dataSet, new TypeToken<List<UserInfo>>() {
        }.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }
}