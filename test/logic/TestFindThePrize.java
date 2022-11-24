package logic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        MySecondClassTest.class,
        MyThirdClassTest.class,
        MyFourthClassTest.class,
        MyFifthClassTest.class,
        MySixthClassTest.class})

public class TestFindThePrize {

    //Unit test example for addPoint function

    //Idea: test all things that have nothing to do with gameplay, but with
    //functionality, like testing addPoint and other individual functions
    //then continue with gameplay; tests are first formed based on game description,
    //then on code for any additional tests

    /*
     * things needed to be tested:
     * new init
     *   is gamesequence list of trues of length numberofoptions
     *   getnumberofpoints needs to be 0 now
     *   guess[0] = true now; index might be a misleading name?
     *   call addpoint -> should return 1
     * after init, for starting gameplay: new init here, points are corrupted from just before
     *   guesses must be length of numberorounds, how to handle when it's not
     *   start gameplay: need to mock random generator -> Don't need @Mock? yes you do, must say what function nexInt returns
     *       between each round, gamesequence needs reseting to all true, how to check it:
     *       newround() with certain mock random, check whether only those are put as prizes (to false)
     *       next newround, same check, but new mock random holds a non-overlapping set of numbers with before
     *       knowing this -> mock random generator must be in constructor
     * new init
     *   test playround for true and false
     * new init
     *   for playing the game
     * */

}
