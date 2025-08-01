import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bestScore = Integer.MAX_VALUE;
        boolean playAgain;
        System.out.println("WELCOME TO NUMBER GUESSING GAME !\n");

        do {
            System.out.println("CHOOSE DIFFICULTY LEVEL : ");
            System.out.println("1. EASY (1-50) ");
            System.out.println("2. MEDIUM (1-100) ");
            System.out.println("3. HARD (1-200)");
            System.out.print("ENTER YOUR CHOICE (1/2/3) : ");

            int choice = sc.nextInt();
            int maxNumber = 100;
            if (choice == 1) maxNumber = 50;
            else if (choice == 2) maxNumber = 100;
            else if (choice == 3) maxNumber = 200;
            else {
                System.out.println("INVALID OPTION! SWITCHING YOU TO MEDIUM LEVEL.");
            }

            int myNumber = (int)(Math.random() * maxNumber) + 1;
            int userNumber;
            int attempts = 0;

            System.out.println("GUESS YOUR NUMBER FROM 1 TO " + maxNumber + " : ");
            while (true) {
                System.out.print("YOUR GUESS : ");
                if (sc.hasNextInt()) {
                    userNumber = sc.nextInt();
                    attempts++;

                    if (userNumber < 0) {
                        System.out.println("GAME EXITED! BETTER LUCK NEXT TIME.");
                        break;
                    } else if (userNumber == myNumber) {
                        System.out.println("🎉 CORRECT! YOU GUESSED NUMBER IN  " + attempts + " attempts.");
                        if (attempts < bestScore) {
                            bestScore = attempts;  // ✅ This was missing
                            System.out.println("🔥 NEW HIGH SCORE!");
                        } else {
                            System.out.println("YOUR BEST SCORE IS SO FAR " + bestScore + " ATTEMPTS");
                        }
                        break;
                    } else if (userNumber > myNumber) {
                        System.out.println("NUMBER TOO HIGH");
                    } else {
                        System.out.println("NUMBER TOO LOW");
                    }
                } else {
                    System.out.println("❌ PLEASE ENTER A VALID NUMBER.");
                    sc.next(); // Clear invalid input
                }
            }

            System.out.println("DO YOU WANT TO PLAY AGAIN? (YES/NO)");
            sc.nextLine(); // Clear newline from previous input
            String response = sc.nextLine().toLowerCase();
            playAgain = response.startsWith("y");

        } while (playAgain);

        System.out.println("\nTHANKS FOR PLAYING! 🎮");
        System.out.println("YOUR BEST SCORE: " + (bestScore == Integer.MAX_VALUE ? "NO HIGH SCORE YET" : bestScore + " ATTEMPTS"));
    }
}
