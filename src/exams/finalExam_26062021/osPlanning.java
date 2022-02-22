package exams.finalExam_26062021;

import java.util.ArrayDeque;
import java.util.Scanner;

public class osPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tasks = scanner.nextLine().split(",\\s+");
        String[] threads = scanner.nextLine().split("\\s+");
        int killedValueOfTask = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();

        for (String task : tasks) {
            tasksStack.push(Integer.parseInt(task));
        }
        for (String thread : threads) {
            threadsQueue.offer(Integer.parseInt(thread));
        }

        while (!tasksStack.isEmpty() && !threadsQueue.isEmpty()) {

            int currentTask = tasksStack.peek();
            int currentThread = threadsQueue.peek();

            if (currentThread >= currentTask) {
                if (currentTask == killedValueOfTask) {
                    break;
                } else {
                    threadsQueue.poll();
                    tasksStack.pop();
                }
            } else  {
                if (currentTask == killedValueOfTask) {
                    break;
                } else {
                    threadsQueue.poll();
                }
            }
        }

        System.out.printf("Thread with value %d killed task %d\n",threadsQueue.peek(),tasksStack.peek());
        for (int thread : threadsQueue) {
            System.out.print(thread + " ");
        }
    }
}
