package fibonacciSeries;

public class CalculateFibonacciSeries {
    public void CalculateSeries(FibonacciSeries fibonacci, short taskNumber) {
        while (IsContinue(fibonacci, taskNumber)){
            fibonacci.AddNextValue();
        }
    }

    public boolean IsContinue(FibonacciSeries fibonacci, short taskNumber) {
        int size = fibonacci.getFibonacciList().size();
        if (taskNumber == 1) {
            return fibonacci.getFibonacciList().get(size - 1) <= fibonacci.getMaxValue();
        } else {
            String lastElement = fibonacci.getFibonacciList().get(size - 1).toString();
            return lastElement.length() <= fibonacci.getNumberLength();
        }
    }
}
