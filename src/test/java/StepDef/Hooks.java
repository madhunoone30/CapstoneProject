package StepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import GeneralFiles.ExtentReport;
import GeneralFiles.JPetBaseClass;

public class Hooks extends JPetBaseClass {

    @Before // Runs before every scenario
    public void setup() {  
        invokeBrowser("Firefox"); // Launch browser
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ExtentReport.getInstance(); // Start Extent Report
        System.out.println("Setup completed in Hooks");
    }

    @After // Runs after every scenario
    public void tearDown(Scenario scenario) throws InterruptedException {
        // Capture Allure screenshot on failure
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            saveScreenshot(screenshot);
        }

        ExtentReport.getInstance().flush(); // End Extent Report
        closeBrowser(); // Close browser
        System.out.println("Teardown completed in Hooks");
    }

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }
}
