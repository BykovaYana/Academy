package fibonacciSeries;

import util.Converter;

import java.util.Scanner;

public class FibonacciSeriesDataProvider {
    private FibonacciSeries fibonacci;
    private Scanner scanner;
    private Converter converter;

    public FibonacciSeriesDataProvider() {
        fibonacci = new FibonacciSeries();
        scanner = new Scanner(System.in);
        converter = new Converter();
    }

    public FibonacciSeries getData(short taskNumber) {
        if (taskNumber == 1) {
            System.out.println("Please enter minimal value:");
            fibonacci.setMinValue(converter.tryToLong(scanner.nextLine()));
            System.out.println("Please enter max value:");
            fibonacci.setMaxValue(converter.tryToLong(scanner.nextLine()));
        } else {
            System.out.println("Please enter number length;");
            fibonacci.setNumberLength(converter.tryToShort(scanner.nextLine()));
        }
        return fibonacci;
    }
}
