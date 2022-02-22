package FunctionalProgramming.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class findEvenOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int startNum = Integer.parseInt(input[0]);
        int endNum = Integer.parseInt(input[1]);

        String typeNumber = scanner.nextLine();

        Predicate<Integer> evenOrOddPredicate;

        List<Integer> numbersList = new ArrayList<>();

        for (int i = startNum; i <= endNum; i++) {
            numbersList.add(i);

        }


             if (typeNumber.equals("even")) {
                evenOrOddPredicate = e -> e % 2 == 0;

            } else {
                evenOrOddPredicate = e -> e % 2 != 0;

            }


           numbersList =  numbersList.stream()
                    .filter(evenOrOddPredicate)
                    .collect(Collectors.toList());

             for (int n : numbersList) {
                 System.out.print(n + " ");
             }

        }
    }

