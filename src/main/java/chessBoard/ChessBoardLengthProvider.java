package chessBoard;

import util.Converter;

import java.util.Scanner;

public class ChessBoardLengthProvider {
    private Converter converter = new Converter();
    private Scanner scanner = new Scanner(System.in);

    public short GetLength() {
        System.out.println("Board length should be more that 2 and less than 100.\nPlease, enter a board length: ");
        boolean isCorrectValue = false;
        short boardLength = 0;
        while (!isCorrectValue) {
            boardLength = converter.TryToShort(scanner.next());
            if (boardLength < 2 || boardLength > 100) {
                System.out.println("Opps. Incorrect value. Try again.");
            } else {
                isCorrectValue = true;
            }
        }
        return boardLength;
    }
}