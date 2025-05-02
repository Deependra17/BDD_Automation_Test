package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/login.feature",
        glue = {"stepDefinitions", "util"},
        plugin = {
                "pretty",
                "json:target/cucumber-reports/cucumber.json",  // Must match path in POM
                "html:target/cucumber-reports/basic-html-report.html",
                "junit:target/cucumber-reports/cucumber.xml",
                "rerun:target/failed_scenarios.txt"
        },
        monochrome = true  // Clean and readable console output
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
