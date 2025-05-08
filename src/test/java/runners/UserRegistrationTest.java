package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

    @CucumberOptions (
            features = "src/test/resources/features/user_registration.feature",
            glue = {"stepDefinitions", "util"},
            tags = "@registration",
            plugin = {
                    "pretty",
                    "json:target/cucumber-reports/cucumber.json",
                    "html:target/cucumber-reports/basic-html-report.html",
                    "junit:target/cucumber-reports/cucumber.xml",
                    "rerun:target/failed_scenarios.txt"
            },
            monochrome = true
    )
    public class UserRegistrationTest extends AbstractTestNGCucumberTests {

}
