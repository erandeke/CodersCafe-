package com.kedar.imc.models;

import java.util.Scanner;

public abstract class Player {

    private String move;

    public abstract String generateMoves();

    public String shouldCapturePlayerActions() {
        Scanner sc = new Scanner(System.in);
        String playerMove = sc.nextLine();
        return playerMove;
    }
}
