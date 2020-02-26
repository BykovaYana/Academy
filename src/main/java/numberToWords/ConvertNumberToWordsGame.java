package numberToWords;

import interfaces.IPlay;
import util.ConsoleIo;

public class ConvertNumberToWordsGame implements IPlay {
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
