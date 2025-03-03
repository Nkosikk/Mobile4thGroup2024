package Steps;

import Utils.AppiumDriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hook {
    //private AndroidDriver driver;
    protected static AndroidDriver<WebElement> driver;

//    @Before
//    public void setUp() {
//        if (driver == null) {
//            String appPath = System.getProperty("appPath", System.getProperty("user.dir") + "/src/main/Apps/app-debug.apk");
//            AppiumDriverFactory.getInstanceOfAppiumFactory(appPath);
//            driver = (AndroidDriver<WebElement>) AppiumDriverFactory.getDriver();
//        }
//    }

    public Hook() {
        this.driver = (AndroidDriver) AppiumDriverFactory.getDriver();
    }
    @AfterStep
    public void addScreenshot(Scenario scenario){
//        if (scenario.isFailed()){
            byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", "image");
//        }
    }

//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
}
