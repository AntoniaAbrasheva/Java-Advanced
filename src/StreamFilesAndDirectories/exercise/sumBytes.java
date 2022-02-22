package StreamFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class sumBytes {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Toni\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));

        long sum = 0;

        String line = br.readLine();

        while (line != null) {

            for (int i = 0; i < line.length(); i++) {

                char currentSymbol = line.charAt(i);
                sum += currentSymbol;

            }


            line = br.readLine();
        }
        System.out.println(sum);
    }
}
