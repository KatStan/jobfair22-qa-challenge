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


/*after init, za pocetak gameplay:
 *   mora biti guesses duzine numberofrounds, kako se handle kad nije (implementacija resava kad
 *   je duze od rounds, ali krace? Neka ide do tog kraceg)
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
                .thenReturn(0) //za prvi for loop tj. 1/3 round
                .thenReturn(2)
                .thenReturn(3) //za drugi for loop tj. 2/3 round
                .thenReturn(0)
                .thenReturn(1) //za treci for loop tj. 3/3 round
                .thenReturn(3);
    }
    @Test
    public void successfulGame() {
        game.playGame(guesses);
    }
}
