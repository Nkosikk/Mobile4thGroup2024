package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverFactory {

    private static AndroidDriver driver;

    public static AppiumDriverFactory instanceOfAppiumFactory;

    public AppiumDriverFactory(String appPath) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", appPath);
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
    }

    public static AppiumDriverFactory getInstanceOfAppiumFactory(String appPath) {
        if (instanceOfAppiumFactory == null)
            instanceOfAppiumFactory = new AppiumDriverFactory(appPath);
        return instanceOfAppiumFactory;
    }

    public static AppiumDriver getDriver() {
        return driver;
    }


    public String takeScreenshot(String fileName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(srcFile, new File(System.getProperty("user.dir") + "/screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

}
