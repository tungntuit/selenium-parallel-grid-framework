package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ConfigReader;

import java.net.URL;

public class DriverFactory {

    public static WebDriver createDriver(String browser) throws Exception {

        String gridUrl = ConfigReader.get("grid.url");

        System.out.println("Launching browser: " + browser +
                " | Thread: " + Thread.currentThread().getId());

        if(browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage");

            return new RemoteWebDriver(new URL(gridUrl), options);
        }

        else if(browser.equalsIgnoreCase("firefox")) {

            FirefoxOptions options = new FirefoxOptions();

            return new RemoteWebDriver(new URL(gridUrl), options);
        }

        throw new RuntimeException("Browser not supported: " + browser);
    }
}