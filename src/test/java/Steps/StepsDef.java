package Steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class StepsDef {

    @Given("I open the calculator app")
    public void iOpenTheCalculatorApp() throws MalformedURLException {

    }

    @When("I press {int}")
    public void iPress(int digit) {
    }

    @When("I press the add button")
    public void iPressTheAddButton() {

    }

    @When("I press the equals button")
    public void iPressTheEqualsButton() {

    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int expectedResult) {

    }
}
