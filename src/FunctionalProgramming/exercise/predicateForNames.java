package FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class predicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> predicateForName = name -> name.length() <= length;

        List<String> namesList = Arrays.stream(names)
                .filter(predicateForName)
                .collect(Collectors.toList());

        namesList.forEach(System.out::println);

    }
}
