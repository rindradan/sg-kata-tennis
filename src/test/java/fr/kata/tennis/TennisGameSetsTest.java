package fr.kata.tennis;

import fr.kata.tennis.model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class TennisGameSetsTest {

    @Test
    void should_score_a_set() {
        Player player1 = new Player(UUID.randomUUID(), "rico");
        Player player2 = new Player(UUID.randomUUID(), "nota");
        TennisGameSets tennisGameSets = new TennisGameSets(player1, player2);
        Assertions.assertEquals("(0-0)", tennisGameSets.getScore());
        Assertions.assertEquals("(0-0)", tennisGameSets.score(player1));
        Assertions.assertEquals("(0-0)", tennisGameSets.score(player1));
        Assertions.assertEquals("(0-0)", tennisGameSets.score(player1));
        Assertions.assertEquals("(1-0)", tennisGameSets.score(player1));
    }

    @Test
    void should_win_a_set() {
        Player player1 = new Player(UUID.randomUUID(), "rico");
        Player player2 = new Player(UUID.randomUUID(), "nota");
        TennisGameSets tennisGameSets = new TennisGameSets(player1, player2);
        Assertions.assertEquals("(0-0)", tennisGameSets.getScore());
        win_a_set(6, tennisGameSets, player1);
        Assertions.assertEquals("(6-0)(0-0)", tennisGameSets.getScore());
    }

    @Test
    void should_win_2_set() {
        Player player1 = new Player(UUID.randomUUID(), "rico");
        Player player2 = new Player(UUID.randomUUID(), "nota");
        TennisGameSets tennisGameSets = new TennisGameSets(player1, player2);
        Assertions.assertEquals("(0-0)", tennisGameSets.getScore());
        win_a_set(6, tennisGameSets, player1);
        Assertions.assertEquals("(6-0)(0-0)", tennisGameSets.getScore());
        win_a_set(6, tennisGameSets, player1);
        Assertions.assertEquals("(6-0)(6-0)(0-0)", tennisGameSets.getScore());
    }

    @Test
    void should_check_game_status() {
        Player player1 = new Player(UUID.randomUUID(), "rico");
        Player player2 = new Player(UUID.randomUUID(), "nota");
        TennisGameSets tennisGameSets = new TennisGameSets(player1, player2);
        Assertions.assertEquals("(0-0)", tennisGameSets.getScore());
        tennisGameSets.score(player1);
        tennisGameSets.score(player1);
        tennisGameSets.score(player1);
        Assertions.assertEquals("(0-0)", tennisGameSets.getScore());
        Assertions.assertEquals("40-0", tennisGameSets.getCurrentGameStatus());
    }

    private void win_a_set(int times, TennisGameSets tennisGameSets, Player player) {
        for (int i=0 ; i<4*times ; i++) {
            tennisGameSets.score(player);
        }
    }
}
