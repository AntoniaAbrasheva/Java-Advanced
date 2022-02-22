package SetsAndMapsAdvanced.lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class voinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (int i = 0; i < 50; i++) {

            if (firstPlayer.isEmpty()) {
                System.out.println("Second player win!");
                return;
            }

            if (secondPlayer.isEmpty()) {
                System.out.println("First player win!");
                return;
            }

            int firstPlayerCards = firstPlayer.iterator().next();
            int secondPlayerCards = secondPlayer.iterator().next();

            firstPlayer.remove(firstPlayerCards);
            secondPlayer.remove(secondPlayerCards);

            if (firstPlayerCards > secondPlayerCards) {
                firstPlayer.add(firstPlayerCards);
                firstPlayer.add(secondPlayerCards);
            } else if (secondPlayerCards > firstPlayerCards){
                secondPlayer.add(firstPlayerCards);
                secondPlayer.add(secondPlayerCards);
            }



        }
        int firstPlayerSize = firstPlayer.size();
        int secondPlayerSize = secondPlayer.size();

        if (firstPlayerSize > secondPlayerSize) {
            System.out.println("First player win!");
        } else if (secondPlayerSize > firstPlayerSize) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
