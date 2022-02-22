package exams.finalExam_28062020;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bombEffects = scanner.nextLine().split(",\\s+");
        String[] bombCasing = scanner.nextLine().split(",\\s+");

        ArrayDeque<Integer> bombEffectQueue = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasingStack = new ArrayDeque<>();

        fillBombEffectsQueue(bombEffects,bombEffectQueue);
        fillBombCastingStack(bombCasing,bombCasingStack);

        int daturaBombsCount = 0;
        int cherryBombsCount = 0;
        int smokeDecoyBombsCount = 0;
        boolean isFilledBombPouch = false;


        while (!bombEffectQueue.isEmpty() && !bombCasingStack.isEmpty()) {

            if (daturaBombsCount >= 3 && cherryBombsCount >= 3 && smokeDecoyBombsCount >= 3) {
                isFilledBombPouch = true;
                break;
            }
            int currentBombEffect = bombEffectQueue.peek();
            int currentBombCasting = bombCasingStack.peek();
            int sum = currentBombEffect + currentBombCasting;

            switch (sum) {
                case 40:
                    bombEffectQueue.poll();
                    bombCasingStack.pop();
                    daturaBombsCount++;

                    break;
                case 60:
                    bombEffectQueue.poll();
                    bombCasingStack.pop();
                    cherryBombsCount++;

                    break;
                case 120:
                    bombEffectQueue.poll();
                    bombCasingStack.pop();
                    smokeDecoyBombsCount++;

                    break;
                default:
                    int reducedBombCasting = bombCasingStack.pop();
                    reducedBombCasting -= 5;
                    bombCasingStack.push(reducedBombCasting);
            }
        }
        if (isFilledBombPouch) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffectQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            String output = bombEffectQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Bomb Effects: " + output);
        }

        if (bombCasingStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            String output = bombCasingStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Bomb Casings: " + output);
        }

        Map<String,Integer> bombMap = new TreeMap<>();
        bombMap.put("Cherry Bombs",cherryBombsCount);
        bombMap.put("Datura Bombs",daturaBombsCount);
        bombMap.put("Smoke Decoy Bombs",smokeDecoyBombsCount);

        bombMap.entrySet().forEach(bomb -> System.out.printf("%s: %d\n",bomb.getKey(),bomb.getValue()));

    }

    private static void fillBombCastingStack(String[] bombCasing, ArrayDeque<Integer> bombCasingStack) {
        for (String bomb : bombCasing) {
            bombCasingStack.push(Integer.parseInt(bomb));

        }
    }

    private static void fillBombEffectsQueue(String[] bombEffects, ArrayDeque<Integer> bombEffectQueue) {
        for (String bomb : bombEffects) {
            bombEffectQueue.offer(Integer.parseInt(bomb));
        }
    }
}
