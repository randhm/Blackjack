package com.markrandhawa.Blackjack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class GameTest {

    @InjectMocks
    Game game;

    @Mock
    Hand player_hand, dealer_hand;

    @Test
    public void testGameConstruction() {
        Game game = new Game();
        assertTrue(game.isInPlay);
    }

    @Test
    public void testHandsAreHitTwiceOnly() {
        game.start();
        verify(player_hand, times(2)).hit();
        verify(dealer_hand, times(2)).hit();
    }

    @Test
    public void testPlayerWinsWhenTotalSumEquals21() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        when(player_hand.totalSum()).thenReturn(21);
        game.hasPlayerWonOrLost();
        String expectedOutput = "Player wins\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void hit() {
    }

    @Test
    public void hold() {
    }

    @Test
    public void play() {
    }
}