package SetsAndMapsAdvanced.lab;

import java.util.*;

public class productShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String,Double>> data = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String[] inputParts = input.split(",\\s+");

            String shop = inputParts[0];
            String product = inputParts[1];
            double price = Double.parseDouble(inputParts[2]);


            if (!data.containsKey(shop)) {
                data.put(shop, new LinkedHashMap<>());
                data.get(shop).put(product, price);
            } else {
                Map<String,Double> currentProductMap = data.get(shop);
                currentProductMap.put(product,price);


            }

            input = scanner.nextLine();
        }

        data.entrySet()
                .forEach(e -> {
                    System.out.println(e.getKey() + "->");
                    List<String> productList = new ArrayList<>();
                    Map<String,Double> map = e.getValue();

                    for(Map.Entry<String,Double> entry : map.entrySet()) {
                        productList.add(String.format("Product: %s, Price: %.1f",entry.getKey(),entry.getValue()));
                    }
                    for (String product : productList) {
                        System.out.println(product);
                    }
                });


    }
}
