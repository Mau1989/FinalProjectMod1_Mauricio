package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage extends BasePage {

    private By myAccountLinkLocator = By.xpath("//span[@class='caret']");
    private By loginLocator = By.linkText("Login");
    private By registerLocator = By.linkText("Register");
    private By logoutLocator = By.xpath("//a[text()='Logout']");
    private By searchField = By.name("search");

    public HeaderPage(WebDriver _driver){
        super(_driver);
    }
    public void clickOnMyAccount(){
        driver.findElement(myAccountLinkLocator).click();

    }
    public void clickOnMyLogin(){
        driver.findElement(loginLocator).click();
    }
    public void goToLogin(){
        this.clickOnMyAccount();
        this.clickOnMyLogin();
    }
    public void clickOnMyRegister(){
        driver.findElement(registerLocator).click();
    }
    public void goToRegister(){
        this.clickOnMyAccount();
        this.clickOnMyRegister();
    }
    public boolean isLogoutEnabled(){
        return driver.findElement(logoutLocator).isEnabled();
    }
    public void search(String searchCriteria){
        driver.findElement(searchField).sendKeys(searchCriteria, Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.urlContains(String.format("search=%s",searchCriteria)));
    }

}