package com.kedar.imc.client;

import com.kedar.imc.models.Admin;
import com.kedar.imc.models.Bot;
import com.kedar.imc.models.HumanPlayer;
import com.kedar.imc.models.Player;

import java.util.List;

/**
 * This client is used for maintaining the game life-cycle
 */

public class PlayGameClient {

    Bot bot;
    Player humanPlayer;

    Admin admin;

    public void initGame() {
        bot = new Bot();
        humanPlayer = new HumanPlayer();
        admin = new Admin();
    }

    public PlayGameClient() {
        initGame();
    }

    public PlayGameClient(Bot bot, Player player, Admin admin) {
        this.bot = bot;
        this.admin = admin;
        this.humanPlayer = player;
    }

    public void playGame() {

        System.out.println("Welcome to ROCK-PAPER-SCISSOR game!!");
        System.out.println();
        System.out.println("Here are the game rules" + admin.showTheRulesOfTheGame());
        System.out.println();
        admin.displayAllowableMoves();
        System.out.println();
        System.out.println("Lets play now....");
        startGame();

    }

    /**
     * StartGame() - is used to actual start the game and validate the results .Also
     * it checks if user is interested to continue
     * PlayerMove - It captures the player Move
     * BotMove - It captures the BOT move
     */
    public void startGame() {
        System.out.println();
        System.out.println("Hey player,please enter your move");
        String humanPlayerMove = captureHumanPlayerMove();
        System.out.println("Your move is :->" + humanPlayerMove);
        if (humanPlayerMove.equals("QUIT")) {
            System.out.println("Thanks For Playing !! See you soon");
            return;
        }
        String botMove = captureBotMove();
        System.out.println("Bot move is :->" + botMove);
        checkTheResults(humanPlayerMove, botMove);
        boolean isInterested = checkIfPlayerWantsToContinue();
        if (isInterested) {
            startGame();
        } else {
            System.out.println("GoodBye !! see you soon");
        }


    }

    /**
     * @return Player move : Should be the user input
     */
    public String captureHumanPlayerMove() {
        return humanPlayer.generateMoves();
    }

    /**
     * @return Bot Move : Game will randomly generate the bot move
     */
    public String captureBotMove() {
        return bot.generateMoves();
    }

    /**
     * @param humanPlayerMove
     * @param botMove         This checks the results
     */
    public void checkTheResults(String humanPlayerMove, String botMove) {
        if (!admin.isTheMoveValid(humanPlayerMove)) {
            System.out.println("Ahh! you have entered an invalid move. You are allowed to enter from the following moves");
            List<String> moves = admin.showAllowableMoves();
            moves.forEach(move -> System.out.println(move));
        } else if (admin.hasPlayerWon(humanPlayerMove, botMove)) {
            System.out.println("That's Great ! You have won this game");
            System.out.println();
        } else if (admin.checkForTie(humanPlayerMove, botMove)) {
            System.out.println("Ohh that was quite tough! Its a tie");
            System.out.println();
        } else {
            System.out.println("Ahh you have lost the game ! Bot won's");
            System.out.println();
        }

    }

    /**
     * @return boolean : If the player wants to continue
     */
    public boolean checkIfPlayerWantsToContinue() {
        System.out.println("Hey ! Do you wish to continue ?  Press YES for new game OR QUIT to exit");
        String action = humanPlayer.shouldCapturePlayerActions();
        if (action.equals("YES")) {
            return true;
        } else if (action.equals("QUIT")) {
            System.out.println(action);
            System.out.println("Ahh , you have QUIT the game!");
            System.out.println();
            return false;
        } else {
            System.out.println("Ahh ! You have entered invalid action");
            System.out.println();
            return checkIfPlayerWantsToContinue();

        }

    }


    public static void main(String[] args) {
        PlayGameClient playGameClient = new PlayGameClient();
        playGameClient.playGame();

    }
}
