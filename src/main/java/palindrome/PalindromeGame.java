package palindrome;

import interfaces.IPlay;

public class PalindromeGame implements IPlay {
    private PalindromeDataProvider dataProvider = new PalindromeDataProvider();
    private Palindrome palindrome = new Palindrome();
    private StringValidator validator = new StringValidator();

    public void play() {
        palindrome = dataProvider.getData();
        validator.getPalindromes(palindrome);
        printGameResult();
    }

    private void printGameResult() {
        if (palindrome.getPalindromes().isEmpty()) {
            System.out.println("Palindromes not found.");
        } else {
            for (String palindrome : palindrome.getPalindromes()) {
                System.out.print(palindrome + " ");
            }
            System.out.println("\n");
        }
    }

}
