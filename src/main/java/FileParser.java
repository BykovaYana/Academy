public class FileParser {

    public int CountNumberOfOccurrences(File file) {
        String fileContent = FileUtil.ReadFromFile(file.getFilePath(), file.getFileName());
        String []array = fileContent.split(file.getStringForSearch());
        int count = array.length -1;
        return count;

    }

    public void ReplaceString(File file) {
        String fileContent = FileUtil.ReadFromFile(file.getFilePath(), file.getFileName());
        String newContent = fileContent.replaceAll(file.getStringForSearch(), file.getStringForReplace());
        FileUtil.WriteToFile(file.getFilePath(), file.getFileName(), newContent, false);
    }
}