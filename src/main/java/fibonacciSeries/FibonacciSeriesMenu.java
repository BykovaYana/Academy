package fibonacciSeries;

import util.Converter;

import java.util.Scanner;

public class FibonacciSeriesMenu {
    private Converter converter;
    private Scanner scanner;

    public FibonacciSeriesMenu() {
        converter = new Converter();
        scanner = new Scanner(System.in);
    }

    public short menu() {
        boolean isTaskSelected = false;
        short taskNumber = 0;
        System.out.println("Please select a option.");
        System.out.println("1.Print numbers in the range.\n2.Print numbers whose length is equal to the given number.");
        while (!isTaskSelected) {
            taskNumber = converter.tryToShort(scanner.nextLine());
            if (taskNumber < 1 || taskNumber > 2) {
                System.out.println("Sorry you have only 2 option try again.");
            } else {
                isTaskSelected = true;
            }
        }
        return taskNumber;
    }
}