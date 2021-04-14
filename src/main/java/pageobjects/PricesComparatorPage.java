package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PricesComparatorPage extends BasePage {
    private By DollarSelector = By.name("USD");
    private By USDPrice = By.xpath("//h2[contains(text(),'$')]");
    private By Currency = By.xpath("//i[contains(@class,'fa-caret-down')] ");
    private By EuroSelector = By.name("EUR");
    private By EuroPrice = By.xpath("//h2[contains(text(),'€')]");
    private By PoundSelector = By.name("GBP");
    private By PoundPrice = By.xpath("//h2[contains(text(),'£')]");

    public PricesComparatorPage(WebDriver _driver) {
        super(_driver);
    }

    public void EnterURLById(String ProductID) {
        driver.get("https://demo.opencart.com/index.php?route=product/product&product_id="+ ProductID);
    }

    public void USDItemPrice (String expectedPriceDollar){
        String initialPrice = driver.findElement(USDPrice).getText();
        String realPrice = initialPrice.substring(1);
        org.testng.Assert.assertEquals(realPrice, expectedPriceDollar,
                String.format("Was expecting %s, but got %s", expectedPriceDollar, realPrice));
    }
    public void EURItemPrice (String expectedPriceEuro){
        String initialPrice = driver.findElement(EuroPrice).getText();
        String realPrice = initialPrice.substring(0,initialPrice.length()-1);
        org.testng.Assert.assertEquals(realPrice, expectedPriceEuro,
                String.format("Was expecting %s, but got %s", expectedPriceEuro, realPrice));
    }
    public void PNDItemPrice (String expectedPricePound){
        String initialPrice = driver.findElement(PoundPrice).getText();
        String realPrice = initialPrice.substring(1);
        org.testng.Assert.assertEquals(realPrice, expectedPricePound,
                String.format("Was expecting %s, but got %s", expectedPricePound, realPrice));
    }
    public void CurrencySelector (){
        driver.findElement(Currency).click();
    }
    public void EuroSelector (){
        driver.findElement(EuroSelector).click();
    }
    public void DollarSelector (){
        driver.findElement(DollarSelector).click();
    }
    public void PoundSelector (){
        driver.findElement(PoundSelector).click();
    }
    public boolean EURCompare (String expectedPriceEuro){
        String initialPrice = driver.findElement(EuroPrice).getText();
        String realPrice = initialPrice.substring(0,initialPrice.length()-1);
        boolean result = realPrice.equals(expectedPriceEuro);
        return result;
    }
    public boolean PNDCompare (String expectedPricePound){
        String initialPrice = driver.findElement(PoundPrice).getText();
        String realPrice = initialPrice.substring(1);
        boolean result = realPrice.equals(expectedPricePound);
        return result;
    }
}