package StreamFilesAndDirectories.exercise;

import java.io.File;

public class getFolderSize {
    public static void main(String[] args) {

        String path = "C:\\Users\\Toni\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(path);
        File[] allFile = folder.listFiles();

        int folderSize = 0;
        for(File file : allFile) {
            folderSize += file.length();
        }

        System.out.println("Folder size: " + folderSize);
    }
}
