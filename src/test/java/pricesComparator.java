import Pojo.Prices;
import dataproviders.PricesComparatorProvider;
import org.testng.annotations.Test;
import pageobjects.PricesComparatorPage;

public class pricesComparator extends BaseClass {
    @Test(description = "Test Prices comparator by ID", dataProvider = "getPricesDataFromJson", dataProviderClass = PricesComparatorProvider.class)

    public void pricesComparatorTest(Prices prices){
        PricesComparatorPage pricesComparatorPage = new PricesComparatorPage(driver);
        pricesComparatorPage.EnterURLById(prices.getID());
        //Get and compare USD price
        pricesComparatorPage.CurrencySelector();
        pricesComparatorPage.DollarSelector();
        pricesComparatorPage.USDItemPrice(prices.getUSD());
        //Get and compare EUR price
        pricesComparatorPage.CurrencySelector();
        pricesComparatorPage.EuroSelector();
        pricesComparatorPage.EURItemPrice(prices.getEUR());
        //Get and compare PND prices
        pricesComparatorPage.CurrencySelector();
        pricesComparatorPage.PoundSelector();
        pricesComparatorPage.PNDItemPrice(prices.getPND());

    }
}
