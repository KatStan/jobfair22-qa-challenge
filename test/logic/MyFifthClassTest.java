package logic;

/*
 * new init
 *   test playround for true and false
 * */

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class MyFifthClassTest {
    int numberOfOptions = 4, numberOfPrizes = 2, numberOfRounds = 2;
    FindThePrize game;
    List<Integer> guesses = new ArrayList<>(
            Arrays.asList(1, 2));

    @Mock
    private Random randomMock;

    @Before
    public void setup() {
        randomMock = mock(Random.class, withSettings().withoutAnnotations());
        game = FindThePrize.init(numberOfOptions, numberOfPrizes, numberOfRounds, randomMock);
        when(randomMock.nextInt(anyInt()))
                .thenReturn(0).thenReturn(0) //first for loop i.e. 1/2 round
                .thenReturn(3).thenReturn(2); //second loop i.e. 2/2 round

    }

    @Test
    public void playingRounds() {
        boolean currentRoundGuess = game.playRound(guesses.get(0));
        assertEquals(1, game.getNumberOfPoints());
        assertFalse(currentRoundGuess);
        currentRoundGuess = game.playRound(guesses.get(1));
        assertEquals(1, game.getNumberOfPoints());
        assertTrue(currentRoundGuess);

    }
}
