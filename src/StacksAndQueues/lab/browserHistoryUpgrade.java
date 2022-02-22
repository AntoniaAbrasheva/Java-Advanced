package StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class browserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> browserURL = new ArrayDeque<>();
        ArrayDeque<String> forwardURL = new ArrayDeque<>();



        while (!input.equals("Home")) {



            if (input.equals("back")) {

                if (browserURL.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forwardURL.addFirst(browserURL.peek());
                    browserURL.pop();
                    System.out.println(browserURL.peek());
                }

            } else if (input.equals("forward")) {

                if (forwardURL.size() < 1) {

                    System.out.println("no next URLs");
                } else {
                    System.out.println(forwardURL.peek());
                    browserURL.push(forwardURL.pop());
                }

            } else {
                System.out.println(input);
                browserURL.push(input);
                forwardURL.clear();
            }

            input = scanner.nextLine();
        }
    }
}
