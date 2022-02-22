package FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class customComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberLIst = Arrays.stream(scanner.nextLine().split("\\s+"))
                                   .map(Integer::parseInt)
                                   .collect(Collectors.toList());

        // 0 => първият елемент = втория
        // 1 => първият елемент > втория
         // -1 => първият елемент < втория

        //sorted (0) -> не разменя двата елемента
        //sorted(1) -> разменя елементите
        //sorted(-1) -> не разменя елементите

        Comparator<Integer> comparator = ((first,second) -> {

            if (first % 2 == 0 && second % 2 != 0) {
                return -1;
            } else if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            } else {
                return first.compareTo(second);
            }
        });

        numberLIst.stream().sorted(comparator).forEach(e -> System.out.print(e + " "));


    }
}
