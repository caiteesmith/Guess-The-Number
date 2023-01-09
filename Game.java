/* Program: Guess The Number - Game class
Author: Caitlyn Smith
Course: CISS 111-300
Email: c-smith54@hvcc.edu

RULES OF THE GAME
1. Player chooses a number between 1 and 10
2. Program has to guess that number using these parameters:
   - Correct, Higher, Lower
3. Program should loop until correct
 */

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Game {
    private int correct;
    private int tooLow;
    private int tooHigh;

    public void gameStart() {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        String playerName;
        int numberOfTries;
        int playerNumber;
        int i;
        int min = 1;
        int max = 10;
        int total = 0;

        // Program welcome message
        System.out.println("""
                Welcome to the Guess the Number game!
                ---------------------------------------
                In this game, you will choose a number between
                1 and 10. The program will guess your number
                until it is correct, too low, or too high.
                ---------------------------------------""");

        // Prompt the user to enter their name
        System.out.print("What is your name? ");
        playerName = scan.nextLine();

        // Prompt the user for their number
        System.out.print("Guess a number between 1 and 10: ");
        playerNumber = scan.nextInt();

        // Prompt the user if number is invalid
        if (playerNumber < 1 || playerNumber > 10) {
            System.out.print("Please enter a valid number between 1 and 10: ");
            playerNumber = scan.nextInt();
        }

        // Prompt the user for the number of games to play
        System.out.print("How many games would you like to play? ");
        numberOfTries = scan.nextInt();
        System.out.println();

        // Array for storing each random value
        int[] tryArray = new int[numberOfTries];

        // Try-catch to catch anything outside allowed parameters
        try {
            for (i = 0; i <= tryArray.length; i++) {
                /* Simulate the guess with a random number generator
                   Add calculation to not repeat numbers */
                tryArray[i] = rand.nextInt((max - min) + 1) + min;

                // Prompt the user with the guess and ask if correct, too low, too high
                System.out.print("Is the number *" + tryArray[i] + "* correct, too high, or too low? ");
                scan.nextLine();
                scan.next();
                total++;

                // If statement for a correct guess
                if (tryArray[i] == playerNumber) {
                    System.out.println("\n" + playerName + ", the program has read your mind!");
                    correct++;
                    break;
                }

                // If-else statement for low and high guesses
                if (tryArray[i] > playerNumber) {
                    tooHigh++;
                } else if (tryArray[i] < playerNumber) {
                    tooLow++;
                } else if (tryArray[i] == numberOfTries) {
                    System.out.println("\n" + playerName + ", the program couldn't guess your number.");
                } else {
                    System.out.println("Error");
                }
            }
        } catch (Exception e) {
            System.out.println("\n" + playerName + ", the program couldn't guess your number.");
        }

        System.out.println("Replay the guess values: " + Arrays.toString(tryArray));
        System.out.println("\nThe program made " + total + " guesses:");
        scan.close();
    }

    // Setters
    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public void setTooLow(int tooLow) {
        this.tooLow = tooLow;
    }

    public void setTooHigh(int tooHigh) {
        this.tooHigh = tooHigh;
    }

    // Getters
    public Integer getCorrect() {
        return this.correct;
    }

    public Integer getTooLow() {
        return this.tooLow;
    }

    public Integer getTooHigh() {
        return this.tooHigh;
    }
}