import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    protected WebDriver driver;

    @BeforeTest
    public void setupTest(){
        System.out.println("* Before Test Setup");
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setupMethod(@Optional("chrome") String browser) throws MalformedURLException {
        SetInitialConfig(browser);
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void teardownMethod(){
        System.out.println("* After Method Test");
        TakeScreenshot(driver);
        driver.close();
        try {
            driver.quit();
        }
        catch (WebDriverException ex){
            System.out.println("Session already closed!");
        }

    }

    private void SetInitialConfig(String browser) throws MalformedURLException {
        if (browser.equals("firefox"))
            driver = new FirefoxDriver();
        else
            driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://demo.opencart.com/index.php");

    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] TakeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }



}