package fibonacciSeries;

import chessBoard.ChessBoardLengthProvider;
import org.apache.log4j.Logger;

public class CalculateFibonacciSeries {
    final static Logger logger = Logger.getLogger(ChessBoardLengthProvider.class);

    public void calculateSeries(FibonacciSeries fibonacci, short taskNumber) {
        logger.debug("Calculate series.");
        while (isContinue(fibonacci, taskNumber)){
            fibonacci.addNextValue();
        }
    }

    public boolean isContinue(FibonacciSeries fibonacci, short taskNumber) {
        int size = fibonacci.getFibonacciList().size();
        if (taskNumber == 1) {
            return fibonacci.getFibonacciList().get(size - 1) <= fibonacci.getMaxValue();
        } else {
            String lastElement = fibonacci.getFibonacciList().get(size - 1).toString();
            return lastElement.length() <= fibonacci.getNumberLength();
        }
    }
}
