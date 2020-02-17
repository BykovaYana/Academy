import java.util.Scanner;

public class FibonacciSeriesMenu implements IPlay {
    private Converter converter = new Converter();
    private Scanner scanner = new Scanner(System.in);
    private GetFibonacciSeriesData data = new GetFibonacciSeriesData();
    private FibonacciSeries fibonacci = new FibonacciSeries();
    private CalculateFibonacciSeries calculate = new CalculateFibonacciSeries();
    private short taskNumber;


    public void Play() throws Exception {
        Menu();
        fibonacci = data.GetData(taskNumber);
        calculate.CalculateSeries(fibonacci, taskNumber);
        PrintResult(fibonacci, taskNumber);
    }

    private void Menu() {
        boolean isTaskSelected = false;
        System.out.println("Please select a option.");
        System.out.println("1.Print numbers in the range.\n2.Print numbers whose length is equal to the given number.");
        while (!isTaskSelected) {
            taskNumber = converter.TryToShot(scanner.nextLine());
            if (taskNumber < 1 || taskNumber > 2) {
                System.out.println("Sorry you have only 2 option try again.");
            } else {
                isTaskSelected = true;
            }
        }
    }

    private void PrintResult(FibonacciSeries fibonacci, short taskNumber) {
        switch (taskNumber) {
            case 1: {
                for (Long element : fibonacci.getFibonacciList()) {
                    if (element >= fibonacci.getMinValue() && element <= fibonacci.getMaxValue()) {
                        System.out.print(element + " ");
                    }
                }
                System.out.println("\n");
                break;
            }
            case 2: {
                for (Long element : fibonacci.getFibonacciList()) {
                    String tempString = element.toString();
                    if (tempString.length() == fibonacci.getNumberLength()) {
                        System.out.print(element + " ");
                    }
                }
                System.out.println("\n");
                break;
            }
        }
    }
}
