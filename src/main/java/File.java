public class File {
    private String filePath;
    private String fileName;
    private String stringForReplace;
    private String stringForSearch;

    public String getFilePath() {
        return filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStringForReplace() {
        return stringForReplace;
    }

    public void setStringForReplace(String stringForReplace) {
        this.stringForReplace = stringForReplace;
    }

    public void setStringForSearch(String stringForSearch) {
        this.stringForSearch = stringForSearch;
    }

    public String getStringForSearch() {
        return stringForSearch;
    }
}
