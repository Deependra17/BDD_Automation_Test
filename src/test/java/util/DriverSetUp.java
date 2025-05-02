package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetUp {
        private static WebDriver driver;

        public static WebDriver getDriver() {
            if (driver == null) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(); // Initialize ChromeDriver
            }
            return driver;
        }

        public static void quitDriver() {
            if (driver != null) {
                driver.quit(); // Quit the driver and set it to null
                driver = null;
            }
        }
}
