import java.util.Scanner;

public class SteamLevelCalculator {

    private static final int BASE_XP = 100;  // Base XP required for each steam level

    // Static method without arguments to get user input for current steam level
    private static int getCurrentSteamLevel() {
        Scanner scanner = new Scanner(System.in);

        int currentLevel;
        do {
            System.out.print("Enter your current Steam level: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid number for your current Steam level.");
                scanner.next();
            }
            currentLevel = scanner.nextInt();
        } while (currentLevel < 1);

        return currentLevel;
    }

    // Static method without arguments to get user input for desired steam level
    private static int getDesiredSteamLevel() {
        Scanner scanner = new Scanner(System.in);

        int desiredLevel;
        do {
            System.out.print("Enter your desired Steam level: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid number for your desired Steam level.");
                scanner.next();
            }
            desiredLevel = scanner.nextInt();
        } while (desiredLevel < 1);

        return desiredLevel;
    }

    // Non-static method with arguments to calculate the XP needed to reach the desired level
    private int calculateXPNeeded(int currentLevel, int desiredLevel) {
        int totalXPNeeded = 0;

        for (int level = currentLevel + 1; level <= desiredLevel; level++) {
            totalXPNeeded += BASE_XP * level;
        }

        return totalXPNeeded;
    }

    // Non-static method without arguments to display the result to the user
    private void displayResult(int currentLevel, int desiredLevel, int xpNeeded) {
        System.out.println("To reach Steam level " + desiredLevel + " from level " + currentLevel +
                ", you need " + xpNeeded + " XP.");
    }

    // Main method
    public static void main(String[] args) {
        SteamLevelCalculator calculator = new SteamLevelCalculator();

        int currentLevel = getCurrentSteamLevel();
        int desiredLevel = getDesiredSteamLevel();

        int xpNeeded = calculator.calculateXPNeeded(currentLevel, desiredLevel);

        calculator.displayResult(currentLevel, desiredLevel, xpNeeded);
    }
}