package com.kedar.imc.gamemodule.models;

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
