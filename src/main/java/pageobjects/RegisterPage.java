package pageobjects;

import Utils.DataUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPage extends BasePage {
    private By FirstNameFieldLocator = By.name("firstname");
    private By LastNameFieldLocator = By.name("lastname");
    private By telephoneFieldLocator = By.name("telephone");
    private By passwordFieldLocator = By.name("password");
    private By confirmPassword = By.name("confirm");
    private By agreeBox = By.name("agree");
    private By continueButton = By.xpath(".//*[contains(@class, 'btn btn-primary')]");



    public RegisterPage(WebDriver _driver){
        super(_driver);

    }
    public void enterFistName(String FirstName) {
        driver.findElement(FirstNameFieldLocator).sendKeys(FirstName);
    }
    public void enterLastName(String LastName) {
        driver.findElement(LastNameFieldLocator).sendKeys(LastName);
    }
    public void enterTelephone(String Telephone) {
        driver.findElement(telephoneFieldLocator).sendKeys(Telephone);
    }
    public void enterConfirmPassword(String password) { driver.findElement(confirmPassword).sendKeys(password);}
    public void enterPassword(String password){
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }
    public void clickAgree(){
        driver.findElement(agreeBox).click();
    }
    public void clickContinue(){
        driver.findElement(continueButton).click();
    }

    public void registerWithCredentials(String _firstname,String _lastname,String _telephone,
                                        //String _email,
                                        String _password, String _confirmPassword){
        this.enterFistName(_firstname);
        this.enterLastName(_lastname);
        this.enterTelephone(_telephone);
        this.enterPassword(_password);
        this.enterConfirmPassword(_confirmPassword);


    }
    public void clickButtons(){
        this.clickAgree();
        this.clickContinue();
    }

    public void generateEmail(){
        String email = DataUtils.getRandomEmail();
        driver.findElement(By.name("email")).sendKeys(email);
    }
}
