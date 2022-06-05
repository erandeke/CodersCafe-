package com.kedar.imc.test.client;


import com.kedar.imc.client.PlayGameClient;
import com.kedar.imc.models.Admin;
import com.kedar.imc.models.Bot;
import com.kedar.imc.models.HumanPlayer;
import com.kedar.imc.test.data.Fixtures;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PlayGameClientTest {

    @Mock
    Bot bot;

    @Mock
    HumanPlayer player;


    Admin admin;

    PlayGameClient playGameClient;

    @Before
    public void setUp() {
        this.admin = new Admin();
        this.playGameClient = new PlayGameClient(bot, player, admin);
    }


    @Test
    public void checkIfPlayerHasWon() {
        //given
        String humanPlayerMove = Fixtures.getRock();
        Mockito.when(player.generateMoves()).thenReturn(humanPlayerMove);
        String botPlayerMove = Fixtures.getScissor();
        Mockito.when(bot.generateMoves()).thenReturn(botPlayerMove);
        Mockito.when(player.shouldCapturePlayerActions()).thenReturn(Fixtures.playerSaysQUIT());
        //Mockito.when(admin.showAllowableMoves()).thenReturn(List.of("rock", "paper", "scissor"));
        //when
        playGameClient.playGame();
        //then
        boolean hasPlayerWonActual = admin.hasPlayerWon(humanPlayerMove, botPlayerMove);
        boolean hasPlayerWonExpected = true;
        Assert.assertEquals(hasPlayerWonExpected, hasPlayerWonActual);

    }

    @Test
    public void checkIfBotHasWon() {
        //given
        String humanPlayerMove = Fixtures.getRock();
        Mockito.when(player.generateMoves()).thenReturn(humanPlayerMove);
        String botPlayerMove = Fixtures.getPaper();
        Mockito.when(bot.generateMoves()).thenReturn(botPlayerMove);
        Mockito.when(player.shouldCapturePlayerActions()).thenReturn(Fixtures.playerSaysQUIT());
        //Mockito.when(admin.showAllowableMoves()).thenReturn(List.of("rock", "paper", "scissor"));
        //when
        playGameClient.playGame();
        //then
        boolean hasPlayerWonActual = admin.hasPlayerWon(humanPlayerMove, botPlayerMove);
        boolean hasPlayerWonExpected = false;
        Assert.assertEquals(hasPlayerWonExpected, hasPlayerWonActual);

    }


    @Test
    public void checkIfItsATie() {
        //given
        String humanPlayerMove = Fixtures.getRock();
        Mockito.when(player.generateMoves()).thenReturn(humanPlayerMove);
        String botPlayerMove = Fixtures.getRock();
        Mockito.when(bot.generateMoves()).thenReturn(botPlayerMove);
        Mockito.when(player.shouldCapturePlayerActions()).thenReturn(Fixtures.playerSaysQUIT());
        //Mockito.when(admin.showAllowableMoves()).thenReturn(List.of("rock", "paper", "scissor"));
        //when
        playGameClient.playGame();
        //then
        boolean actual = admin.checkForTie(humanPlayerMove, botPlayerMove);
        boolean expected = true;
        Assert.assertEquals(expected, actual);

    }


    @Test
    public void checkIfPlayerHasEnteredAValidMove() {
        //given
        String humanPlayerMove = Fixtures.generateInvalidMove();
        Mockito.when(player.generateMoves()).thenReturn(humanPlayerMove);
        String botPlayerMove = Fixtures.getRock();
        Mockito.when(bot.generateMoves()).thenReturn(botPlayerMove);
        Mockito.when(player.shouldCapturePlayerActions()).thenReturn(Fixtures.playerSaysQUIT());
        //Mockito.when(admin.showAllowableMoves()).thenReturn(List.of("rock", "paper", "scissor"));
        //when
        playGameClient.playGame();
        //then
        boolean actual = admin.isTheMoveValid(humanPlayerMove);
        boolean expected = false;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void checkIfPlayerWantsToContinue() {
        String humanPlayerMove = Fixtures.getRock();
        Mockito.when(player.generateMoves()).thenReturn(humanPlayerMove);
        String botPlayerMove = Fixtures.getRock();
        Mockito.when(bot.generateMoves()).thenReturn(botPlayerMove);
        Mockito.when(player.shouldCapturePlayerActions()).thenReturn(Fixtures.playerSaysQUIT());
        //Mockito.when(admin.showAllowableMoves()).thenReturn(List.of("rock", "paper", "scissor"));
        //when
        playGameClient.playGame();
        //then
        String actual = player.shouldCapturePlayerActions();
        String expected = Fixtures.playerSaysQUIT();
        Assert.assertEquals(expected, actual);
    }

}
