package com.kedar.imc.models;

public enum PlayerAction {
    START("start"), QUIT("quit");

    private String action;

     PlayerAction(String action) {
        this.action = action;
    }

}
