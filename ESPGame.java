/*Class: CMSC203 CRN 22355
 Program: Assignment 1
 Instructor: David Kuijt
 Summary of Description: Write a program that tests your ESP (extrasensory perception).
 Due Date: 09/22/2024 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student Name: Yevhenii Dementiev
*/
	
	
package espgame;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class ESPGame {

    // Define constants for colors
    final static String COLOR_1 = "Black";
    final static String COLOR_2 = "White";
    final static String COLOR_3 = "Gray";
    final static String COLOR_4 = "Silver";
    final static String COLOR_5 = "Maroon";
    final static String COLOR_6 = "Red";
    final static String COLOR_7 = "Purple";
    final static String COLOR_8 = "Fuchsia";
    final static String COLOR_9 = "Green";
    final static String COLOR_10 = "Lime";
    final static String COLOR_11 = "Olive";
    final static String COLOR_12 = "Yellow";
    final static String COLOR_13 = "Navy";
    final static String COLOR_14 = "Blue";
    final static String COLOR_15 = "Teal";
    final static String COLOR_16 = "Aqua";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Ask for the filename
        System.out.print("Enter the filename: ");
        String fileName = scanner.nextLine();

        // Create a File object
        File colorFile = new File(fileName);

        // Check if the file exists
        if (colorFile.exists()) {
            // Open the file and read colors
            Scanner fileScanner = new Scanner(colorFile);

            System.out.println("There are sixteen colors from the file:");
            int count = 1;
            while (fileScanner.hasNextLine()) {
                String color = fileScanner.nextLine();
                System.out.println(count + " " + color);
                count++;
            }

            int correctGuesses = 0;

            // Repeat the game 3 times
            for (int round = 1; round <= 3; round++) {
                System.out.println("\nRound " + round);
                System.out.println("I am thinking of a color.");
                System.out.println("Is it one of the colors listed above?");

                // Randomly select a color number between 1 and 16
                int selectedColorNumber = random.nextInt(16) + 1;
                String selectedColor = "";

                // Assign the selected color based on the random number
                switch (selectedColorNumber) {
                    case 1: selectedColor = COLOR_1; break;
                    case 2: selectedColor = COLOR_2; break;
                    case 3: selectedColor = COLOR_3; break;
                    case 4: selectedColor = COLOR_4; break;
                    case 5: selectedColor = COLOR_5; break;
                    case 6: selectedColor = COLOR_6; break;
                    case 7: selectedColor = COLOR_7; break;
                    case 8: selectedColor = COLOR_8; break;
                    case 9: selectedColor = COLOR_9; break;
                    case 10: selectedColor = COLOR_10; break;
                    case 11: selectedColor = COLOR_11; break;
                    case 12: selectedColor = COLOR_12; break;
                    case 13: selectedColor = COLOR_13; break;
                    case 14: selectedColor = COLOR_14; break;
                    case 15: selectedColor = COLOR_15; break;
                    case 16: selectedColor = COLOR_16; break;
                }

                // Ask the user for their guess
                System.out.print("Enter your guess: ");
                String userGuess = scanner.nextLine();

                // Computer's selection
                System.out.println("I was thinking of " + selectedColor + ".");

                // Check if the user's guess is correct
                if (userGuess.equals(selectedColor)) {
                    System.out.println("You guessed correctly!");
                    correctGuesses++;
                } else {
                    System.out.println("Wrong guess.");
                }
            }

            // Display the number of correct guesses
            System.out.println("\nGame Over");
            System.out.println("You guessed " + correctGuesses + " out of 3 colors correctly.");

            // Ask for additional user information
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Describe yourself: ");
            String description = scanner.nextLine();
            System.out.print("Due Date (MM/DD): ");
            String dueDate = scanner.nextLine();

            // Display user input
            System.out.println("\nUser Name: " + name);
            System.out.println("User Description: " + description);
            System.out.println("Due Date: " + dueDate);

            // Close the file scanner
            fileScanner.close();
        } else {
            // If file does not exist
            System.out.println("File not found. Please check the filename and try again.");
        }

        // Close the main scanner
        scanner.close();
    }
}