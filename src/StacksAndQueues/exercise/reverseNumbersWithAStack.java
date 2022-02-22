package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class reverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {

            stack.push(numbers[i]);

        }

        // int stackSize = stack.size();
        //for (int i = 0; i < stackSize; i++) {
          //  System.out.print(stack.pop() + " ");

        //}

        for (int num : stack) {
            System.out.print(num + " ");
        }
    }
}
