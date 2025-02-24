package Screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MusicPlayer {

    private AndroidDriver driver;

    @FindBy(id = "com.example.musicplayer:id/play_button")
    private WebElement playButton;

    @FindBy(id = "com.example.musicplayer:id/song_status")
    private WebElement songStatus;

    public MusicPlayer(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void pressPlayButton() {
        playButton.click();
    }

    public String getSongStatus() {
        return songStatus.getText();
    }
}
