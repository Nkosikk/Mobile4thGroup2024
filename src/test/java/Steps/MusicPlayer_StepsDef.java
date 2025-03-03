package Steps;

import Screens.MusicPlayer;
import Screens.calculatorScreen;
import Utils.AppiumDriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class MusicPlayer_StepsDef {
    private AndroidDriver<WebElement> driver;
    private MusicPlayer musicPlayer;

    @Given("I open the music player app")
    public void i_open_the_music_player_app() {
        // Initialize the driver if it's not already initialized
        if (driver == null) {
            String appPath = System.getProperty("appPath", System.getProperty("user.dir") + "/src/main/Apps/app-debug.apk");
            AppiumDriverFactory.getInstanceOfAppiumFactory(appPath);
            this.driver = (AndroidDriver<WebElement>) AppiumDriverFactory.getDriver();
            this.musicPlayer = new MusicPlayer(driver);
        }

        // Reset the app to its initial state
        driver.resetApp(); // This will reset the app after each scenario
    }

    @And("I select the playlist")
    public void i_select_the_playlist() {
        musicPlayer.selectAnyPlaylist();
    }

    @When("I press the play button")
    public void i_press_the_play_button() {
        musicPlayer.pressPlayButton();
    }

    @Then("the song should start playing")
    public void the_song_should_start_playing() {
        String status = musicPlayer.getSongStatus();
        assert status.equals("Playing");
    }

    // No need to quit the driver explicitly, as the app will be reset and the session will stay active
    @After
    public void tearDown() {
        // Optionally, you can quit the driver after each scenario if you want to completely end the session
        // driver.quit();
    }

}
