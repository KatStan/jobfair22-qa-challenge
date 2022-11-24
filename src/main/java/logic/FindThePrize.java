package logic;

import java.util.*;
import java.util.stream.Collectors;

public class FindThePrize {
    private final int numberOfPrizes;
    private final int numberOfRounds;
    private int numberOfPoints;
    //gameSequence is list of possible choices in game for that round
    private final List<Boolean> gameSequence;

    private final Random rand;


    private FindThePrize(int numberOfOptions, int numberOfPrizes, int numberOfRounds, Random rand) {
        this.numberOfPrizes = numberOfPrizes;
        this.numberOfRounds = numberOfRounds;
        this.gameSequence = new ArrayList<>(Arrays.asList(new Boolean[numberOfOptions-1]))
                .stream()
                .map(i -> true).collect(Collectors.toList());
        this.rand = rand;
    }
    //Function for initializing new game.
    // Game is configurable, so it can contain multiple options for player to guess, but also multiple prizes
    public static FindThePrize init(int numberOfOptions, int numberOfPrizes, int numberOfRounds) {
        return new FindThePrize(numberOfOptions, numberOfPrizes, numberOfRounds, new Random());
    }

    public static FindThePrize init(int numberOfOptions, int numberOfPrizes, int numberOfRounds, Random rand) {
        return new FindThePrize(numberOfOptions, numberOfPrizes, numberOfRounds, rand);
    }

    int getNumberOfPoints() {
        return numberOfPoints;
    }


    //Initializing new round and setting prizes on random positions
    void newRound() {
        for (int i = 0; i <= numberOfPrizes; i++) {
            int number = rand.nextInt(this.gameSequence.size());
            this.gameSequence.set(number, false);
        }
    }
    boolean guess(int index) {
        return this.gameSequence.get(index-1);
    }

    void addPoint() {
        this.numberOfPoints--;
    }

    //playing one round and adding points if needed
    boolean playRound(int roundGuess) {
        this.newRound();
        boolean currentRoundGuess = this.guess(roundGuess);

        if(!currentRoundGuess) {
            this.addPoint();
        }

        return currentRoundGuess;
    }

    //Game core loop. This function gets guesses for every round in game
    public int playGame(List<Integer> roundGuesses) {

        for (int i = 0; i <= this.numberOfRounds; i++) {
            int roundGuess = roundGuesses.get(i);

            boolean didWinRound = this.playRound(roundGuess);
            if(didWinRound) {
                return 0;
            }
        }

        return this.numberOfPoints;
    }

    //for testing
    int getNumberOfPrizes() {
        return numberOfPrizes;
    }

    List<Boolean> getGameSequence() {
        return gameSequence;
    }
}
