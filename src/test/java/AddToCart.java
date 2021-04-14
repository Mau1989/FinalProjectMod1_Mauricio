import Pojo.AddToCartItem;
import dataproviders.AddToCartItemProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AddToCartPage;

public class AddToCart extends BaseClass {
    @Test(description = "Test Add item to cart", dataProvider = "getAddToCartDataFromJson", dataProviderClass = AddToCartItemProvider.class)
    public void AddToCart(AddToCartItem TestAddToCartItem) {
        String expectedMessage = "Success: You have added MacBook to your shopping cart!\n" +
                "×";
        String outofStockMessage = "Products marked with *** are not available in the desired quantity or not in stock!\n" +
                "×";
// page created

            AddToCartPage addToCartPage = new AddToCartPage(driver);
            // search bar
            addToCartPage.itemSearch(TestAddToCartItem.getItem());
            //search action
            addToCartPage.hitSearch();
            //find element by image
            addToCartPage.hitImage();
            //add to cart
            addToCartPage.addToCart();
            // success message validation
            Assert.assertTrue(addToCartPage.findSuccessMessage(expectedMessage));
            // go to shopping cart
            addToCartPage.goToShoppingCart();
            // click on checkout
            addToCartPage.hitCheckOutButton();
            // stock message validation
            Assert.assertTrue(addToCartPage.findStockMessage(outofStockMessage));
        /*
        WebElement macbook_search = driver.findElement(By.name("search"));
        macbook_search.sendKeys("Macbook");

        WebElement button = driver.findElement(By.xpath("//span[@class='input-group-btn']"));
        button.click();

        WebElement macBookItem = driver.findElement(By.xpath("//img[@alt='MacBook']"));
        macBookItem.click();

        WebElement find = driver.findElement(By.id("button-cart"));
        find.click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]"));
        Assert.assertEquals(expectedMessage, alertMessage.getText());

        //Go to shopping cart
        driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();

        //Click on checkout
        driver.findElement(By.xpath("//a[contains(text(), 'Checkout')]")).click();
        //Verify error message
        WebElement stockMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]"));
        Assert.assertEquals(outofStockMessage, stockMessage.getText());

        //div[contains(@class,'alert-danger')]

         */
    }
}
