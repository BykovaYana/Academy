import java.util.Scanner;

public class GetFibonacciSeriesData {
    private FibonacciSeries fibonacci = new FibonacciSeries();
    private Scanner scanner = new Scanner(System.in);
    private Converter converter = new Converter();


    public FibonacciSeries GetData(short taskNumber) {
        if (taskNumber == 1) {
            System.out.println("Please enter minimal value:");
            fibonacci.setMinValue(converter.TryToLong(scanner.nextLine()));
            System.out.println("Please enter max value:");
            fibonacci.setMaxValue(converter.TryToLong(scanner.nextLine()));
        } else {
            System.out.println("Please enter number length;");
            fibonacci.setNumberLength(converter.TryToShot(scanner.nextLine()));
        }
        return fibonacci;
    }
}
