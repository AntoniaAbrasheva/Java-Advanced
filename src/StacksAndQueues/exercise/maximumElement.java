package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class maximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String[] commandLine = scanner.nextLine().split(" ");
            int command = Integer.parseInt(commandLine[0]);

            switch (command) {
                case 1 :
                    int numberToPush = Integer.parseInt(commandLine[1]);

                    numbersStack.push(numberToPush);
                    break;
                case 2 :
                    if (!numbersStack.isEmpty()) {
                        numbersStack.pop();
                    }
                    break;
                case 3 :
                    System.out.println(Collections.max(numbersStack));
                    break;
            }

        }
    }
}
