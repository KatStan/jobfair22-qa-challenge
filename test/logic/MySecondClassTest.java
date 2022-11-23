package logic;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
 * novi init
 *   da li je gamesequence list of trues duzine numberofoptions
 *   getnumberofpoints treba da vrati 0
 *   guess od prvog elementa terba vrati true sada; index je misleading name
 *   pozoves addpoint i treba da vrati 1
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
        assertEquals(true, game.guess(1));
    }

    @Test
    public void pointIncrease() {
        game.addPoint();
        assertEquals(1, game.getNumberOfPoints());
    }

}
