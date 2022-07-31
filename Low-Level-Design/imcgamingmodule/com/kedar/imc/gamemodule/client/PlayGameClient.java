package com.kedar.imc.gamemodule.client;

import com.kedar.imc.gamemodule.models.*;

import java.util.List;


public class PlayGameClient {

    Bot bot;
    HumanPlayer humanPlayer;

    Admin admin;

    public void initGame() {
        bot = new Bot();
        humanPlayer = new HumanPlayer();
        admin = new Admin();
    }

    public void playGame() {

        System.out.println("Welcome to ROCK-PAPER-SCISSOR game!!");
        System.out.println();
        System.out.println("Here are the game rules" + admin.showTheRulesOfTheGame());
        System.out.println();
        admin.displayAllowableMoves();
        System.out.println();
        System.out.println("Lets play now....");
        while (true) {
            System.out.println();
            String humanPlayerMove = humanPlayer.generateMoves();
            System.out.println("Your move is :->" + humanPlayerMove);
            if (humanPlayerMove.equals("QUIT")) {
                System.out.println("Thanks For Playing !! See you soon");
                break;
            }
            String botMove = bot.generateMoves();
            System.out.println("Bot move is :->" + botMove);

            if (!admin.isTheMoveValid(humanPlayerMove)) {
                System.out.println("Ahh! you have entered an invalid move. You are allowed to enter from the following moves");
                List<String> moves = admin.showAllowableMoves();
                moves.forEach(move -> System.out.println(move));
            } else if (admin.hasPlayerWon(humanPlayerMove, botMove)) {
                System.out.println("That's Great ! You have won this game");
            } else if (admin.checkForTie(humanPlayerMove, botMove)) {
                System.out.println("Ohh that was quite tough! Its a tie");
            } else {
                System.out.println("Ahh you have lost the game ! Bot won's");
            }

        }

    }

    public static void main(String[] args) {
        PlayGameClient playGameClient = new PlayGameClient();
        playGameClient.initGame();
        playGameClient.playGame();

    }
}
