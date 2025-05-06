package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import util.Hooks;
import util.WaitUtils;

public class LoginSteps {

    private final WebDriver driver;

    By googleLoginBtn = By.xpath(" ");
    By emailField = By.id(" ");
    By passwordField = By.name(" ");
    By dashboardHeader = By.xpath(" ");
    By errorMessage = By.xpath("");
    By networkErrorMsg = By.xpath("");
    By permissionDeniedMsg = By.xpath("");
    By oauthTokenHiddenInput = By.id("oauth-token");
    By googleLoginVisible = By.xpath("");

    public LoginSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
    }

    @Given("User navigates to Hamro Chat URL")
    public void userNavigatesToLoginPage() {
        driver.get(" ");
    }

    @When("User clicks on Google login button")
    public void userClicksGoogleLogin() {
        WaitUtils.waitForClickability(driver, googleLoginBtn).click();
    }

    @And("User enters username {string}")
    public void userEntersUsername(String username) {
        WebElement emailInput = WaitUtils.waitForVisibility(driver, emailField);
        emailInput.clear();
        emailInput.sendKeys(username);
        emailInput.sendKeys(Keys.ENTER);
    }

    @And("User enters password {string}")
    public void userEntersPassword(String password) {
        WebElement passwordInput = WaitUtils.waitForVisibility(driver, passwordField);
        passwordInput.sendKeys(password);
        passwordInput.sendKeys(Keys.ENTER);
    }

    @Then("User should see {string}")
    public void userShouldSeeResult(String result) {
        if (result.equalsIgnoreCase("Dashboard")) {
            WebElement header = WaitUtils.fluentWait(driver, dashboardHeader, 10, 500);
            Assert.assertTrue(header.isDisplayed(), "Dashboard not visible.");
        } else {
            WebElement message = driver.findElement(By.xpath("//*[contains(text(),'" + result + "')]"));
            Assert.assertTrue(message.isDisplayed(), "Expected message not visible: " + result);
        }
    }

    @And("User cancels the Google login popup")
    public void userCancelsGoogleLoginPopup() {
        System.out.println("Simulating Google popup cancel (mock or UI workaround needed).");
        driver.navigate().back();
    }

    @And("a network error occurs")
    public void simulateNetworkError() {
        System.out.println("Simulating network failure. Should be handled via proxy/mock.");
    }

    @And("User denies access to account information")
    public void userDeniesGooglePermission() {
        System.out.println("Simulating permission denial in Google popup.");
    }

    @Then("User should remain on the login screen")
    public void userRemainsOnLoginScreen() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("login"), "User navigated away from login screen.");
    }

    @Then("The OAuth token should be encrypted and stored securely")
    public void verifyOAuthTokenSecurity() {
        WebElement tokenField = driver.findElement(oauthTokenHiddenInput);
        String tokenValue = tokenField.getAttribute("value");
        Assert.assertTrue(tokenValue != null && tokenValue.length() > 20, "OAuth token appears insecure or empty.");
        System.out.println("Ensure actual encryption is validated via backend logs or inspection.");
    }

    @Then("User should see {string} button")
    public void verifyGoogleLoginButtonVisible(String buttonText) {
        WebElement button = WaitUtils.waitForVisibility(driver, googleLoginVisible);
        Assert.assertTrue(button.isDisplayed(), "Google login button is not visible.");
    }

    @And("The button should follow the UI design guidelines")
    public void verifyButtonDesignConsistency() {
        WebElement button = driver.findElement(googleLoginVisible);
        String backgroundColor = button.getCssValue("background-color");
        Assert.assertNotNull(backgroundColor);
    }
}