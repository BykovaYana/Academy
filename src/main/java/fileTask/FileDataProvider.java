package fileTask;

import util.FileUtil;
import java.util.Scanner;

public class FileDataProvider {
    public File file;
    private Scanner scanner;

    public FileDataProvider() {
        file = new File();
        scanner = new Scanner(System.in);
    }

    public File GetData(short taskNumber) {
        do {
            System.out.println("Please enter file path:");
            file.setFilePath(scanner.next());
            System.out.println("Please enter file name:");
            file.setFileName(scanner.next());
        } while (!FileUtil.IsFileExist(file.getFilePath(), file.getFileName()));
        System.out.println("Please enter string for searching.");
        file.setStringForSearch(scanner.next());
        if (taskNumber == 2) {
            System.out.println("Please enter string for replace.");
            file.setStringForReplace(scanner.next());
        }
        return file;
    }
}