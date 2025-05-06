package util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;
    String url = "https://chat.hamropatro.com";
    @Before
    public void setUp() {
        driver = DriverSetUp.getDriver();
        driver.manage().window().maximize();
        driver.get(url);
        WaitUtils.setImplicitWait(driver, 10);
    }

    @After
    public void tearDown() {
        DriverSetUp.quitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
