package SetsAndMapsAdvanced.exercise;

import org.w3c.dom.ls.LSOutput;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class setsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split("\\s+");

        int firstSetElements = Integer.parseInt(elements[0]);
        int secondSetElements = Integer.parseInt(elements[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetElements; i++) {
            int firstNumbers = Integer.parseInt(scanner.nextLine());

            firstSet.add(firstNumbers);

        }

        for (int i = 0; i < secondSetElements; i++) {

            int secondNumbers = Integer.parseInt(scanner.nextLine());

            secondSet.add(secondNumbers);

        }


       firstSet.retainAll(secondSet);

        firstSet.forEach(e -> System.out.print(e + " "));
    }
}
