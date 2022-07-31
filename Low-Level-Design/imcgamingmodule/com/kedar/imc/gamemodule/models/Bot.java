package com.kedar.imc.gamemodule.models;

import java.util.Random;

public class Bot extends Player {

    @Override
    public String generateMoves() {
        Random random = new Random();
        int max = 3;
        int moveNumber = random.nextInt(max);
        String botMove = Moves.values()[moveNumber].getMove();
        return botMove;
    }
}
