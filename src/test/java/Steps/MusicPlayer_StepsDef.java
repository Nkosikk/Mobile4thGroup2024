package Steps;

import Screens.MusicPlayer;
import Screens.calculatorScreen;
import Utils.AppiumDriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;

public class MusicPlayer_StepsDef {
    private AndroidDriver driver;
    private MusicPlayer musicPlayer;

    @Given("I open the music player app")
    public void i_open_the_music_player_app() {
        String appPath = System.getProperty("appPath", System.getProperty("user.dir") + "/src/main/Apps/app-debug.apk");
        AppiumDriverFactory.getInstanceOfAppiumFactory(appPath);
        this.musicPlayer = new MusicPlayer((AndroidDriver) AppiumDriverFactory.getDriver());
    }

    @And("I select a playlist")
    public void iOpenThePlaylist() {
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


}
