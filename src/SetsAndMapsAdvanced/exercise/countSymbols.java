package SetsAndMapsAdvanced.exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class countSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character,Integer> occurrencesMap = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {

            char currentSymbol = text.charAt(i);


            if (occurrencesMap.containsKey(currentSymbol)) {
                    int currentCount =  occurrencesMap.get(currentSymbol);
                    occurrencesMap.put(currentSymbol,currentCount + 1);
                } else {
                occurrencesMap.put(currentSymbol,1);
            }


        }

        occurrencesMap
                .entrySet()
                .forEach(e -> System.out.printf("%c: %d time/s\n",e.getKey(),e.getValue()));
    }
}
