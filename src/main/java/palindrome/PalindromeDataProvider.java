package palindrome;

import java.util.Scanner;

public class PalindromeDataProvider {
    private Palindrome palindrome = new Palindrome();
    private Scanner scanner = new Scanner(System.in);

    public Palindrome GetData() {
        boolean isCorrectData = false;
        while (!isCorrectData) {
            System.out.println("Please enter string. String length should be more than 1.");
            String input = scanner.next();
            if (input.length() >= 2) {
                palindrome.setInputString(input);
                isCorrectData = true;
            } else {
                System.out.println("Incorrect entered data. Please try again.");
            }
        }
        return palindrome;
    }
}