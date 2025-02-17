package Screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class calculatorScreen {

    private AndroidDriver driver;

    @FindBy(id = "com.google.android.calculator:id/op_add")
    private WebElement addButton;

    @FindBy(id = "eom.google.android.calculator:id/eq")
    private WebElement equalsButton;

    @FindBy(id = "com.google.android.calculator:id/result_final")
    private WebElement result;

    public calculatorScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void pressDigit(int digit) {
        driver.findElementById("com.google.android.calculator:id/digit_" + digit).click();
    }

    public void pressAddButton() {
        addButton.click();
    }

    public void pressEqualsButton() {
        equalsButton.click();
    }

    public String getResult() {
        return result.getText();
    }
}
