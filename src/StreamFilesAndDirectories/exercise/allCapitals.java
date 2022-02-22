package StreamFilesAndDirectories.exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

public class allCapitals {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Toni\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedReader br = new BufferedReader(new FileReader(path));

        List<String> lines = Files.readAllLines(Path.of(path));

        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

        for (String line : lines) {

            bw.write(line.toUpperCase(Locale.ROOT));
            bw.newLine();

        }

        bw.close();
    }
}
