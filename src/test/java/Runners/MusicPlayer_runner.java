package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features/MusicPlayer.feature",
        glue = {"Steps"},
        tags = "",
        plugin = {"pretty", "html:Reports/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        publish = true)
public class MusicPlayer_runner extends AbstractTestNGCucumberTests {
}
