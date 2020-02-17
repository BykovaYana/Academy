package fileTask;

import util.FileUtil;

import java.util.Scanner;

public class GetDataForFileParser {
    public File file = new File();
    private Scanner scanner = new Scanner(System.in);


    public File GetData(boolean isReplace) {
        do {
            System.out.println("Please enter file path:");
            file.setFilePath(scanner.nextLine());
            System.out.println("Please enter file name:");
            file.setFileName(scanner.nextLine());
        } while (!FileUtil.IsFileExist(file.getFilePath(), file.getFileName()));
        System.out.println("Please enter string for searching.");
        file.setStringForSearch(scanner.nextLine());
        if (isReplace) {
            System.out.println("Please enter string for replace.");
            file.setStringForReplace(scanner.nextLine());
        }
        return file;
    }
}