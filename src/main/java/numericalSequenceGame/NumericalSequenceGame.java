package numericalSequenceGame;

import interfaces.IPlay;
import util.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumericalSequenceGame implements IPlay {
    private Converter converter = new Converter();
    private Scanner scanner = new Scanner(System.in);
    private String results;

    private short sequenceLength;
    private short minimumSquare;
    private short startedNumber;

    public void Play() throws Exception {
        GetTheData();
        CalculateTheResult();
        PrintResult();
    }

    private void GetTheData() {
        boolean isCorrect = false;
        while (!isCorrect) {
            System.out.println("Please enter a sequence length: ");
            sequenceLength = converter.TryToShot(scanner.nextLine());
            if (sequenceLength <= 0) {
                System.out.println("Incorrect data entered.\nLength should be more than 0.\nTry again.");
            } else {
                isCorrect = true;
            }
        }
        isCorrect = false;
        while (!isCorrect) {
            System.out.println("Please enter minimum square");
            minimumSquare = converter.TryToShot(scanner.nextLine());
            if (minimumSquare <= 0) {
                System.out.println("Incorrect data entered.\nSquare should be more than 0.\nTry again.");
            } else {
                isCorrect = true;
            }
        }
    }

    private void CalculateTheResult() {
        startedNumber = (short) Math.sqrt(minimumSquare);
        List<String> resultsList = new ArrayList<String>();

        for (int i = 0; i < sequenceLength; i++) {
            startedNumber++;
            resultsList.add(String.valueOf(startedNumber));
        }
        results = String.join(",", resultsList);
    }

    private void PrintResult() {
        System.out.println(results);
    }
}