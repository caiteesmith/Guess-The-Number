/* Program: Guess The Number - Main method
Author: Caitlyn Smith
Course: CISS 111-300
Email: c-smith54@hvcc.edu

RULES OF THE GAME
1. Player chooses a number between 1 and 10
2. Program has to guess that number using these parameters:
   - Correct, Higher, Lower
3. Program should loop until correct
 */

public class SmithCaitlyn_program02 {
    public static void main(String[] args) {
        // Create the instance of the Game class
        Game guess = new Game();
        guess.gameStart();

        System.out.println("- Correct guesses: " + guess.getCorrect());
        System.out.println("- High guesses: " + guess.getTooHigh());
        System.out.println("- Low guesses: " + guess.getTooLow());
    }
}