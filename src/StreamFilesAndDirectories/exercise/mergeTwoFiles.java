package StreamFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class mergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String inputOnePath = "C:\\Users\\Toni\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inputTwoPath = "C:\\Users\\Toni\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        PrintWriter writer = new PrintWriter(new FileWriter("mergeFiles.txt"));

        List<String> linesFileOne = Files.readAllLines(Path.of(inputOnePath));
        linesFileOne.forEach(line -> writer.println(line));

        List<String> linesFileTwo = Files.readAllLines(Path.of(inputTwoPath));
        linesFileTwo.forEach(line -> writer.println(line));

        writer.close();

    }
}
