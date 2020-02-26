package chessBoard;

import org.apache.log4j.Logger;
import util.ConsoleIo;
import util.Converter;

public class ChessBoardLengthProvider {
    final static Logger logger = Logger.getLogger(ChessBoardLengthProvider.class);
    private ConsoleIo io;
    private Converter converter;

    public ChessBoardLengthProvider() {
        converter = new Converter();
        io = new ConsoleIo();
            }

    public short getLength() {
        logger.debug("Get a board length.");
        io.printLine("Board length should be more that 2 and less than 100.\nPlease, enter a board length: ");
        boolean isCorrectValue = false;
        short boardLength = 0;
        while (!isCorrectValue) {
            boardLength = converter.tryToShort(io.readString());
            if (boardLength < 2 || boardLength > 100) {
                io.printLine("Opps. Incorrect value. Try again.");
                logger.error("Incorrect value entered. Value is "+ boardLength);
            } else {
                isCorrectValue = true;
            }
        }
        logger.debug("A board length is " + boardLength);
        return boardLength;
    }
}