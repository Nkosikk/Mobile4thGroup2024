package Steps;

import Utils.AppiumDriverFactory;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hook {

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            AppiumDriverFactory factory = AppiumDriverFactory.getInstanceOfAppiumFactory();
            factory.takeScreenshot(scenario.getName().replaceAll(" ", "_"));
        }
    }
}
