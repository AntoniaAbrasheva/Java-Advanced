package StreamFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class copyBytes {
    public static void main(String[] args) throws IOException {

        String pathIn = "C:\\Users\\Toni\\Documents\\GitHub\\Java Advanced\\src\\StreamsAndFiles\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\Toni\\Documents\\GitHub\\Java Advanced\\src\\StreamsAndFiles\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        FileInputStream in = new FileInputStream(pathIn);
        FileOutputStream out = new FileOutputStream(pathOut);

        int oneByte = in.read();

        while (oneByte >= 0) {

            if (oneByte == 32 || oneByte == 10) {

                out.write((char)oneByte);
            } else {

                String digits = String.valueOf(oneByte);

                for (int i = 0; i < digits.length(); i++) {

                    out.write(digits.charAt(i));

                }
            }


            oneByte = in.read();
        }
    }
}
