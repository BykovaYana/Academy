package fileTask;

import util.Converter;
import util.Menu;

import java.util.Scanner;

public class FileParserMenu {
    private Converter converter;
    private Scanner scanner;

    public FileParserMenu() {
        converter = new Converter();
        scanner = new Scanner(System.in);
    }

    public short menu() {
        boolean isTaskSelected = false;
        String menuOptions = "1.Count the number of occurrences of a line in a text file.\n" +
                "2.Replace the string with another in the specified file.";
        System.out.println("Please select a option.");
        System.out.println(menuOptions);
        short taskNumber = 0;
        while (!isTaskSelected) {
            taskNumber = converter.tryToShort(scanner.nextLine());
            isTaskSelected = Menu.isCorrectTaskSelected(menuOptions, taskNumber);
        }
        return taskNumber;
    }


}