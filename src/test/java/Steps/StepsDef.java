package Steps;

import Screens.calculatorScreen;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class StepsDef {

    private AndroidDriver driver;
    private calculatorScreen calculator;

    @Given("I open the calculator app")
    public void iOpenTheCalculatorApp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", System.getProperty("user.dir") + "/src/main/Apps/Calculator.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
        calculator = new calculatorScreen(driver);
    }

    @When("I press {int}")
    public void iPress(int digit) {
        calculator.pressDigit(digit);
    }

    @And("I press the add button")
    public void iPressTheAddButton() {
        calculator.pressAddButton();
    }

    @And("I press the equals button")
    public void iPressTheEqualsButton() {
        calculator.pressEqualsButton();
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int expectedResult) {
        String result = calculator.getResult();
        assert result.equals(String.valueOf(expectedResult));
    }
}
