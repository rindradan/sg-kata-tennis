package fr.kata.tennis;

import fr.kata.tennis.model.Player;

public class PlayGame {

    private final TennisGameSets tennisGameSets;

    public PlayGame(Player player1, Player player2) {
        tennisGameSets = new TennisGameSets(player1, player2);
    }

    public String score(Player player) {
        return tennisGameSets.score(player);
    }

    public String getScore() {
        return tennisGameSets.getScore();
    }

    public String getCurrentGameStatus() {
        return tennisGameSets.getCurrentGameStatus();
    }
}
