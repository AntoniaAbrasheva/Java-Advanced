package FunctionalProgramming.lab;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class sortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      String[] numbers = scanner.nextLine().split(",\\s+");

      List<String> evenNumbers = Arrays.stream(numbers)
              .map(Integer::parseInt)
              .filter(number -> number % 2 == 0)
              .map(Object::toString)
              .collect(Collectors.toList());

        System.out.print(String.join(", ",evenNumbers));
        System.out.println();

        evenNumbers = evenNumbers.stream()
                .map(Integer::parseInt)
                .sorted(Integer::compareTo)
                .map(Object::toString)
                .collect(Collectors.toList());

        System.out.print(String.join(", ",evenNumbers));
    }
}
