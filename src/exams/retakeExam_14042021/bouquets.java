package exams.retakeExam_14042021;

import java.util.ArrayDeque;
import java.util.Scanner;

public class bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tulips = scanner.nextLine().split(",\\s+");
        String[] daffodils = scanner.nextLine().split(",\\s+");

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();

        for (String tulip : tulips) {
            tulipsStack.push(Integer.parseInt(tulip));
        }
        for (String daffodil : daffodils) {
            daffodilsQueue.offer(Integer.parseInt(daffodil));
        }
        int bouquetsCount = 0;
        int leftFlowers = 0;

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {

            int currentTulip = tulipsStack.peek();
            int currentDaffodil = daffodilsQueue.peek();

            int sumOfFlowers = currentTulip + currentDaffodil;

            if (sumOfFlowers == 15) {
                tulipsStack.pop();
                daffodilsQueue.poll();
                bouquetsCount++;
            }else if (sumOfFlowers > 15) {
                int reducedTulips = tulipsStack.pop();
                reducedTulips -= 2;
                tulipsStack.push(reducedTulips);

            } else  {
                leftFlowers += sumOfFlowers;
                tulipsStack.pop();
                daffodilsQueue.poll();
            }
        }



        if (leftFlowers > 0) {
            int newBouquets = leftFlowers / 15;
            bouquetsCount += newBouquets;
        }
        if (bouquetsCount >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!\n",bouquetsCount);
        }else {
            System.out.printf("You failed... You need more %d bouquets.\n", 5 - bouquetsCount);
        }
    }
}
