package SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class aMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> resourcesMap = new LinkedHashMap<>();


        while (true) {

            String resource = scanner.nextLine();

            if (resource.equals("stop")) {
                break;
            }

            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resourcesMap.containsKey(resource)) {
                resourcesMap.put(resource,quantity);
            } else {
                 int currentQuantity = resourcesMap.get(resource);
                 resourcesMap.put(resource,currentQuantity + quantity);
            }

        }

        resourcesMap.entrySet()
                .forEach(e -> System.out.printf("%s -> %d\n",e.getKey(),e.getValue()));
    }
}
