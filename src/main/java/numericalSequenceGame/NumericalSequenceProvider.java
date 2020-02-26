package numericalSequenceGame;

import util.ConsoleIo;
import util.Converter;

public class NumericalSequenceProvider {
    private Converter converter;
    private NumericalSequence numericalSequence;
    private ConsoleIo io;

    public NumericalSequenceProvider() {
        converter = new Converter();
        numericalSequence = new NumericalSequence();
        io = new ConsoleIo();
    }

    public NumericalSequence getTheData() {
        boolean isCorrect = false;
        while (!isCorrect) {
            io.printLine("Please enter a sequence length: ");
            numericalSequence.setSequenceLength(converter.tryToShort(io.readString()));
            if (numericalSequence.getSequenceLength() <= 0) {
                io.printLine("Incorrect data entered.\nLength should be more than 0.\nTry again.");
            } else {
                isCorrect = true;
            }
        }
        isCorrect = false;
        while (!isCorrect) {
            io.printLine("Please enter minimum square");
            numericalSequence.setMinimumSquare(converter.tryToShort(io.readString()));
            if (numericalSequence.getMinimumSquare() <= 0) {
                io.printLine("Incorrect data entered.\nSquare should be more than 0.\nTry again.");
            } else {
                isCorrect = true;
            }
        }
        return numericalSequence;
    }
}
