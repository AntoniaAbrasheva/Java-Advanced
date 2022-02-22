package DefiningClasses.exercise.catLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Cat> catMap = new HashMap<>();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String breed = data[0];
            String name = data[1];
            double size = Double.parseDouble(data[2]);

            Cat cat = new Cat(breed, name, size);
            catMap.put(name, new Cat(breed, name, size));


            input = scanner.nextLine();
        }

        String searchedCat = scanner.nextLine();

        Cat foundCat = catMap.get(searchedCat);
        System.out.println(foundCat);
    }
}
