package Screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MusicPlayer {

    private AndroidDriver driver;

    public MusicPlayer(AndroidDriver driver) {
        this.driver = driver;
    }

    public void pressPlayButton() {
        driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.example.android.uamp.next:id/item_state\"])[1]")).click();
    }

    public String getSongStatus() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.example.musicplayer:id/song_status\"]")).getText();
    }

    public void selectAnyPlaylist() {
        List<WebElement> playlists = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id=\"com.example.android.uamp.next:id/list\"]/android.view.ViewGroup[1]"));
        if (!playlists.isEmpty()) {
            playlists.get(0).click(); // Select the first available playlist
        }
    }
}
