package MyRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/Features/LoginPage.feature",
    glue = "StepDef",
    plugin = {
        "pretty",
        "html:target/cucumber.html",
        "json:target/cucumber-reports/CucumberTestReport.json",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"  // Enable Allure Reporting
    },
    tags = "@signin or @invalidsignin",
    monochrome = true
)
public class LoginStepsRunnerTestng extends AbstractTestNGCucumberTests {
}
