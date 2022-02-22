package SetsAndMapsAdvanced.lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class parkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> parkingSet = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] data = input.split(",\\s+");

            String direction = data[0];
            String carNumber = data[1];

            switch (direction) {
                case "IN":
                    parkingSet.add(carNumber);

                    break;
                case "OUT":
                    parkingSet.remove(carNumber);

                    break;
            }

            input = scanner.nextLine();
        }

        if (parkingSet.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parkingSet.stream().forEach(e -> System.out.println(e));
        }
    }
}
