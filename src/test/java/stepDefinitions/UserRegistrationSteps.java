package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Hooks;

import static org.junit.Assert.assertTrue;

public class UserRegistrationSteps {

    private final WebDriver driver;

    By emailField = By.id("");
    By passwordField = By.id("");
    By loginButton = By.xpath("");
    By myAccountHeader = By.xpath("");

    public UserRegistrationSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
    }

    @Given("User is on the Hamro Chat registration page")
    public void userIsOnRegistrationPage() {
        driver.get(" ");
    }

    @When("User enters phone number {string}")
    public void userEntersPhoneNumber(String phoneNumber) {
        WebElement phoneInput = driver.findElement(By.id("phone-input")); // Adjust locator
        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);
    }

    @And("User submits the phone number")
    public void userSubmitsPhoneNumber() {
        WebElement submitButton = driver.findElement(By.id("submit-phone")); // Adjust locator
        submitButton.click();
    }

    @And("User enters valid OTP {string}")
    public void userEntersValidOTP(String otp) {
        WebElement otpInput = driver.findElement(By.id("otp-input")); // Adjust locator
        otpInput.clear();
        otpInput.sendKeys(otp);
        driver.findElement(By.id("verify-otp")).click(); // Adjust locator
    }

    @And("User enters invalid OTP {string}")
    public void userEntersInvalidOTP(String otp) {
        WebElement otpInput = driver.findElement(By.id("otp-input")); // Adjust locator
        otpInput.clear();
        otpInput.sendKeys(otp);
        driver.findElement(By.id("verify-otp")).click(); // Adjust locator
    }

    @And("User enters expired OTP {string}")
    public void userEntersExpiredOTP(String otp) {
        System.out.println("Simulating expired OTP entry.");
        WebElement otpInput = driver.findElement(By.id("otp-input")); // Adjust locator
        otpInput.clear();
        otpInput.sendKeys(otp);
        driver.findElement(By.id("verify-otp")).click(); // Adjust locator
    }

    @Then("User should be redirected to the profile setup page")
    public void userRedirectedToProfileSetup() {
        assertTrue(driver.getCurrentUrl().contains("/profile-setup")); // Adjust as needed
    }

    @Then("User should see an error message {string}")
    public void userSeesErrorMessage(String message) {
        WebElement error = driver.findElement(By.xpath("//*[contains(text(),'" + message + "')]"));
        assertTrue(error.isDisplayed());
    }

    @And("User clicks on {string}")
    public void userClicksOn(String buttonText) {
        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'" + buttonText + "')]"));
        button.click();
    }

    @Then("a new OTP should be sent")
    public void newOTPSent() {
        WebElement confirmation = driver.findElement(By.id("otp-sent-message")); // Adjust locator
        assertTrue(confirmation.isDisplayed());
    }

}
