package fileTask;

import util.FileUtil;

public class FileParser {

    public int countNumberOfOccurrences(File file) {
        String fileContent = FileUtil.readFromFile(file.getFilePath(), file.getFileName());
        String []array = fileContent.split(file.getStringForSearch());
        int count = array.length -1;
        return count;
    }

    public void replaceString(File file) {
        String fileContent = FileUtil.readFromFile(file.getFilePath(), file.getFileName());
        String newContent = fileContent.replaceAll(file.getStringForSearch(), file.getStringForReplace());
        FileUtil.writeToFile(file.getFilePath(), file.getFileName(), newContent, false);
    }
}