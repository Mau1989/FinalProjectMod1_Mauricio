package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage extends BasePage {
    private By searchBarLocator = By.name("search");
    private By ButtonSearch = By.xpath("//span[@class='input-group-btn']");
    private By MacbookItem = By.xpath("//img[@alt='MacBook']");
    private By ButtonCart = By.id("button-cart");
    private By alertMessage = By.xpath("//div[contains(@class,'alert-success')]");
    private By shoppingCart = By.xpath("//i[@class='fa fa-shopping-cart']");
    private By checkout = By.xpath("//a[contains(text(), 'Checkout')]");
    private By stockMessage = By.xpath("//div[contains(@class,'alert-danger')]");



        public AddToCartPage(WebDriver _driver){
            super(_driver);
        }
        public void itemSearch(String itemName) {
            driver.findElement(searchBarLocator).sendKeys(itemName);
        }

        public void hitSearch(){
            driver.findElement(ButtonSearch).click();
        }
        public void hitImage(){
            driver.findElement(MacbookItem).click();
        }
        public void addToCart(){
            driver.findElement(ButtonCart).click();
        }
        public boolean findSuccessMessage(String expectedMessage) {
            boolean result = driver.findElement(alertMessage).getText().equals(expectedMessage);
            return  result;
        }
        public void goToShoppingCart(){
            driver.findElement(shoppingCart).click();
        }
        public void hitCheckOutButton(){
            driver.findElement(checkout).click();
        }
        public boolean findStockMessage(String _stockMessage) {
        boolean result = driver.findElement(stockMessage).getText().equals(_stockMessage);
        return  result;
        }

}