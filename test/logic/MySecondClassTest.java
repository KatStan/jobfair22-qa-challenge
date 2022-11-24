package logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*
 * new init
 *   is gamesequence list of trues of length numberofoptions
 *   getnumberofpoints needs to be 0 now
 *   guess[0] = true now; index might be a misleading name?
 *   call addpoint -> should return 1
 */
public class MySecondClassTest {
    int numberOfOptions = 5, numberOfPrizes = 3, numberOfRounds = 2;
    FindThePrize game = FindThePrize.init(numberOfOptions, numberOfPrizes, numberOfRounds);

    @Test
    public void gameSequenceLength() {
        assertEquals(numberOfOptions, game.getGameSequence().size());
    }

    @Test
    public void initNumberOfPoints() {
        assertEquals(0, game.getNumberOfPoints());
    }

    @Test
    public void returningGuess() {
        assertTrue(game.guess(1));
    }

    @Test
    public void pointIncrease() {
        game.addPoint();
        assertEquals(1, game.getNumberOfPoints());
    }

}
