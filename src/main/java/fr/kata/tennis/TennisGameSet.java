package fr.kata.tennis;

import fr.kata.tennis.model.GameStatus;
import fr.kata.tennis.model.Player;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class TennisGameSet {
    private final Map<UUID, Integer> gameSetMap;
    private final TennisGame tennisGame;

    public TennisGameSet(Player player1, Player player2) {
        gameSetMap = new LinkedHashMap<>();
        tennisGame = new TennisGame(player1, player2);
        gameSetMap.put(player1.getId(), 0);
        gameSetMap.put(player2.getId(), 0);
    }

    public String getScore() {
        String score = gameSetMap.values().stream().map(String::valueOf).collect(Collectors.joining("-"));
        return "(" + score + ")";
    }

    public String getCurrentGameStatus() {
        return tennisGame.getDisplayScore();
    }

    public String score(Player player) {
        String score = tennisGame.score(player);
        if (GameStatus.WIN.getStatus().equals(score)) {
            int newTennisSet = gameSetMap.get(player.getId()) + 1;
            gameSetMap.put(player.getId(), newTennisSet);
            tennisGame.reset();

            if (newTennisSet >= 6 && (newTennisSet - 2 <= getOpponentScore(player.getId()))) {
                return GameStatus.WIN.getStatus();
            }
        }
        return getScore();
    }

    private int getOpponentScore(UUID playerId) {
        Optional<Integer> opponentScore = gameSetMap.entrySet().stream().filter(entry -> entry.getKey().equals(playerId)).map(Map.Entry::getValue).findAny();
        return opponentScore.orElse(-1);
    }
}
