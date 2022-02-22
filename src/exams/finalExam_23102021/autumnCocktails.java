package exams.finalExam_23102021;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class autumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] ingredients = scanner.nextLine().split("\\s+");
        String[] freshness = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();

        for (String ingredient : ingredients) {
            ingredientsQueue.offer(Integer.parseInt(ingredient));
        }

        for (String fresh : freshness) {
            freshnessStack.push(Integer.parseInt(fresh));
        }

        int pearSourFreshness = 150;
        int harvestFreshness = 250;
        int appleHinnyFreshness = 300;
        int highFashion = 400;

        int pearSourCount = 0;
        int harvestCount = 0;
        int appleHinnyCount = 0;
        int highFashionCount = 0;

        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {
            int firstIngredient = ingredientsQueue.peek();
            int firstFreshness = freshnessStack.peek();

            if (firstIngredient <= 0) {
                ingredientsQueue.poll();
                continue;
            }
            if (firstFreshness <= 0) {
                freshnessStack.pop();
                continue;
            }

            if (firstIngredient * firstFreshness == pearSourFreshness) {
                pearSourCount++;
                ingredientsQueue.poll();
                freshnessStack.pop();

            } else if (firstIngredient * firstFreshness == harvestFreshness) {
                harvestCount++;
                ingredientsQueue.poll();
                freshnessStack.pop();

            } else if (firstIngredient * firstFreshness == appleHinnyFreshness) {
                appleHinnyCount++;
                ingredientsQueue.poll();
                freshnessStack.pop();

            } else if (firstIngredient * firstFreshness == highFashion) {
                highFashionCount++;
                ingredientsQueue.poll();
                freshnessStack.pop();

            } else {
                freshnessStack.pop();
                if (ingredientsQueue.size() > 0) {
                    int currentIngredient = ingredientsQueue.poll();
                    currentIngredient += 5;
                    ingredientsQueue.offer(currentIngredient);
                } else {
                    ingredientsQueue.poll();
                }
            }


        }

        Map<String, Integer> cocktailsMap = new TreeMap<>();

        cocktailsMap.put("Apple Hinny", appleHinnyCount);
        cocktailsMap.put("High Fashion", highFashionCount);
        cocktailsMap.put("Pear Sour", pearSourCount);
        cocktailsMap.put("The Harvest", harvestCount);

        int cocktailsNum = appleHinnyCount + highFashionCount + pearSourCount + harvestCount;

        if (appleHinnyCount >= 1 && highFashionCount >= 1 && pearSourCount >= 1 && harvestCount >= 1) {

            if (cocktailsNum >= 4) {
                System.out.println("It's party time! The cocktails are ready!");

                cocktailsMap.entrySet()
                        .stream()
                        .filter(e -> e.getValue() > 0)
                        .forEach(cocktail ->
                                System.out.printf(" # %s --> %d\n", cocktail.getKey(), cocktail.getValue()));
            }
        }
        if (cocktailsNum < 4) {

            System.out.println("What a pity! You didn't manage to prepare all cocktails.");

            int sum = 0;

            for (Integer i : ingredientsQueue) {
                sum += i;
            }

            if (sum > 0) {
                System.out.printf("Ingredients left: %d\n", sum);
            }


            cocktailsMap.entrySet()
                    .stream()
                    .filter(e -> e.getValue() > 0)
                    .forEach(cocktail -> System.out.printf(" # %s --> %d\n", cocktail.getKey(), cocktail.getValue()));
        }

    }
}
