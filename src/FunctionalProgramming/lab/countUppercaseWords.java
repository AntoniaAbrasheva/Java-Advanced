package FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class countUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> uppercasePredicate = word -> Character.isUpperCase(word.charAt(0));

        List<String> uppercaseWords = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .filter(uppercasePredicate)
                            .collect(Collectors.toList());

        System.out.println(uppercaseWords.size());

        Consumer<String> printer = System.out::println;

        uppercaseWords.forEach(printer);


    }
}
