package fr.kata.tennis;

import fr.kata.tennis.model.GameStatus;
import fr.kata.tennis.model.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TennisGameSets {
    private final List<TennisGameSet> tennisGameSetList;
    private final Player player1;
    private final Player player2;

    public TennisGameSets(Player player1, Player player2) {
        this.tennisGameSetList = new LinkedList<>();
        this.player1 = player1;
        this.player2 = player2;
        TennisGameSet tennisGameSet = new TennisGameSet(player1, player2);
        tennisGameSetList.add(tennisGameSet);
    }

    public String getScore() {
        return tennisGameSetList.stream().map(TennisGameSet::getScore).collect(Collectors.joining());
    }

    public String getCurrentGameStatus() {
        return getCurrentGameSet().getCurrentGameStatus();
    }

    public String score(Player player) {
        TennisGameSet currentTennisGameSet = getCurrentGameSet();
        String score = currentTennisGameSet.score(player);
        if (GameStatus.WIN.getStatus().equals(score)) {
            TennisGameSet newTennisGameSet = new TennisGameSet(player1, player2);
            tennisGameSetList.add(newTennisGameSet);
        }
        return getScore();
    }

    private TennisGameSet getCurrentGameSet() {
        return tennisGameSetList.get(tennisGameSetList.size() - 1);
    }
}
