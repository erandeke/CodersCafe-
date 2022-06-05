package com.kedar.imc.models;

public enum Moves {

    ROCK("rock"), PAPER("paper"), SCISSOR("scissor");

    private String move;

    Moves(String move) {
        this.move = move;
    }

    public String getMove() {
        return move;
    }

}
