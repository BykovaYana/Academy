package palindrome;

public class StringValidator {
    public Palindrome getPalindromes(Palindrome palindrome) {
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
        String revertedString = new StringBuilder(inputString).reverse().toString();
        return (inputString.equals(revertedString));
    }
}
