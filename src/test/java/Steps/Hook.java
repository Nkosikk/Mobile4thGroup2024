package Steps;

import Utils.AppiumDriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hook {
    private AndroidDriver driver;

    public Hook() {
        this.driver = (AndroidDriver) AppiumDriverFactory.getDriver();
    }
    @AfterStep
    public void addScreenshot(Scenario scenario){
        if (scenario.isFailed()){
            byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", "image");
        }
    }
}
