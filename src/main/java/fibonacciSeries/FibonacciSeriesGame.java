package fibonacciSeries;

import chessBoard.ChessBoardLengthProvider;
import interfaces.IPlay;
import org.apache.log4j.Logger;
import util.ConsoleIo;

public class FibonacciSeriesGame implements IPlay {
    final static Logger logger = Logger.getLogger(ChessBoardLengthProvider.class);

    private FibonacciSeriesDataProvider data;
    private FibonacciSeries fibonacci;
    private CalculateFibonacciSeries calculate;
    private FibonacciSeriesMenu fibonacciSeriesMenu;
    private ConsoleIo io;
    private short taskNumber;

    public FibonacciSeriesGame() {
        data = new FibonacciSeriesDataProvider();
        fibonacci = new FibonacciSeries();
        fibonacciSeriesMenu = new FibonacciSeriesMenu();
        calculate = new CalculateFibonacciSeries();
        io = new ConsoleIo();
    }

    public void play() {
        taskNumber = fibonacciSeriesMenu.menu();
        fibonacci = data.getData(taskNumber);
        calculate.calculateSeries(fibonacci, taskNumber);
        printGameResult(fibonacci, taskNumber);
    }

    private void printGameResult(FibonacciSeries fibonacci, short taskNumber) {
        logger.debug("Print game result.");
        switch (taskNumber) {
            case 1: {
                for (Long element : fibonacci.getFibonacciList()) {
                    if (element >= fibonacci.getMinValue() && element <= fibonacci.getMaxValue()) {
                        io.print(element + " ");
                    }
                }
                io.printLine("\n");
                break;
            }
            case 2: {
                for (Long element : fibonacci.getFibonacciList()) {
                    String tempString = element.toString();
                    if (tempString.length() == fibonacci.getNumberLength()) {
                        io.printLine(element + " ");
                    }
                }
                io.printLine("\n");
                break;
            }
        }
    }
}