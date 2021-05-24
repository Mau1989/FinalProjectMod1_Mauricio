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

    }


}
