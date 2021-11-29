package fr.kata.tennis.model;

public enum GameStatus {
    INITIAL("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FOURTY("40"),
    DEUCE("deuce"),
    ADVANTAGE("advantage"),
    WIN("win"),
    ;

    private String status;

    GameStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
