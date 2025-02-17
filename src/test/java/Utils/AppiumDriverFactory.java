package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverFactory {

    private AndroidDriver driver;

    public static AppiumDriverFactory instanceOfAppiumFactory;

    public AppiumDriverFactory() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", System.getProperty("user.dir") + "/src/main/Apps/Calculator.apk");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(15, java.util.concurrent.TimeUnit.SECONDS);
    }

    public static AppiumDriverFactory getInstanceOfAppiumFactory() {
        if (instanceOfAppiumFactory == null)
            instanceOfAppiumFactory = new AppiumDriverFactory();
        return instanceOfAppiumFactory;
    }

    public AppiumDriver getDriver() {
        return driver;
    }

}
