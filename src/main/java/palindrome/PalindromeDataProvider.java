package palindrome;

import util.ConsoleIo;

public class PalindromeDataProvider {
    private Palindrome palindrome;
    private ConsoleIo io;

    public PalindromeDataProvider() {
        palindrome = new Palindrome();
        io = new ConsoleIo();
    }

    public Palindrome getData() {
        boolean isCorrectData = false;
        while (!isCorrectData) {
            io.printLine("Please enter string. String length should be more than 1.");
            String input = io.readString();
            if (input.length() >= 2) {
                palindrome.setInputString(input);
                isCorrectData = true;
            } else {
                io.printLine("Incorrect entered data. Please try again.");
            }
        }
        return palindrome;
    }
}