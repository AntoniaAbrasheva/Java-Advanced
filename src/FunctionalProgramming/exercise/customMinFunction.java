package FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class customMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


       List<Integer> numList = Arrays.stream(scanner.nextLine().split("\\s+"))
                              .map(Integer::parseInt)
                              .collect(Collectors.toList());

       Function<List<Integer>,Integer> minNumber = Collections::min;

        System.out.println(minNumber.apply(numList));


    }
}
