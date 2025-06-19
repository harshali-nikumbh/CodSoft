import java.util.*;

public class GuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int score = 0, rounds = 0;
        boolean again = true;

        System.out.println("----- GUESS THE NUMBER -----");

        while (again) {
            int num = r.nextInt(100) + 1;
            int chances = 5;
            boolean found = false;

            rounds++;
            System.out.println("\nRound " + rounds + " starts now!");
            System.out.println("Guess a number from 1 to 100. You have 5 tries.");

            while (chances > 0) {
                System.out.print("Enter guess: ");
                int g = sc.nextInt();

                if (g == num) {
                    System.out.println("Correct! You got it");
                    score++;
                    found = true;
                    break;
                } else if (g < num) {
                    System.out.println("Too low");
                } else {
                    System.out.println("Too high");
                }

                chances--;
                if (chances > 0)
                    System.out.println("Tries left: " + chances);
                else
                    System.out.println("No tries left! Number was: " + num);
            }

            System.out.print("Play again? (y/n): ");
            String ch = sc.next();
            again = ch.equalsIgnoreCase("y");
        }

        System.out.println("\nGame Over!");
        System.out.println("Rounds played: " + rounds);
        System.out.println("Your score: " + score);
        sc.close();
    }
}
