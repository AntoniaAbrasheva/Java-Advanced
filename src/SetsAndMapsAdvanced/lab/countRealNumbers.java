package SetsAndMapsAdvanced.lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class countRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double,Integer> numbersMap = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {


            if (!numbersMap.containsKey(numbers[i])) {
                numbersMap.put(numbers[i],1);

            } else {
                int currentValue = numbersMap.get(numbers[i]);
                currentValue++;
                numbersMap.put(numbers[i],currentValue);
            }

        }
        for (Double number : numbersMap.keySet()) {

            System.out.printf("%.1f -> %d\n",number,numbersMap.get(number));

        }
    }
}
