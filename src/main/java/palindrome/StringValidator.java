package palindrome;

public class StringValidator {
    public Palindrome GetPalindromes(Palindrome palindrome) {
        int stringLength = palindrome.getInputString().length();
        for (int i = 0; i < stringLength; i++) {
            for (int j = i + 2; j <= stringLength; j++) {
                if (IsPalindrome(palindrome.getInputString().substring(i, j))) {
                    palindrome.getPalindromes().add(palindrome.getInputString().substring(i, j));
                }
            }
        }
        return palindrome;
    }

    private boolean IsPalindrome(String inputString) {
        String revertedString = new StringBuilder(inputString).reverse().toString();
        return (inputString.equals(revertedString));
    }
}
