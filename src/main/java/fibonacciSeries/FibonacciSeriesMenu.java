package fibonacciSeries;

import util.ConsoleIo;
import util.Converter;
import util.Menu;

public class FibonacciSeriesMenu {
    private Converter converter;
    private ConsoleIo io;

    public FibonacciSeriesMenu() {
        converter = new Converter();
        io = new ConsoleIo();
    }

    public short menu() {
        boolean isTaskSelected = false;
        String menuOption = "1.Print numbers in the range.\n2.Print numbers whose length is equal to the given number.";
        short taskNumber = 0;
        io.printLine("Please select a option.");
        io.printLine(menuOption);
        while (!isTaskSelected) {
            taskNumber = converter.tryToShort(io.readString());
            isTaskSelected = Menu.isCorrectTaskSelected(menuOption, taskNumber);
        }
        return taskNumber;
    }
}