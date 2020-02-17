package fileTask;

import interfaces.IPlay;

public class FileParserGame implements IPlay {
    private  FileParserMenu parserMenu;
    private FileDataProvider dataProvider;
    private File file;
    private FileParser fileParser;
    private int numberOfOccurrences;
    private short taskNumber;

    public FileParserGame() {
        parserMenu = new FileParserMenu();
        dataProvider = new FileDataProvider();
        fileParser = new FileParser();
        file = new File();
    }

    public void Play() {
        taskNumber = parserMenu.Menu();
        file = dataProvider.GetData(taskNumber);
        if (taskNumber == 1) {
            numberOfOccurrences = fileParser.CountNumberOfOccurrences(file);
        } else {
            fileParser.ReplaceString(file);
        }
        PrintResult(taskNumber);
    }

    private void PrintResult(short taskNumber) {
        switch (taskNumber) {
            case 1: {
                System.out.printf("The number of occurrences of string '%s' is %d\n", file.getStringForSearch(), numberOfOccurrences);
                break;
            }
            case 2: {
                System.out.println("fileTask.File was changed.");
                break;
            }
        }
    }

}
