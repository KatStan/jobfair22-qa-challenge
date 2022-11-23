package logic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
@RunWith(Suite.class)
@SuiteClasses({
        MyClassTest.class,
        MySecondClassTest.class })

public class TestFindThePrize {

    //Unit test example for addPoint function

    //Idea: test all things that have nothing to do with gameplay, but with
    //functionality, like testing addPoint and other individual functions
    //then continue with gameplay; tests are first formed based on game description,
    //then on code for any additional tests

    /*
    * stvari koji moraju da se test:
    * prilikom init:
    *   mora biti number of prizes <= number of options, tj. kako se handle kad nije tako -> dodje ekvivalent
    *   da su svi options false, tj. svi su prizes => numPrizes = numOptions -> assert that
    * novi init
    *   da li je gamesequence list of trues duzine numberofoptions
    *   getnumberofpoints treba da vrati 0
    *   guess od prvog elementa terba vrati true sada; index je misleading name
    *   pozoves addpoint i treba da vrati 1
    * after init, za pocetak gameplay: ovde treba nov init, points su corrupted od malopre
    *   mora biti guesses duzine numberorounds, kako se handle kad nije
    *   zapocnes gameplay: treba da se mock random generator -> ne moram pravi @Mock zar ne? ipak bre mora, moras kazes sta funkcija nexInt vraca ili sta vec
    *       treba da se izmedju svakog round refresh gamesequence na sve true, provera:
    *       newround() sa odredjenim random, proveri je l su samo ti stavljeni a prizes
    *       opet newround, uraditi isto sa proverom, ali novi random vraca disjunktni skup brojeva
    *       u odnosu na malopre -> mora se za mock za random generator staviti u konstruktoru
    * novi init
    *   test playround za tru i false po jedno
    * novi init
    *   za play game
    * */

}
