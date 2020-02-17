package fileTask;

import util.Converter;

import java.util.Scanner;

public class FileParserMenu  {
    private Converter converter;
    private Scanner scanner;

    public FileParserMenu() {
        converter = new Converter();
        scanner = new Scanner(System.in);
    }

    public short Menu() {
        boolean isTaskSelected = false;
        System.out.println("Please select a option.");
        System.out.println("1.Count the number of occurrences of a line in a text file.\n2.Replace the string with another in the specified file.");
        short taskNumber = 0;
        while (!isTaskSelected) {
            taskNumber = converter.TryToShort(scanner.nextLine());
            if (taskNumber < 1 || taskNumber > 2) {
                System.out.println("Sorry you have only 2 option try again.");
            } else {
                isTaskSelected = true;
            }
        }
        return taskNumber;
    }
}