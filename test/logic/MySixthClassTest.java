package logic;

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

/*new init
 *   for playing the game
 */
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

    }

    @Test
    public void gamePlayLosesAtFirstTry() {
        //loses at the first try
        when(randomMock.nextInt(anyInt()))
                .thenReturn(1).thenReturn(0); //first for loop i.e. 1/3 round


        guesses = new ArrayList<>(Arrays.asList(4, 2, 1));
        int gameplay = game.playGame(guesses);
        assertEquals(gameplay, game.getNumberOfPoints());
        assertEquals(0, game.getNumberOfPoints());

    }

    @Test
    public void gamePlayGetsFirstLosesAtSecond() {
        //gets the first one, loses at the second
        when(randomMock.nextInt(anyInt()))
                .thenReturn(1).thenReturn(1) //first for loop i.e. 1/3 round
                .thenReturn(1).thenReturn(0); //second for loop i.e. 2/3 round


        guesses = new ArrayList<>(Arrays.asList(2, 3, 1));
        int gameplay = game.playGame(guesses);
        assertEquals(gameplay, game.getNumberOfPoints());
        assertEquals(1, game.getNumberOfPoints());

    }

    @Test
    public void gamePlayGetsAll() {
        //gets all three
        when(randomMock.nextInt(anyInt()))
                .thenReturn(2).thenReturn(1) //first for loop i.e. 1/3 round
                .thenReturn(3).thenReturn(2) //second for loop i.e. 2/3 round
                .thenReturn(3).thenReturn(0); //third for loop i.e. 3/3 round

        guesses = new ArrayList<>(Arrays.asList(2, 3, 1));
        int gameplay = game.playGame(guesses);
        assertEquals(gameplay, game.getNumberOfPoints());
        assertEquals(3, game.getNumberOfPoints());

    }


}
