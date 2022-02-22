package exams.retakeExam_18082021;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class pastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] liquids = scanner.nextLine().split("\\s+");
        String[] ingredients = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        for (String liquid : liquids) {
            liquidsQueue.offer(Integer.parseInt(liquid));
        }
        for (String ingredient : ingredients) {
            ingredientsStack.push(Integer.parseInt(ingredient));
        }

        int biscuitCount = 0;
        int cakeCount = 0;
        int pastryCount = 0;
        int pieCount = 0;
        int cookedFoodCount = 0;

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {

            int currentLiquid = liquidsQueue.peek();
            int currentIngredient = ingredientsStack.peek();

            int sumOfLiquidAndIngredient = currentIngredient + currentLiquid;

            switch (sumOfLiquidAndIngredient) {
                case 25:
                    biscuitCount++;
                    cookedFoodCount++;
                    liquidsQueue.poll();
                    ingredientsStack.pop();

                    break;
                case 50:
                    cakeCount++;
                    cookedFoodCount++;;
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 75 :
                    pastryCount++;
                    cookedFoodCount++;
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 100 :
                    pieCount++;
                    cookedFoodCount++;
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                default:
                    liquidsQueue.poll();
                    int updatedIngredient = ingredientsStack.pop();
                    updatedIngredient += 3;
                    ingredientsStack.push(updatedIngredient);
            }
        }

        Map<String,Integer> pastryMap = new LinkedHashMap<>();
        pastryMap.put("Biscuit",biscuitCount);
        pastryMap.put("Cake",cakeCount);
        pastryMap.put("Pie",pieCount);
        pastryMap.put("Pastry",pastryCount);

        if (biscuitCount >= 1 && cakeCount >= 1 && pastryCount >= 1 && pieCount >= 1) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            String liquidOutput = liquidsQueue.stream()
                                  .map(String::valueOf)
                                  .collect(Collectors.joining(", "));
            System.out.println(liquidOutput);

        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");

            String ingredientOutput = ingredientsStack.stream()
                                      .map(String::valueOf)
                                      .collect(Collectors.joining(", "));
            System.out.println(ingredientOutput);
        }
        pastryMap.entrySet().forEach(pastry -> System.out.printf("%s: %d\n",pastry.getKey(),pastry.getValue()));
    }
}
