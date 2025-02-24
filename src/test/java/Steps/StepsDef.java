package Steps;

import Screens.calculatorScreen;
import Utils.AppiumDriverFactory;
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
        String appPath = System.getProperty("appPath", System.getProperty("user.dir") + "/src/main/Apps/Calculator.apk");
        AppiumDriverFactory.getInstanceOfAppiumFactory(appPath);
        this.calculator = new calculatorScreen((AndroidDriver) AppiumDriverFactory.getDriver());
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


    @And("I press the multiply button")
    public void iPressTheMultiplyButton() {
        calculator.pressMultiplyButton();
    }

    @And("I press the percent button")
    public void iPressThePercentButton() {
        calculator.pressPercentButton();
    }

    @When("I enter the number {int}")
    public void iEnterTheNumber(int number) {
        String numberStr = String.valueOf(number);
        for (char digit : numberStr.toCharArray()) {
            calculator.pressDigit(Character.getNumericValue(digit));
        }
    }
}
