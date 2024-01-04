import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {

        // Variables for number game logic
        int guessedNumber = 0;
        int totalAttemptsPerRound = 8;
        int totalRoundsPlayed = 1;
        boolean playAgain = true;
        int totalRoundsWon = 0;
        String userChoice = new String();
        Scanner scan = new Scanner(System.in);

        // Welcome message and game instructions
        System.out.println("Welcome!! To The Number Guessing Game");
        System.out.println("The Number Is Between 1 and 100.\n");

        while (playAgain) {

            // Generate a random number between 1 and 100
            int randomNumber = ((int) (Math.random() * 100) + 1);

            // Start a new round
            System.out.println("Round - " + totalRoundsPlayed + ":");
            System.out.println("You Have " + totalAttemptsPerRound + " Attempts.\n");
            int totalAttemptsPerRoundLeft = totalAttemptsPerRound;

            // Loop for taking guesses in a round
            for (int i = 0; i < totalAttemptsPerRound + 1; i++) {
                System.out.print("Guess The Number: ");
                guessedNumber = scan.nextInt();
                totalAttemptsPerRoundLeft--;
                System.out.println();

                // Check the guessed number
                if (totalAttemptsPerRoundLeft > 0) {
                    if (guessedNumber > randomNumber) {
                        System.out.println("Go Lower!!");
                    } else if (guessedNumber < randomNumber) {
                        System.out.println("Go Higher!!");
                    } else {
                        System.out.println("Congratulations!! Your Guess is Correct.");
                        totalRoundsWon++;
                        break;
                    }
                    System.out.println("Attempts Left: " + totalAttemptsPerRoundLeft + "\n");
                } else {
                    System.out.println("Sorry!! No More Attempts Left.\n");
                    break;
                }
            }

            // Ask if the user wants to play again
            System.out.print("Do You Want To Play Again?(yes/no): ");
            userChoice = scan.next();
            if (userChoice.toUpperCase().equals("YES")) {
                System.out.println();
                playAgain = true;
                totalRoundsPlayed++;
            } else if (userChoice.toUpperCase().equals("NO")) {
                playAgain = false;
                System.out.println();

                // Display game results
                System.out.println("Total Rounds Played: " + totalRoundsPlayed);
                if (totalRoundsWon == 0) {
                    System.out.println("Sorry!! You Did Not Win Any Round.");
                } else {
                    System.out.println("Your Total Score is " + ((totalRoundsWon / totalRoundsPlayed) * 100)
                            + " Out Of 100.");
                }
            } else {
                break;
            }
        }

        scan.close();
    }
}