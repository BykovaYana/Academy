package fibonacciSeries;

import interfaces.IPlay;

public class FibonacciSeriesGame implements IPlay {
    private FibonacciSeriesDataProvider data;
    private FibonacciSeries fibonacci;
    private CalculateFibonacciSeries calculate;
    private FibonacciSeriesMenu fibonacciSeriesMenu;
    private short taskNumber;

    public FibonacciSeriesGame() {
        data = new FibonacciSeriesDataProvider();
        fibonacci = new FibonacciSeries();
        fibonacciSeriesMenu = new FibonacciSeriesMenu();
        calculate = new CalculateFibonacciSeries();
    }

    public void Play() {
        taskNumber =fibonacciSeriesMenu.Menu();
        fibonacci = data.GetData(taskNumber);
        calculate.CalculateSeries(fibonacci, taskNumber);
        PrintGameResult(fibonacci, taskNumber);
    }

    private void PrintGameResult(FibonacciSeries fibonacci, short taskNumber) {
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
