import java.util.InputMismatchException;
import java.util.Scanner;

public class LinearSearch {
    // Separate method for linear search functionality
    private static int linearSearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Method to get valid integer input
    private static int getValidIntInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = scanner.nextInt();
                if (input <= 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                }
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    // Method to populate array with user input
    private static int[] getArrayInput(Scanner scanner, int size) {
        int[] arr = new int[size];
        System.out.println("Enter " + size + " elements:");
        
        for (int i = 0; i < size; i++) {
            while (true) {
                try {
                    System.out.print("Element " + (i + 1) + ": ");
                    arr[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.nextLine(); // Clear the invalid input
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get array size with validation
            int size = getValidIntInput(scanner, "Enter the number of elements in the array: ");

            // Get array elements
            int[] arr = getArrayInput(scanner, size);

            // Get search target
            int target = getValidIntInput(scanner, "Enter the element to search: ");

            // Perform search
            int result = linearSearch(arr, target);

            // Display results
            if (result != -1) {
                System.out.println("\nElement " + target + " found at index: " + result);
                System.out.println("Position in array: " + (result + 1));
            } else {
                System.out.println("\nElement " + target + " not found in the array.");
            }

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}