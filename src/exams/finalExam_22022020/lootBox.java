package exams.finalExam_22022020;

import java.util.ArrayDeque;
import java.util.Scanner;

public class lootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstBox = scanner.nextLine().split("\\s+");
        String[] secondBox = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        fillFirstBox(firstBox,firstBoxQueue);
        fillSecondBox(secondBox,secondBoxStack);

        int claimedItems = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int currentFirstBox = firstBoxQueue.peek();
            int currentSecondBox = secondBoxStack.peek();

            int sum = currentFirstBox + currentSecondBox;

            if (sum % 2 == 0) {
                claimedItems += sum;
                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                int removedItem = secondBoxStack.pop();
                firstBoxQueue.offer(removedItem);
            }
        }
        if (firstBoxQueue.isEmpty()) {
            System.out.println(	"First lootbox is empty");
        }
        if (secondBoxStack.isEmpty()) {
            System.out.println(	"Second lootbox is empty");
        }

        if (claimedItems >= 100) {
            System.out.printf("Your loot was epic! Value: %d",claimedItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d",claimedItems);
        }
    }

    private static void fillSecondBox(String[] secondBox, ArrayDeque<Integer> secondBoxStack) {
        for (String box : secondBox) {
            secondBoxStack.push(Integer.parseInt(box));

        }
    }

    private static void fillFirstBox(String[] firstBox, ArrayDeque<Integer> firstBoxQueue) {

        for (String box : firstBox) {
            firstBoxQueue.offer(Integer.parseInt(box));

        }
    }
}
