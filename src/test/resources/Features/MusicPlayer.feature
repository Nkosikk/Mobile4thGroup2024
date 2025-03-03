Feature: Music Player
@MusicPlayer
  Scenario: Play a song
    Given I open the music player app
    And I select the playlist
    When I press the play button

  Scenario: Play a songs
    Given I open the music player app
    And I select the playlist
    When I press the play button