package FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class sumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");

        Function<String,Integer> parser = e -> Integer.parseInt(e);

       List<Integer> numberList =  Arrays.stream(input)
                                   .map(parser)
                                    .collect(Collectors.toList());

        System.out.printf("Count = %d\n",numberList.size());

               int sum = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.printf("Sum = %d",sum);



    }
}
