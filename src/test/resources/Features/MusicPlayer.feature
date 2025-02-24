Feature: Music Player

  Scenario: Play a song
    Given I open the music player app
    When I press the play button
    Then the song should start playing