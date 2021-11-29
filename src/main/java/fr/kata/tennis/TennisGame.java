package fr.kata.tennis;

import fr.kata.tennis.model.GameStatus;
import fr.kata.tennis.model.Player;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class TennisGame {
    private final Map<UUID, GameStatus> gameStatusMap;

    public TennisGame(Player player1, Player player2) {
        gameStatusMap = new LinkedHashMap<>();
        gameStatusMap.put(player1.getId(), GameStatus.INITIAL);
        gameStatusMap.put(player2.getId(), GameStatus.INITIAL);
    }

    public String getScore() {
        return gameStatusMap.values().stream().map(GameStatus::getStatus).collect(Collectors.joining("-"));
    }

    public String getDisplayScore() {
        String score = getScore();
        if ("40-40".equals(score)) {
            return GameStatus.DEUCE.getStatus();
        }
        if (score.contains(GameStatus.ADVANTAGE.getStatus())) {
            return GameStatus.ADVANTAGE.getStatus();
        }
        if (score.contains(GameStatus.WIN.getStatus())) {
            return GameStatus.WIN.getStatus();
        }
        return score;
    }

    public String score(Player player) {
        GameStatus newStatus = computeNewGameStatus(player.getId());
        gameStatusMap.put(player.getId(), newStatus);
        if (GameStatus.ADVANTAGE.equals(newStatus)) {
            opponentLosesAdvantage(player.getId());
        }
        return getDisplayScore();
    }

    public void reset() {
        gameStatusMap.replaceAll((i, v) -> GameStatus.INITIAL);
    }

    private GameStatus computeNewGameStatus(UUID playerId) {
        GameStatus gameStatus = gameStatusMap.get(playerId);
        if (GameStatus.INITIAL.equals(gameStatus)) {
            return GameStatus.FIFTEEN;
        }
        if (GameStatus.FIFTEEN.equals(gameStatus)) {
            return GameStatus.THIRTY;
        }
        if (GameStatus.THIRTY.equals(gameStatus)) {
            return GameStatus.FOURTY;
        }
        if (GameStatus.FOURTY.equals(gameStatus)) {
            if (GameStatus.DEUCE.getStatus().equals(getDisplayScore()) || GameStatus.ADVANTAGE.getStatus().equals(getDisplayScore())) {
                return GameStatus.ADVANTAGE;
            }
            return GameStatus.WIN;
        }
        if (GameStatus.ADVANTAGE.equals(gameStatus)) {
            return GameStatus.WIN;
        }
        return null;
    }

    private void opponentLosesAdvantage(UUID playerId) {
        for (UUID otherPlayerId : gameStatusMap.keySet()) {
            if (!playerId.equals(otherPlayerId)) {
                GameStatus otherGameStatus = gameStatusMap.get(otherPlayerId);
                if (GameStatus.ADVANTAGE.equals(otherGameStatus)) {
                    gameStatusMap.put(otherPlayerId, GameStatus.FOURTY);
                }
            }
        }
    }
}
