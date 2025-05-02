package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import util.Hooks;
import util.WaitUtils;

public class LoginSteps {

    private WebDriver driver;

    By emailField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginButton = By.xpath("//input[@value='Login']");
    By myAccountHeader = By.xpath("//div[@id='content']/h2");

    public LoginSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
    }

    @Given("User enters valid email {string}")
    public void user_enters_valid_email(String email) {
        WebElement emailInput = WaitUtils.waitForVisibility(driver, emailField);
        emailInput.sendKeys(email);
    }

    @And("User enters valid password {string}")
    public void user_enters_valid_password(String password) {
        WebElement passwordInput = WaitUtils.waitForVisibility(driver, passwordField);
        passwordInput.sendKeys(password);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        WebElement loginBtn = WaitUtils.waitForClickability(driver, loginButton);
        loginBtn.click();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        WebElement header = WaitUtils.fluentWait(driver, myAccountHeader, 10, 500);
        String actualHeader = header.getText();
        Assert.assertEquals(actualHeader, "My Account", "Login failed or wrong page title.");
    }
}
