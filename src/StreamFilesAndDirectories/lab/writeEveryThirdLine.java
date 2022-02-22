package StreamFilesAndDirectories.lab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class writeEveryThirdLine {
    public static void main(String[] args) throws FileNotFoundException {

        String pathIn = "C:\\Users\\Toni\\Documents\\GitHub\\Java Advanced\\src\\StreamsAndFiles\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\Toni\\Documents\\GitHub\\Java Advanced\\src\\StreamsAndFiles\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        Scanner in = new Scanner(new FileReader(pathIn));
        PrintWriter out = new PrintWriter(new PrintWriter(pathOut));

       int count = 1;

       String line = in.nextLine();

       while (in.hasNextLine()) {

           if (count % 3 == 0) {
               out.println(line);
           }
           count++;

           line = in.nextLine();

       }
       out.close();

    }
}
