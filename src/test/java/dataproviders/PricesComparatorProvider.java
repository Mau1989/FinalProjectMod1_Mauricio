package dataproviders;

import Pojo.Prices;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class PricesComparatorProvider {

    @DataProvider(name = "getPricesDataFromJson")
    private Object[][] getPricesDataFromJson() throws FileNotFoundException {

        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/Data/priceProduct.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<Prices> testData = new Gson().fromJson(dataSet, new TypeToken<List<Prices>>() {}.getType());
//        List<POJOUSER> testData = new Gson().fromJson(dataSet, new TypeToken<List<SearchData>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }
}
