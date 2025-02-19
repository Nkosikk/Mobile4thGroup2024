package Steps;

import Utils.AppiumDriverFactory;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hook {

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            AppiumDriverFactory factory = AppiumDriverFactory.getInstanceOfAppiumFactory();
            String screenshotPath = factory.takeScreenshot(scenario.getName().replaceAll(" ", "_"));
            try {
                byte[] screenshot = Files.readAllBytes(Paths.get(screenshotPath));
                scenario.attach(screenshot, "image/png", "Screenshot");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
