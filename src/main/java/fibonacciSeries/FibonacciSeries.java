package fibonacciSeries;

import java.util.ArrayList;
import java.util.Arrays;

public class FibonacciSeries {
    private ArrayList<Long> fibonacciList;
    private long minValue;
    private long maxValue;
    private short numberLength;

    public FibonacciSeries() {
        fibonacciList = new ArrayList<Long>(Arrays.asList(0l, 1l));
    }

    public long getMinValue() {
        return minValue;
    }

    public long getMaxValue() {
        return maxValue;
    }

    public short getNumberLength() {
        return numberLength;
    }

    public void setMinValue(long minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(long maxValue) {
        this.maxValue = maxValue;
    }

    public void setNumberLength(short numberLength) {
        this.numberLength = numberLength;
    }

    public ArrayList<Long> getFibonacciList() {
        return fibonacciList;
    }

    public void addNextValue() {
        int size = fibonacciList.size();
        Long nextElement = fibonacciList.get(size - 1) + fibonacciList.get(size - 2);
        fibonacciList.add(nextElement);
    }
}
