package chessBoard;

import interfaces.IPlay;

public class ChessBoard implements IPlay {
    private GetChessBoardData data = new GetChessBoardData();
    private short boardLength;


    public void Play() {
        boardLength = data.GetTheBoardLength();
        PrintBoard();
    }

    private void PrintBoard() {
        for (int i = 1; i <= boardLength; i++) {
            for (int j = 1; j <= boardLength; j++) {
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