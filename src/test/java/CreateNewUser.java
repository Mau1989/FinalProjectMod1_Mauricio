import Pojo.RegisterAccount;
import dataproviders.RegisterProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HeaderPage;
import pageobjects.RegisterPage;

public class CreateNewUser extends BaseClass {
    @Test(description = "Test Register Success", dataProvider = "getRegisterDataFromJson", dataProviderClass = RegisterProvider.class)
    public void CreateUser(RegisterAccount registerAccount){
        HeaderPage headerPage = new HeaderPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        // go to register page
        headerPage.goToRegister();
        // enter user information
        registerPage.registerWithCredentials(registerAccount.getFirstName(),registerAccount.getLastName(),
                registerAccount.getTelephone(),registerAccount.getPassword(),registerAccount.getConfirmPassword());
        registerPage.generateEmail();
        registerPage.clickButtons();
        //verification
        headerPage.clickOnMyAccount();
        if (registerAccount.isShouldRegister())
            Assert.assertTrue(headerPage.isLogoutEnabled());
        //else
            //Assert.assertTrue(loginPage.isAlertPresentWithText(expectedMessage));
    }
        /*
        //variables
        String FirstName = "Mauricio";
        String LastName = "Salomon";
        String email = "masalagui2@gmail.com";
        String Telephone = "85016199";
        String password = "12345";



        // go to register page
        driver.findElement(By.xpath("//span[@class='caret']")).click();
        driver.findElement(By.linkText("Register")).click();

        //Create new user
        driver.findElement(By.name("firstname")).sendKeys(FirstName);
        driver.findElement(By.name("lastname")).sendKeys(LastName);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("telephone")).sendKeys(Telephone);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirm")).sendKeys(password);
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath(".//*[contains(@class, 'btn btn-primary')]")).click();
        //Verify user is login
        driver.findElement(By.xpath("//span[@class='caret']")).click();
        WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Logout']"));
        Assert.assertTrue(logoutButton.isDisplayed()); // This is a test, something that I expect to happen.

    }

         */

}
