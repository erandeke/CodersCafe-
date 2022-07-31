package com.kedar.imc.models;

import java.util.Scanner;

public class HumanPlayer extends Player {

     /*
       The function generateMoves() will generate the moves for an Human Player
       It will also display on the screen the move played by human player
     */

    @Override
    public String generateMoves() {
        Scanner sc = new Scanner(System.in);
        String playerMove = sc.nextLine();
        return playerMove;
    }



}
