package dataproviders;

import Pojo.RegisterAccount;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class RegisterProvider {

    @DataProvider(name = "getRegisterDataFromJson")
    private Object[][] getSearchDataFromJson() throws FileNotFoundException {

        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/Data/register.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<RegisterAccount> testData = new Gson().fromJson(dataSet, new TypeToken<List<RegisterAccount>>() {}.getType());
//        List<POJOUSER> testData = new Gson().fromJson(dataSet, new TypeToken<List<SearchData>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }
}

