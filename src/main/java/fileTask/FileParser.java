package fileTask;

import chessBoard.ChessBoardLengthProvider;
import org.apache.log4j.Logger;
import util.FileUtil;

public class FileParser {
    final static Logger logger = Logger.getLogger(ChessBoardLengthProvider.class);

    public int countNumberOfOccurrences(File file) {
        logger.debug("Count number of occurrences");

        String fileContent = FileUtil.readFromFile(file.getFilePath(), file.getFileName());
        String []array = fileContent.split(file.getStringForSearch());
        int count = array.length -1;
        return count;
    }

    public void replaceString(File file) {
        logger.debug("Replace string.");

        String fileContent = FileUtil.readFromFile(file.getFilePath(), file.getFileName());
        String newContent = fileContent.replaceAll(file.getStringForSearch(), file.getStringForReplace());
        FileUtil.writeToFile(file.getFilePath(), file.getFileName(), newContent, false);
    }
}