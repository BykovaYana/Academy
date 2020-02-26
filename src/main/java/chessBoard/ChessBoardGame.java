package chessBoard;

import interfaces.IPlay;
import org.apache.log4j.Logger;
import util.ConsoleIo;

public class ChessBoardGame implements IPlay {
    final static Logger logger = Logger.getLogger(ChessBoardGame.class);
    private ChessBoardLengthProvider lengthProvider;
    private ConsoleIo io;
    private short boardLength;

    public ChessBoardGame() {
        lengthProvider = new ChessBoardLengthProvider();
        io = new ConsoleIo();
    }

    public void play() {
        boardLength = lengthProvider.getLength();
        printBoard();
    }

    private void printBoard() {
        logger.debug("Print board.");
        for (int i = 1; i <= boardLength; i++) {
            for (int j = 1; j <= boardLength; j++) {
                if ((i % 2 != 0 && j % 2 == 0) || (i % 2 == 0 && j % 2 != 0)) {
                    io.printLine("*");
                } else {
                    io.printLine(" ");
                }
            }
            System.out.print("\n");
        }
    }
}