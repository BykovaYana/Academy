package fibonacciSeries;

public class CalculateFibonacciSeries {
    public void calculateSeries(FibonacciSeries fibonacci, short taskNumber) {
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
