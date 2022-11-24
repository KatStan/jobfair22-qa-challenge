package logic;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


/* after init, for starting gameplay: new init here, points are corrupted from just before
 *   guesses must be length of numberorounds, how to handle when it's not
 */
public class MyThirdClassTest {
    int numberOfOptions = 4, numberOfPrizes = 3, numberOfRounds = 3;
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
                .thenReturn(0).thenReturn(2) //first for loop i.e. 1/3 round
                .thenReturn(3).thenReturn(0) //second for loop i.e. 2/3 round
                .thenReturn(1).thenReturn(3); //third for loop i.e. 3/3 round

    }
    @Test
    public void successfulGame() {
        game.playGame(guesses);
    }
}
