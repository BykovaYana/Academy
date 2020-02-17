package numericalSequenceGame;

import util.Converter;

import java.util.Scanner;

public class GetDataForNumericalSequence {
    private Converter converter = new Converter();
    private Scanner scanner = new Scanner(System.in);
    private NumericalSequence numericalSequence = new NumericalSequence();

    public NumericalSequence GetTheData() {
        boolean isCorrect = false;
        while (!isCorrect) {
            System.out.println("Please enter a sequence length: ");
            numericalSequence.setSequenceLength(converter.TryToShot(scanner.nextLine()));
            if (numericalSequence.getSequenceLength() <= 0) {
                System.out.println("Incorrect data entered.\nLength should be more than 0.\nTry again.");
            } else {
                isCorrect = true;
            }
        }
        isCorrect = false;
        while (!isCorrect) {
            System.out.println("Please enter minimum square");
            numericalSequence.setMinimumSquare(converter.TryToShot(scanner.nextLine()));
            if (numericalSequence.getMinimumSquare() <= 0) {
                System.out.println("Incorrect data entered.\nSquare should be more than 0.\nTry again.");
            } else {
                isCorrect = true;
            }
        }

        return numericalSequence;
    }
}
