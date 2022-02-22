package exams.retakeExam_19082020;

import java.util.ArrayDeque;
import java.util.Scanner;

public class flowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lilies = scanner.nextLine().split(",\\s+");
        String[] roses = scanner.nextLine().split(",\\s+");

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();

        fillLiliesStack(lilies,liliesStack);
        fillRosesQueue(roses,rosesQueue);

        int wreathsCount = 0;
        int leftFlowers = 0;

        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {

            int currentLily = liliesStack.peek();
            int currentRose = rosesQueue.peek();
            int sumFlowers = currentLily + currentRose;

            if (sumFlowers == 15) {
                wreathsCount++;
                liliesStack.pop();
                rosesQueue.poll();
            } else if (sumFlowers > 15) {
                int liliesToRemove = liliesStack.pop();
                liliesToRemove -= 2;
                liliesStack.push(liliesToRemove);
            } else {
               leftFlowers += sumFlowers;
               liliesStack.pop();
               rosesQueue.poll();

            }
        }
        if (leftFlowers > 0) {
            int newBouquets = leftFlowers / 15;
            wreathsCount += newBouquets;
        }

        if (wreathsCount >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!\n",wreathsCount);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!\n",5 - wreathsCount);
        }

    }

    private static void fillRosesQueue(String[] roses, ArrayDeque<Integer> rosesQueue) {
        for (String rose : roses) {
            rosesQueue.offer(Integer.parseInt(rose));
        }
    }

    private static void fillLiliesStack(String[] lilies, ArrayDeque<Integer> liliesStack) {

        for (String lilie : lilies) {
            liliesStack.push(Integer.parseInt(lilie));
        }
    }
}
