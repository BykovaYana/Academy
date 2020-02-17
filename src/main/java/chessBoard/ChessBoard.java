package chessBoard;

import interfaces.IPlay;
import util.Converter;

import java.util.Scanner;

public class ChessBoard implements IPlay {
    private short BoardLength;
    private Converter converter = new Converter();
    private Scanner scanner = new Scanner(System.in);

    public void Play() {
        GetTheBoardLength();
        PrintBoard();
    }

    private void GetTheBoardLength() {
        System.out.println("Board length should be more that 2 and less than 100.\nPlease, enter a board length: ");
        boolean isCorrectValue = false;
        while (!isCorrectValue) {
            BoardLength = converter.TryToShot(scanner.next());
            if (BoardLength < 2 || BoardLength > 100) {
                System.out.println("Opps. Incorrect value. Try again.");
            } else {
                isCorrectValue = true;
            }
        }
    }

    private void PrintBoard() {
        for (int i = 1; i <= BoardLength; i++) {
            for (int j = 1; j <= BoardLength; j++) {
                if ((i % 2 != 0 && j % 2 == 0) || (i % 2 == 0 && j % 2 != 0)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}