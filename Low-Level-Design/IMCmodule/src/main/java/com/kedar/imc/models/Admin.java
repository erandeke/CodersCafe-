package com.kedar.imc.models;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Admin {

    private StringBuilder rulesBuilder;

    public Admin() {
        rulesBuilder = new StringBuilder();
    }

    public boolean isTheMoveValid(String move) {
        return Arrays.stream(Moves.values()).anyMatch(mv -> mv.getMove().equals(move));
    }

    public String showTheRulesOfTheGame() {
        return rulesBuilder.append("\n").append("1. Paper wraps rock").append("\n").append("2. Scissor cuts paper").append("\n").append("3. Rock blunts scissor").append("\n").append("4. QUIT").toString();

    }

    public List<String> showAllowableMoves() {
        return List.of(Moves.ROCK.getMove(), Moves.PAPER.getMove(), Moves.SCISSOR.getMove());
    }


    public void displayAllowableMoves() {
        System.out.println("Let's see the allowable moves to play");
        showAllowableMoves().forEach(move -> System.out.println(move));
    }

    public boolean hasPlayerWon(String playerMove, String botMove) {
        if (playerMove.equals(Moves.PAPER.getMove()) && botMove.equals(Moves.ROCK.getMove()) || playerMove.equals(Moves.ROCK.getMove()) && botMove.equals(Moves.SCISSOR.getMove()) || playerMove.equals(Moves.SCISSOR.getMove()) && botMove.equals(Moves.PAPER.getMove())) {
            return true;
        }
        return false;
    }

    public boolean checkForTie(String humanPlayerMove, String botMove) {
        return humanPlayerMove.equals(botMove);
    }

    public String captureHumanPlayerAction() {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        return ip;
    }


}
