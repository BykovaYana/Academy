package palindrome;

import chessBoard.ChessBoardLengthProvider;
import interfaces.IPlay;
import org.apache.log4j.Logger;
import util.ConsoleIo;

public class PalindromeGame implements IPlay {
    final static Logger logger = Logger.getLogger(ChessBoardLengthProvider.class);

    private PalindromeDataProvider dataProvider;
    private Palindrome palindrome;
    private StringValidator validator;
    private ConsoleIo io;

    public PalindromeGame() {
        io = new ConsoleIo();
        dataProvider = new PalindromeDataProvider();
        palindrome = new Palindrome();
        validator = new StringValidator();
    }

    public void play() {
        palindrome = dataProvider.getData();
        validator.getPalindromes(palindrome);
        printGameResult();
    }

    private void printGameResult() {
        logger.debug("Print game result.");
        if (palindrome.getPalindromes().isEmpty()) {
            io.printLine("Palindromes not found.");
        } else {
            for (String palindrome : palindrome.getPalindromes()) {
                io.print(palindrome + " ");
            }
            io.printLine("\n");
        }
    }
}