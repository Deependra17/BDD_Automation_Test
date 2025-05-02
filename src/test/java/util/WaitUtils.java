package util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = 10;

    /** ========== IMPLICIT WAIT ========== */
    public static void setImplicitWait(WebDriver driver, int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    /** ========== EXPLICIT WAITS ========== */

    public static WebElement waitForVisibility(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickability(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForInvisibility(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static boolean waitForTextToBePresent(WebDriver driver, By locator, String text) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public static Alert waitForAlert(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.alertIsPresent());
    }

    /** ========== FLUENT WAIT ========== */

    public static WebElement fluentWait(WebDriver driver, final By locator, int timeoutInSeconds, int pollingInMillis) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(pollingInMillis))
                .ignoring(NoSuchElementException.class);

        return wait.until(driver1 -> driver1.findElement(locator));
    }

    // Overloaded fluent wait using Function (for custom conditions)
    public static <T> T fluentWait(WebDriver driver, Function<WebDriver, T> condition,
                                   int timeoutInSeconds, int pollingInMillis) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(pollingInMillis))
                .ignoring(NoSuchElementException.class);

        return wait.until(condition);
    }
}
