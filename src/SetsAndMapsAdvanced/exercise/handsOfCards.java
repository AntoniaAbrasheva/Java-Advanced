package SetsAndMapsAdvanced.exercise;

import java.util.*;

public class handsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> players = new LinkedHashMap<>();


        while (!input.equals("JOKER")) {
            String playerName = input.split(":\\s+")[0];
            String cards = input.split(":\\s+")[1];

            String[] cardsArr = cards.split(", ");

            Set<String> cardsSet = new HashSet<>();
            cardsSet.addAll(Arrays.asList(cardsArr));

            if (!players.containsKey(playerName)) {
                players.put(playerName,cardsSet);
            } else {
                Set<String> currentCards = players.get(playerName);
                currentCards.addAll(cardsSet);
                players.put(playerName,currentCards);
            }

            input = scanner.nextLine();
        }
        players.entrySet()
                .forEach(entry -> {
                    String name = entry.getKey();
                    Set<String> cards = entry.getValue();
                    int points = getsCardsPoints(cards);
                    System.out.printf("%s: %d\n",name,points);
                });
    }

    private static int getsCardsPoints(Set<String> cards) {
        Map<Character,Integer> symbolsValues = getSymbolsValues();

        int sumPoints = 0;
        for(String card :cards) {


            int points = 0;
            if (card.startsWith("10")) {
                char type = card.charAt(2);

                points = 10 * symbolsValues.get(type);
            } else {
                char power = card.charAt(0);
                char type = card.charAt(1);

                points = symbolsValues.get(power) * symbolsValues.get(type);

            }
            sumPoints += points;
        }
        return sumPoints;
    }

    private static Map<Character, Integer> getSymbolsValues() {
        Map<Character,Integer> characterValuesMap = new HashMap<>();

        characterValuesMap.put('2',2);
        characterValuesMap.put('3',3);
        characterValuesMap.put('4',4);
        characterValuesMap.put('5',5);
        characterValuesMap.put('6',6);
        characterValuesMap.put('7',7);
        characterValuesMap.put('8',8);
        characterValuesMap.put('9',9);
        characterValuesMap.put('J',11);
        characterValuesMap.put('Q',12);
        characterValuesMap.put('K',13);
        characterValuesMap.put('A',14);
        characterValuesMap.put('S',4);
        characterValuesMap.put('H',3);
        characterValuesMap.put('D',2);
        characterValuesMap.put('C',1);

        return characterValuesMap;










    }
}
