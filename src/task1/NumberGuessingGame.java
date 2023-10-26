package task1;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min=1;
        int max=100;
        int maxAttemps=100;
        int score=0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("****************************************");
        while (true) {
        	int systemGuess=random.nextInt(max-min+1)+min;
            int totalTries= 0;

            System.out.println("I've selected a random number between "+min+" and " +max+"\n"+"Try to guess it.");

            for (int i=1;i<=maxAttemps;i++)
            {
                System.out.print("Attempt "+i+": Enter your guess: ");
                int userGuess= scanner.nextInt();
                totalTries++;

                if (userGuess<systemGuess) 
                {
                    System.out.println("Try a higher number.");
                } else 
                	if (userGuess>systemGuess) 
                	{
                    System.out.println("Try a lower number.");
                } 
                	else 
                	{
                    System.out.println("Congratulations! You guessed the number " +systemGuess+ " in " +totalTries+" tries.");
                    score++;
                    break;
                }
            }

            System.out.print("Are You want to Play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("You Palyed"+score+" rounds. Thanks for playing!");
                break;
            }
        }

        scanner.close();
    }
}