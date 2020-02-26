package fileTask;

import chessBoard.ChessBoardLengthProvider;
import org.apache.log4j.Logger;
import util.ConsoleIo;
import util.Converter;
import util.Menu;

public class FileParserMenu {
    final static Logger logger = Logger.getLogger(ChessBoardLengthProvider.class);

    private Converter converter;
    private ConsoleIo io;

    public FileParserMenu() {
        converter = new Converter();
        io = new ConsoleIo();
    }

    public short menu() {
        logger.debug("File parser menu.");
        boolean isTaskSelected = false;
        String menuOptions = "1.Count the number of occurrences of a line in a text file.\n" +
                "2.Replace the string with another in the specified file.";
        System.out.println("Please select a option.");
        System.out.println(menuOptions);
        short taskNumber = 0;
        while (!isTaskSelected) {
            taskNumber = converter.tryToShort(io.readString());
            isTaskSelected = Menu.isCorrectTaskSelected(menuOptions, taskNumber);
        }
        logger.debug("Selected task " + taskNumber);
        return taskNumber;
    }
}