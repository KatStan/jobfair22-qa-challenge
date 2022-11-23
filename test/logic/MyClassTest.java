package logic;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*prilikom init:
 *   mora biti number of prizes <= number of options, tj kako se handle kad nije tako -> dodje ekvivalent
 *   da su svi options false, tj. svi su prizes => numPrizes = numOptions -> assert that
 */

public class MyClassTest {
    int numberOfOptions = 2, numberOfPrizes = 3, numberOfRounds = 2;
    FindThePrize game = FindThePrize.init(numberOfOptions, numberOfPrizes, numberOfRounds);

    @Test
    public void whenPrizesGreaterThanOptions() {
        assertEquals(numberOfOptions, game.getNumberOfPrizes());
    }
}
