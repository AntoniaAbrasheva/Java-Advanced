package exams.retakeExam_17122019;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class santaPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] materials = scanner.nextLine().split("\\s+");
        String[] magicValues = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        ArrayDeque<Integer> magicValuesQueue = new ArrayDeque<>();

        fillMaterialStack(materials,materialsStack);
        fillMagicValuesQueue(magicValues,magicValuesQueue);

        int dollCount = 0;
        int woodenTrainCount = 0;
        int teddyBearCount = 0;
        int bicycleCount = 0;


        while (!materialsStack.isEmpty() && !magicValuesQueue.isEmpty()) {

            int currentMaterial = materialsStack.peek();
            int currentMagicValue = magicValuesQueue.peek();

            if (currentMaterial == 0 || currentMagicValue == 0) {
                if (currentMaterial == 0) {
                    materialsStack.pop();
                }
                if (currentMagicValue == 0) {
                    magicValuesQueue.poll();
                }
                continue;
            }
            int multiplication = currentMagicValue * currentMaterial;


            switch (multiplication) {
                case 150:
                    dollCount++;
                    materialsStack.pop();
                    magicValuesQueue.poll();
                    break;
                case 250:
                    woodenTrainCount++;
                    materialsStack.pop();
                    magicValuesQueue.poll();
                    break;
                case 300:
                    teddyBearCount++;
                    materialsStack.pop();
                    magicValuesQueue.poll();
                    break;
                case 400:
                    bicycleCount++;
                    materialsStack.pop();
                    magicValuesQueue.poll();
                    break;
                default:
                    if (multiplication < 0) {
                        int sum = currentMaterial + currentMagicValue;
                        materialsStack.pop();
                        magicValuesQueue.poll();
                        materialsStack.push(sum);
                    }else if (multiplication > 0) {
                        magicValuesQueue.poll();
                        int increasedValue = materialsStack.pop() + 15;
                        materialsStack.push(increasedValue);
                    }
            }

        }
        if ((dollCount >= 1 && woodenTrainCount >= 1) || (teddyBearCount >= 1 && bicycleCount >= 1)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materialsStack.isEmpty()) {
           String output = materialsStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Materials left: " + output);
        }
        if (!magicValuesQueue.isEmpty()) {
            String output = magicValuesQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Magic left: " + output);
        }
        if (bicycleCount >= 1) {
            System.out.println("Bicycle: " + bicycleCount);
        }
        if (dollCount >= 1) {
            System.out.println("Doll: " + dollCount);
        }
        if (teddyBearCount >= 1) {
            System.out.println("Teddy bear: " +teddyBearCount);
        }
        if (woodenTrainCount >= 1) {
            System.out.println("Wooden train: " + woodenTrainCount);
        }
    }

    private static void fillMagicValuesQueue(String[] magicValues, ArrayDeque<Integer> magicValuesQueue) {
        for (String magicValue : magicValues) {
            magicValuesQueue.offer(Integer.parseInt(magicValue));

        }
    }

    private static void fillMaterialStack(String[] materials, ArrayDeque<Integer> materialsStack) {
        for (String material : materials) {
            materialsStack.push(Integer.parseInt(material));
        }
    }
}
