package fr.kata.tennis;

import fr.kata.tennis.model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class TennisGameTest {

    @Test
    void should_score_game() {
        Player player1 = new Player(UUID.randomUUID(), "rico");
        Player player2 = new Player(UUID.randomUUID(), "nota");
        TennisGame process = new TennisGame(player1, player2);
        Assertions.assertEquals("0-0", process.getDisplayScore());
        Assertions.assertEquals("15-0", process.score(player1));
        Assertions.assertEquals("30-0", process.score(player1));
        Assertions.assertEquals("40-0", process.score(player1));
    }

    @Test
    void should_score_deuce() {
        Player player1 = new Player(UUID.randomUUID(), "rico");
        Player player2 = new Player(UUID.randomUUID(), "nota");
        TennisGame process = new TennisGame(player1, player2);
        Assertions.assertEquals("0-0", process.getDisplayScore());
        Assertions.assertEquals("15-0", process.score(player1));
        Assertions.assertEquals("30-0", process.score(player1));
        Assertions.assertEquals("40-0", process.score(player1));
        Assertions.assertEquals("40-15", process.score(player2));
        Assertions.assertEquals("40-30", process.score(player2));
        Assertions.assertEquals("deuce", process.score(player2));
    }

    @Test
    void should_player1_win_advantage() {
        Player player1 = new Player(UUID.randomUUID(), "rico");
        Player player2 = new Player(UUID.randomUUID(), "nota");
        TennisGame process = new TennisGame(player1, player2);
        Assertions.assertEquals("0-0", process.getDisplayScore());
        Assertions.assertEquals("15-0", process.score(player1));
        Assertions.assertEquals("30-0", process.score(player1));
        Assertions.assertEquals("40-0", process.score(player1));
        Assertions.assertEquals("40-15", process.score(player2));
        Assertions.assertEquals("40-30", process.score(player2));
        Assertions.assertEquals("deuce", process.score(player2));
        Assertions.assertEquals("advantage", process.score(player1));
        Assertions.assertEquals("win", process.score(player1));
    }

    @Test
    void should_player1_lose_advantage() {
        Player player1 = new Player(UUID.randomUUID(), "rico");
        Player player2 = new Player(UUID.randomUUID(), "nota");
        TennisGame process = new TennisGame(player1, player2);
        Assertions.assertEquals("0-0", process.getDisplayScore());
        process.score(player1);
        process.score(player1);
        process.score(player1);
        process.score(player2);
        process.score(player2);
        Assertions.assertEquals("deuce", process.score(player2));
        Assertions.assertEquals("advantage", process.score(player1));
        // Assertions.assertEquals("advantage-40", process.getScore());
        Assertions.assertEquals("advantage", process.score(player2));
        // Assertions.assertEquals("40-advantage", process.getScore());
        Assertions.assertEquals("win", process.score(player2));
    }
}
