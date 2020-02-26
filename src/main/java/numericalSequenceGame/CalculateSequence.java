package numericalSequenceGame;

import chessBoard.ChessBoardLengthProvider;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CalculateSequence {
    final static Logger logger = Logger.getLogger(ChessBoardLengthProvider.class);

    private short startedNumber;

    public String calculateTheResult(NumericalSequence numericalSequence) {
        logger.debug("Calculate the result.");
        startedNumber = (short)Math.sqrt(numericalSequence.getMinimumSquare());
        List<String> resultsList = new ArrayList<String>();

        for (int i = 0; i < numericalSequence.getSequenceLength(); i++) {
            startedNumber++;
            resultsList.add(String.valueOf(startedNumber));
        }
        return String.join(",", resultsList);
    }
}
