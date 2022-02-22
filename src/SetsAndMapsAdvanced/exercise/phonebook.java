package SetsAndMapsAdvanced.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();

        Map<String,String> phonebook = new HashMap<>();

        while (!data.equals("search")) {
            String name = data.split("-")[0];
            String phoneNumber = data.split("-")[1];

            phonebook.put(name,phoneNumber);

            data = scanner.nextLine();
        }

        String command = scanner.nextLine();
        while (!command.equals("stop")) {
            String name = command;

            if (phonebook.containsKey(name)) {
                System.out.println(name + " -> " + phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.\n",name);
            }

            command = scanner.nextLine();
        }
    }
}
