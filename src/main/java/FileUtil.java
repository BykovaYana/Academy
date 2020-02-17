import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileUtil {
    public static String ReadFromFile(String filePath, String fileName)
    {
        String data= "";
        try {
            File file = new File(filePath, fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data = data + scanner.nextLine()+ "\n";
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        return data;
    }

    public static void WriteToFile( String filePath, String fileName, String content, boolean isAppend)
    {
        String fullPath = filePath + fileName;
        try{
        FileWriter fileWriter = new FileWriter(fullPath, isAppend);
        fileWriter.write(content);
        fileWriter.close();
        }catch (IOException e)
        {
            System.out.println("Something go wrong.");
            e.printStackTrace();
        }
    }

    public static boolean IsFileExist(String filePath, String fileName)
    {
        File file = new File(filePath, fileName);
        if (!file.exists())
        {
            System.out.println("File not found.");
        }
        return file.exists();
    }
}
