package StreamFilesAndDirectories.exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class countCharacterTypes {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Toni\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedReader br = new BufferedReader(new FileReader(path));

        BufferedWriter bw = new BufferedWriter(new FileWriter("outputCharacterType.txt"));

        List<String> lines = Files.readAllLines(Path.of(path));
        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuationCount = 0;

        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                char currentSymbol = line.charAt(i);

                if (currentSymbol == ' ') {
                    continue;
                }

                if (currentSymbol == 'a' || currentSymbol == 'e'
                        || currentSymbol == 'u' || currentSymbol == 'i' || currentSymbol == 'o') {

                    vowelsCount++;
                } else if (currentSymbol == '.' || currentSymbol == ','
                        || currentSymbol == '?' || currentSymbol == '!') {
                    punctuationCount++;
                } else {
                    consonantsCount++;
                }

            }

        }
        bw.write("Vowels: " + vowelsCount);
        bw.newLine();
        bw.write("Consonants: " + consonantsCount);
        bw.newLine();
        bw.write("Punctuation: " + punctuationCount);
        bw.newLine();

        bw.close();
    }
}
