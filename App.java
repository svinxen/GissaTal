import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static int getNumber() {
        double randomNumber = (Math.random() * 100 + 1);
        return (int) randomNumber;
    }

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = getNumber();
        
        int timesPlayed = 0;

        boolean play = true;

        boolean isUserInputCorrect = false;

        while (play == true) {

            isUserInputCorrect = false;

            System.out.println("Guess a number between 1 and 100" /* + number */);

            getNumber();
            
            try {

                int userGuess = scanner.nextInt();
                scanner.nextLine();
                if (number > userGuess) {
                    System.out.println("Your guess it too low!");
                    timesPlayed++;
                } else if (number < userGuess) {
                    System.out.println("Your guess is too high!");
                    timesPlayed++;
                } else if (number == userGuess) {
                    timesPlayed++;
                    System.out.println("Your guess is correct! It took you " + timesPlayed
                            + " tries to figure out the right number.");

                    while (!isUserInputCorrect) {

                        System.out.println("Would you like to play again? Yes/No");
                        String answer = scanner.nextLine();

                        if (answer.equalsIgnoreCase("yes")) {
                            getNumber();
                            number = getNumber();
                            timesPlayed = 0;
                            isUserInputCorrect = true;
                            continue;
                        } else if (answer.equalsIgnoreCase("no")) {
                            System.out.println("Okay, thanks for playing!");
                            play = false;
                            isUserInputCorrect = true;
                            break;
                        } else {
                            System.out.println("Answer input incorrectly, please answer in Yes/No format.");
                            continue;
                        }
                    }
                }
            }

            catch (InputMismatchException e) {

                System.out.println("Answer input incorrectly, please input your guess in integers");
                scanner.nextLine();
            }
        }

        scanner.close();

    }
}
