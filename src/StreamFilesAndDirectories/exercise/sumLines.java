package StreamFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class sumLines {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Toni\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));



        List<String> lines = Files.readAllLines(Path.of(path));

        for (String line : lines) {
            int sum = 0;

            for (int i = 0; i < line.length(); i++) {

                char currentSymbol = line.charAt(i);
                sum += currentSymbol;

            }
            System.out.println(sum);
        }

    }
}
