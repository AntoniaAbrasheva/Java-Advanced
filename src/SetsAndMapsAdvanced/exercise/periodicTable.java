package SetsAndMapsAdvanced.exercise;

import java.util.*;

public class periodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> uniqueElements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] chemicalElements = scanner.nextLine().split("\\s+");

            //начин1
            for (String element : chemicalElements) {
                uniqueElements.add(element);
            }

            // начин 2
            //  Collections.addAll(Arrays.asList(chemicalElements), uniqueElements);

            // начин 3

            //  uniqueElements.addAll(Arrays.asList(chemicalElements));



        }
        uniqueElements.forEach(e -> System.out.print(e + " "));

    }
}
