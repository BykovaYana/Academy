package palindrome;

import java.util.HashSet;
import java.util.Set;

public class Palindrome {
    private String inputString;
    private Set<String> palindromes;

    public Palindrome() {
        this.palindromes = new HashSet<>();;
    }

    public String getInputString() {
        return inputString;
    }

    public Set<String> getPalindromes() {
        return palindromes;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }
}
