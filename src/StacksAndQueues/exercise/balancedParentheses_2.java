package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class balancedParentheses_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> openBracketsStack = new ArrayDeque<>();
        ArrayDeque<Character> closedBracketsQueue = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {

            char currentBracket = input.charAt(i);

            if (currentBracket == '{' || currentBracket == '[' || currentBracket == '(') {

                openBracketsStack.push(currentBracket);

            } else if (currentBracket == '}' || currentBracket == ']' || currentBracket == ')') {
                closedBracketsQueue.offer(currentBracket);
            }
        }

            boolean areBalanced = false;

            if (openBracketsStack.size() != closedBracketsQueue.size()) {
                System.out.println("NO");
            } else {
                while (!openBracketsStack.isEmpty() && !closedBracketsQueue.isEmpty()) {

                    char lastOpen = openBracketsStack.pop();
                    char firstClosed = closedBracketsQueue.poll();

                    if (firstClosed == '}' && lastOpen == '{') {
                        areBalanced = true;
                    } else if (firstClosed == ']' && lastOpen == '[') {
                        areBalanced = true;
                    } else if (firstClosed == ')' && lastOpen == '(') {
                        areBalanced = true;
                    } else {
                        areBalanced = false;
                    }
                }
                System.out.println(areBalanced ? "YES" : "NO");
            }



        }

    }

