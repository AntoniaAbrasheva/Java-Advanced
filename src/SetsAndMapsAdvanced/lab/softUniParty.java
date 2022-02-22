package SetsAndMapsAdvanced.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class softUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vipPeopleSet = new TreeSet<>();
        Set<String> regularPeopleSet = new TreeSet<>();

        String input = scanner.nextLine();
        while (!input.equals("PARTY")) {

            if (input.length() == 8) {

                if (input.startsWith("1") || input.startsWith("2") || input.startsWith("3") ||
                        input.startsWith("4") || input.startsWith("5") || input.startsWith("6") ||
                        input.startsWith("7") || input.startsWith("8") || input.startsWith("9")) {

                    vipPeopleSet.add(input);
                } else {
                    regularPeopleSet.add(input);
                }
            }


            input = scanner.nextLine();
        }

        String guestsCame = scanner.nextLine();
        while (!guestsCame.equals("END")) {

            if (vipPeopleSet.contains(guestsCame)) {
                vipPeopleSet.remove(guestsCame);
            }
            if (regularPeopleSet.contains(guestsCame)) {
                regularPeopleSet.remove(guestsCame);
            }

            guestsCame = scanner.nextLine();
        }

        int count = vipPeopleSet.size() + regularPeopleSet.size();

        System.out.println(count);
        vipPeopleSet.forEach(System.out::println);
        regularPeopleSet.forEach(System.out::println);

    }

}
