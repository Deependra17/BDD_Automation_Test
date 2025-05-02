package util;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverSetUp.getDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
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
