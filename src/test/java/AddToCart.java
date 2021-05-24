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

    }
}
