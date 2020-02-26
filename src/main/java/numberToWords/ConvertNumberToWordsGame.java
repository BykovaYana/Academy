package numberToWords;

import chessBoard.ChessBoardLengthProvider;
import interfaces.IPlay;
import org.apache.log4j.Logger;
import util.ConsoleIo;

public class ConvertNumberToWordsGame implements IPlay {
    final static Logger logger = Logger.getLogger(ChessBoardLengthProvider.class);

    private NumberToWords numberToWords;
    private ConsoleIo io;

    public ConvertNumberToWordsGame() {
        numberToWords = new NumberToWords();
        io = new ConsoleIo();
    }

    public void play() throws Exception {
        io.printLine("Enter the number");
        io.printLine(numberToWords.convert(io.readLong()));
    }
}
