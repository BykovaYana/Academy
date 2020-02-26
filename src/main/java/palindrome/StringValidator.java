package palindrome;

import chessBoard.ChessBoardLengthProvider;
import org.apache.log4j.Logger;

public class StringValidator {
    final static Logger logger = Logger.getLogger(ChessBoardLengthProvider.class);

    public Palindrome getPalindromes(Palindrome palindrome) {
        logger.debug("Get string for checking.");
        int stringLength = palindrome.getInputString().length();
        for (int i = 0; i < stringLength; i++) {
            for (int j = i + 2; j <= stringLength; j++) {
                if (isPalindrome(palindrome.getInputString().substring(i, j))) {
                    palindrome.getPalindromes().add(palindrome.getInputString().substring(i, j));
                }
            }
        }
        return palindrome;
    }

    private boolean isPalindrome(String inputString) {
        logger.debug("Check is string palindrome.");
        String revertedString = new StringBuilder(inputString).reverse().toString();
        return (inputString.equals(revertedString));
    }
}
