package fr.kata.tennis;

import fr.kata.tennis.model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class PlayGameTest {

    @Test
    void initial_state() {
        Player player1 = new Player(UUID.randomUUID(), "rico");
        Player player2 = new Player(UUID.randomUUID(), "nota");
        PlayGame tennisGame = new PlayGame(player1, player2);
        Assertions.assertEquals("(0-0)", tennisGame.getScore());
        Assertions.assertEquals("0-0", tennisGame.getCurrentGameStatus());
    }

    @Test
    void player_1_should_score() {
        Player player1 = new Player(UUID.randomUUID(), "rico");
        Player player2 = new Player(UUID.randomUUID(), "nota");
        PlayGame tennisGame = new PlayGame(player1, player2);
        Assertions.assertEquals("(0-0)", tennisGame.getScore());
        Assertions.assertEquals("0-0", tennisGame.getCurrentGameStatus());
        tennisGame.score(player1);
        Assertions.assertEquals("(0-0)", tennisGame.getScore());
        Assertions.assertEquals("15-0", tennisGame.getCurrentGameStatus());
        tennisGame.score(player1);
        Assertions.assertEquals("(0-0)", tennisGame.getScore());
        Assertions.assertEquals("30-0", tennisGame.getCurrentGameStatus());
        tennisGame.score(player1);
        Assertions.assertEquals("(0-0)", tennisGame.getScore());
        Assertions.assertEquals("40-0", tennisGame.getCurrentGameStatus());
    }
}
