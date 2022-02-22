package FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class appliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split("\\s+"))
                                    .map(Integer::parseInt)
                                     .collect(Collectors.toList());

        String command = scanner.nextLine();

        Function<List<Integer>,List<Integer>> add = list -> list.stream().map(e -> e +=1).collect(Collectors.toList());
        Function<List<Integer>,List<Integer>> subtract = list -> list.stream().map(e -> e -= 1).collect(Collectors.toList());
        Function<List<Integer>,List<Integer>> multiply = list -> list.stream().map(e -> e *= 2).collect(Collectors.toList());

        Consumer<List<Integer>> printList = list -> list.forEach(e -> System.out.print(e + " "));


        while (!command.equals("end")) {

            switch (command) {

                case "add":
                   numberList = add.apply(numberList);
                    break;
                case "subtract":
                   numberList = subtract.apply(numberList);
                    break;
                case "multiply":
                   numberList =  multiply.apply(numberList);
                    break;
                case "print":
                     printList.accept(numberList);
                    System.out.println();
                    break;
            }


            command = scanner.nextLine();
        }
    }
}
