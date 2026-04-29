package base;

import driver.DriverFactory;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import utils.ConfigReader;

public class BaseTest {

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("") String browser) throws Exception {

        String finalBrowser = ConfigReader.getBrowser(browser);

        WebDriver driver = DriverFactory.createDriver(finalBrowser);
        DriverManager.setDriver(driver);
    }

    @AfterMethod
    public void teardown(){
        DriverManager.quit();
    }
}