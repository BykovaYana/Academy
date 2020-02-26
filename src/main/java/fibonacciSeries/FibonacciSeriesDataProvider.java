package fibonacciSeries;

import util.ConsoleIo;
import util.Converter;

public class FibonacciSeriesDataProvider {
    private FibonacciSeries fibonacci;
    private Converter converter;
    private ConsoleIo io;

    public FibonacciSeriesDataProvider() {
        fibonacci = new FibonacciSeries();
        converter = new Converter();
        io = new ConsoleIo();
    }

    public FibonacciSeries getData(short taskNumber) {
        if (taskNumber == 1) {
            io.printLine("Please enter minimal value:");
            fibonacci.setMinValue(converter.tryToLong(io.readString()));
            io.printLine("Please enter max value:");
            fibonacci.setMaxValue(converter.tryToLong(io.readString()));
        } else {
            io.printLine("Please enter number length:");
            fibonacci.setNumberLength(converter.tryToShort(io.readString()));
        }
        return fibonacci;
    }
}