package exams.retakeExam_15122021;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] males = scanner.nextLine().split("\\s+");
        String[] females = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();

        for (int i = 0; i < males.length; i++) {
            int currentNumber = Integer.parseInt(males[i]);

            malesStack.push(currentNumber);
        }
        for (int i = 0; i < females.length; i++) {
            int currentNumber = Integer.parseInt(females[i]);

            femalesQueue.offer(currentNumber);

        }

        int matches = 0;
        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {

            int malesElement = malesStack.peek();
            int femalesElement = femalesQueue.peek();


            if (malesElement % 25 == 0 || malesElement <= 0) {
                malesStack.pop();
                continue;

            }
            if (femalesElement % 25 == 0 || femalesElement <= 0) {
                femalesQueue.poll();
                continue;

            }

            if (malesElement == femalesElement) {
                matches++;
                malesStack.pop();
                femalesQueue.poll();

            } else {
                femalesQueue.poll();

                if (!malesStack.isEmpty()) {
                    int decreaseElement = malesStack.pop();
                    decreaseElement -= 2;
                    malesStack.push(decreaseElement);
                }
            }
        }


        System.out.println("Matches: " + matches);
        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            String output = malesStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println(output);
        }

        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            String output = femalesQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println(output);
        }

    }
}

