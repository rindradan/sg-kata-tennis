package fr.kata.tennis;

import fr.kata.tennis.model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class TennisGameSetTest {

    @Test
    void should_score_a_set() {
        Player player1 = new Player(UUID.randomUUID(), "rico");
        Player player2 = new Player(UUID.randomUUID(), "nota");
        TennisGameSet tennisGameSet = new TennisGameSet(player1, player2);
        Assertions.assertEquals("(0-0)", tennisGameSet.getScore());
        Assertions.assertEquals("(0-0)", tennisGameSet.score(player1));
        Assertions.assertEquals("(0-0)", tennisGameSet.score(player1));
        Assertions.assertEquals("(0-0)", tennisGameSet.score(player1));
        Assertions.assertEquals("(1-0)", tennisGameSet.score(player1));
    }

    @Test
    void should_win_a_set_after_win_6_games() {
        Player player1 = new Player(UUID.randomUUID(), "rico");
        Player player2 = new Player(UUID.randomUUID(), "nota");
        TennisGameSet tennisGameSet = new TennisGameSet(player1, player2);
        Assertions.assertEquals("(0-0)", tennisGameSet.getScore());
        win_a_set(6, tennisGameSet, player1);
        Assertions.assertEquals("(6-0)", tennisGameSet.getScore());
    }

    @Test
    void should_win_a_set_after_win_8_games() {
        Player player1 = new Player(UUID.randomUUID(), "rico");
        Player player2 = new Player(UUID.randomUUID(), "nota");
        TennisGameSet tennisGameSet = new TennisGameSet(player1, player2);
        Assertions.assertEquals("(0-0)", tennisGameSet.getScore());
        win_a_set(5, tennisGameSet, player1);
        Assertions.assertEquals("(5-0)", tennisGameSet.getScore());
        win_a_set(6, tennisGameSet, player2);
        Assertions.assertEquals("(5-6)", tennisGameSet.getScore());
        win_a_set(3, tennisGameSet, player1);
        Assertions.assertEquals("(8-6)", tennisGameSet.getScore());
    }

    private void win_a_set(int times, TennisGameSet tennisGameSet, Player player) {
        for (int i=0 ; i<4*times ; i++) {
            tennisGameSet.score(player);
        }
    }
}
