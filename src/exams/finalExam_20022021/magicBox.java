package exams.finalExam_20022021;

import java.util.ArrayDeque;
import java.util.Scanner;

public class magicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstBox = scanner.nextLine().split("\\s+");
        String [] secondBox = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        for (String first : firstBox) {
            firstBoxQueue.offer(Integer.parseInt(first));
        }
        for (String second : secondBox) {
            secondBoxStack.push(Integer.parseInt(second));
        }
        int claimedItems = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int currentElementOfFirstBox = firstBoxQueue.peek();
            int currentElementOfSecondBox = secondBoxStack.peek();
            int sum = currentElementOfFirstBox + currentElementOfSecondBox;

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
            System.out.println("First magic box is empty.");
        }
        if (secondBoxStack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        if (claimedItems >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d\n",claimedItems);
        } else {
            System.out.printf("Poor prey... Value: %d\n",claimedItems);
        }
    }
}
