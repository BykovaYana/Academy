package fibonacciSeries;

import util.Converter;
import util.Menu;

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
        String menuOption = "1.Print numbers in the range.\n2.Print numbers whose length is equal to the given number.";
        short taskNumber = 0;
        System.out.println("Please select a option.");
        System.out.println(menuOption);
        while (!isTaskSelected) {
            taskNumber = converter.tryToShort(scanner.nextLine());
            isTaskSelected = Menu.isCorrectTaskSelected(menuOption, taskNumber);
        }
        return taskNumber;
    }
}