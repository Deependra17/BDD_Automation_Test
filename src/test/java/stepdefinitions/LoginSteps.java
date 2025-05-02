package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.DriverFactory;

public class LoginSteps {
    private WebDriver driver;

    @Given("^User is on the login page$")
    public void user_is_on_login_page() {
        driver = DriverFactory.getDriver();
        driver.get("^https://example.com/login$");
    }

    @When("^User enters valid <userName> and <password>$")
    public void user_enters_valid_credentials() {
        driver.findElement(By.xpath("")).sendKeys("");
    }

    @And("^User clicks on login button$")
    public void user_click_on_login_button() {
        driver.findElement(By.xpath("")).click();

    }

    @Then("^UUser should logged in successfully$")
    public void user_should_logged_in_successfully() {
        String actualUserName = driver.findElement(By.xpath("")).getText();
        String expectedUserName = "Dipendra Bohara";
        Assert.assertEquals(actualUserName, expectedUserName, "User Name does not match");
        DriverFactory.quitDriver();
    }
}
