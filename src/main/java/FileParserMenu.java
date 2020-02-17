import java.util.Scanner;

public class FileParserMenu implements IPlay {
    private Converter converter = new Converter();
    private Scanner scanner = new Scanner(System.in);
    private FileParser fileParser = new FileParser();
    private GetDataForFileParser getData = new GetDataForFileParser();
    private boolean isReplace;
    private int countNumberOfOccurrences;

    public void Play() throws Exception {
        Menu();
    }

    public void Menu() {
        boolean isTaskSelected = false;
        System.out.println("Please select a option.");
        System.out.println("1.Count the number of occurrences of a line in a text file.\n2.Replace the string with another in the specified file.");
        short taskNumber = 0;
        while (!isTaskSelected) {
            taskNumber = converter.TryToShot(scanner.nextLine());
            if (taskNumber < 1 || taskNumber > 2) {
                System.out.println("Sorry you have only 2 option try again.");
            } else {
                isTaskSelected = true;
            }
        }
        TaskCall(taskNumber);
        PrintResult(taskNumber);
    }

    private void TaskCall(short taskNumber) {
                switch (taskNumber) {
            case 1: {
                isReplace = false;
                countNumberOfOccurrences = fileParser.CountNumberOfOccurrences(getData.GetData(isReplace));
                break;
            }
            case 2: {
                isReplace = true;
                fileParser.ReplaceString(getData.GetData(isReplace));
                break;
            }
        }
    }

    private void PrintResult(short taskNumber)
    {
        switch (taskNumber) {
            case 1: {
                System.out.printf("The number of occurrences of string '%s' is %d\n", getData.file.getStringForSearch(), countNumberOfOccurrences);
                break;
            }
            case 2: {
                System.out.println("File was changed.");
                break;
            }
        }
    }
}