package com.kedar.imc.gamemodule.models;

public enum PlayerAction {
    START("start"), QUIT("quit");

    private String action;

     PlayerAction(String action) {
        this.action = action;
    }

}
