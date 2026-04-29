package tests;

import base.BaseTest;
import driver.DriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestNg.class})
public class ParallelTest extends BaseTest {

    @Test
    public void testGoogle() {

        openUrl("https://google.com");

        System.out.println("Thread: " + Thread.currentThread().getId() + " - Google");
    }

    @Test
    public void testGithub() {

        openUrl("https://github.com");

        System.out.println("Thread: " + Thread.currentThread().getId() + " - GitHub");
    }

    @Test
    public void testFailDemo() {

        openUrl("https://google.com");

        // ép fail
        assert false;
    }

    // 👇 Allure Step
    @Step("Open URL: {url}")
    public void openUrl(String url){
        DriverManager.getDriver().get(url);
    }
}