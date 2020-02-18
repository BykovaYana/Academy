package numericalSequenceGame;

import util.Converter;

import java.util.Scanner;

public class NumericalSequenceProvider {
    private Converter converter;
    private Scanner scanner;
    private NumericalSequence numericalSequence;

    public NumericalSequenceProvider() {
        scanner = new Scanner(System.in);
        converter = new Converter();
        numericalSequence = new NumericalSequence();
    }

    public NumericalSequence getTheData() {
        boolean isCorrect = false;
        while (!isCorrect) {
            System.out.println("Please enter a sequence length: ");
            numericalSequence.setSequenceLength(converter.tryToShort(scanner.next()));
            if (numericalSequence.getSequenceLength() <= 0) {
                System.out.println("Incorrect data entered.\nLength should be more than 0.\nTry again.");
            } else {
                isCorrect = true;
            }
        }
        isCorrect = false;
        while (!isCorrect) {
            System.out.println("Please enter minimum square");
            numericalSequence.setMinimumSquare(converter.tryToShort(scanner.next()));
            if (numericalSequence.getMinimumSquare() <= 0) {
                System.out.println("Incorrect data entered.\nSquare should be more than 0.\nTry again.");
            } else {
                isCorrect = true;
            }
        }
        return numericalSequence;
    }
}
