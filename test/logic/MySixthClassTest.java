package logic;

/*
* novi init
 *   za play game*/

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class MySixthClassTest {
    int numberOfOptions = 4, numberOfPrizes = 2, numberOfRounds = 3;
    FindThePrize game;
    List<Integer> guesses;

    @Mock
    private Random randomMock;

    @Before
    public void setup() {
        randomMock = mock(Random.class, withSettings().withoutAnnotations());
        game = FindThePrize.init(numberOfOptions, numberOfPrizes, numberOfRounds, randomMock);
        when(randomMock.nextInt(anyInt())) //ubaci 3 negde
                .thenReturn(1) //za prvi for loop tj. 1/3 round
                .thenReturn(0)
                .thenReturn(1) //pocinje sledeci game, za prvi for loop tj. 1/3 round
                .thenReturn(1)
                .thenReturn(1) //za drugi for loop tj. 2/3 round
                .thenReturn(0)
                .thenReturn(2) //pocinje sledeci game, za prvi for loop tj. 1/3 round
                .thenReturn(1)
                .thenReturn(3) //za drugi for loop tj. 2/3 round
                .thenReturn(2)
                .thenReturn(3) //za treci for loop tj. 3/3 round
                .thenReturn(0);

    }

    @Test
    public void gamePlay() {
        //loses at the first try
        guesses = new ArrayList<>(Arrays.asList(4, 2, 1));
        int gameplay = game.playGame(guesses);
        assertEquals(0, game.getNumberOfPoints());
        //gets the first one, loses at the second
        guesses = new ArrayList<>(Arrays.asList(2, 3, 1));
        gameplay = game.playGame(guesses);
        assertEquals(1, game.getNumberOfPoints());
        //gets all three
        guesses = new ArrayList<>(Arrays.asList(2, 3, 1));
        gameplay = game.playGame(guesses);
        assertEquals(3, game.getNumberOfPoints());
    }
}
