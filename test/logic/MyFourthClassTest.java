package logic;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


/* after init, for starting gameplay: new init here, points are corrupted from just before
 *   start gameplay: need to mock random generator -> Don't need @Mock? yes you do, must say what function nexInt returns
 *       between each round, gamesequence needs resetting to all true, how to check it:
 *       newround() with certain mock random, check whether only those are put as prizes (to false)
 *       next newround, same check, but new mock random holds a non-overlapping set of numbers with before
 *       knowing this -> mock random generator must be in constructor and use that field
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
                .thenReturn(0).thenReturn(2) //first for loop i.e. 1/2 round
                .thenReturn(1).thenReturn(3); //second loop i.e. 2/2 round

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
