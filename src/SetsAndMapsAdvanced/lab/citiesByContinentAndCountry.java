package SetsAndMapsAdvanced.lab;

import java.util.*;

public class citiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Map<String, List<String>>> map = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String continent = data[0];
            String country = data[1];
            String city = data[2];

            map.putIfAbsent(continent,new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country,new ArrayList<>());
            map.get(continent).get(country).add(city);

        }

        map.entrySet()
                .stream()
                .forEach(continent -> {
                    System.out.println(continent.getKey() + ":");
                    continent.getValue().entrySet()
                            .stream()
                            .forEach(country ->
                                    System.out.printf("  %s -> %s\n",country.getKey(),
                                            String.join(", ",country.getValue())));

                });
    }
}
