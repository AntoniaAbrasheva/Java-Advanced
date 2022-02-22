package StreamFilesAndDirectories.exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class lineNumbers {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Toni\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));

        List<String> lines = Files.readAllLines(Path.of(path));

        PrintWriter writer = new PrintWriter("outputLineNumbers.txt");

        int number = 1;

        for (String line : lines) {

            writer.println(number + ". " + line);
            number++;

        }
        writer.close();
    }
}
