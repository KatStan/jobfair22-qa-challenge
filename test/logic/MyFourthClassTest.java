package logic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


/*after init, za pocetak gameplay:
 *       zapocnes gameplay: treba da se mock random generator -> ne moram pravi @Mock zar ne? ipak mora, moras kazes sta funkcija nexInt vraca ili sta vec
 *       treba da se izmedju svakog round refresh gamesequence na sve true, provera:
 *       newround() sa odredjenim random, proveri je l su samo ti stavljeni a prizes
 *       opet newround, uraditi isto sa proverom, ali novi random vraca disjunktni skup brojeva
 *       u odnosu na malopre -> mora se za mock za random generator staviti u konstruktoru
 *       i koristiti polje rand
* */

public class MyFourthClassTest {
    int numberOfOptions = 4, numberOfPrizes = 2, numberOfRounds = 2;
    FindThePrize game;

    @Mock
    private Random randomMock;

    @Before
    public void setup() {
        randomMock = mock(Random.class, withSettings().withoutAnnotations());
        game = FindThePrize.init(numberOfOptions, numberOfPrizes, numberOfRounds, randomMock);
        when(randomMock.nextInt(anyInt()))
                .thenReturn(0)
                .thenReturn(2)//za prvi for loop tj. 1/2 round
                .thenReturn(1)
                .thenReturn(3); //za drugi for loop tj. 2/2 round
    }

    @Test
    public void refreshedRound() {
        game.newRound();
        assertEquals(false, game.getGameSequence().get(0));
        assertEquals(true, game.getGameSequence().get(1));
        assertEquals(false, game.getGameSequence().get(2));
        assertEquals(true, game.getGameSequence().get(3));
        game.newRound();
        assertEquals(true, game.getGameSequence().get(0));
        assertEquals(false, game.getGameSequence().get(1));
        assertEquals(true, game.getGameSequence().get(2));
        assertEquals(false, game.getGameSequence().get(3));
    }
}
