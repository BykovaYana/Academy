package fileTask;

import chessBoard.ChessBoardLengthProvider;
import org.apache.log4j.Logger;
import util.ConsoleIo;
import util.FileUtil;

public class FileDataProvider {
    final static Logger logger = Logger.getLogger(ChessBoardLengthProvider.class);

    public File file;
    private ConsoleIo io;

    public FileDataProvider() {
        io = new ConsoleIo();
        file = new File();
    }

    public File getData(short taskNumber) {
        logger.debug("Get file data.");
        do {
            io.printLine("Please enter file path:");
            file.setFilePath(io.readString());
            io.printLine("Please enter file name:");
            file.setFileName(io.readString());
        } while (!FileUtil.IsFileExist(file.getFilePath(), file.getFileName()));
        io.printLine("Please enter string for searching.");
        file.setStringForSearch(io.readString());
        if (taskNumber == 2) {
            io.printLine("Please enter string for replace.");
            file.setStringForReplace(io.readString());
        }
        return file;
    }
}