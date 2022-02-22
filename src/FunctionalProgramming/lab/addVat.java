package FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class addVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Double,Double> addVat = e -> 1.2 * e;

        List<Double> pricesList = Arrays.stream(scanner.nextLine().split(",\\s+"))
                                   .map(Double::parseDouble)
                                   .map(addVat)
                                   .collect(Collectors.toList());

        System.out.println("Prices with VAT:");

        Consumer<Double> printer = e -> System.out.printf("%.2f\n",e);
        pricesList.forEach(printer);


    }
}
