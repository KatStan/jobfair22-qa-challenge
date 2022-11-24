package logic;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*after init, za pocetak gameplay:
 *   mora biti guesses duzine numberofrounds, kako se handle kad nije (implementacija resava kad
 *   je duze od rounds, ali krace? Neka ide do tog kraceg)
 */
public class MyThirdClassTest {
    int numberOfOptions = 4, numberOfPrizes = 3, numberOfRounds = 3;
    FindThePrize game = FindThePrize.init(numberOfOptions, numberOfPrizes, numberOfRounds);
    List<Integer> guesses = new ArrayList<>(
            Arrays.asList(1, 2));

    @Test
    public void successfulGame() {
        game.playGame(guesses);
    }
}
