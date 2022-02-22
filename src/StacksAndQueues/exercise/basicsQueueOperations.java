package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class basicsQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(scanner.nextInt());

        }

        for (int i = 1; i <= s; i++) {
            queue.poll();

        }

        if (queue.contains(x)) {
            System.out.println("true");
        } else {

            if (!queue.isEmpty()) {
                System.out.println(Collections.min(queue));

            } else {
                System.out.println(0);
            }
        }
    }
}
