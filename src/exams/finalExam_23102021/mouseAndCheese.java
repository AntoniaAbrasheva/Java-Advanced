package exams.finalExam_23102021;

import java.util.Scanner;

public class mouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        int mouseRow = -1;
        int mouseColumn = -1;
        int cheeseCount = 0;

        fillMatrix(scanner,n,matrix);

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                char currentSymbol = matrix[row][column];

                if (currentSymbol == 'M') {
                    mouseRow = row;
                    mouseColumn = column;
                }

            }

        }

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            matrix[mouseRow][mouseColumn] = '-';

            switch (command) {
                case "right":
                    mouseColumn++;
                    break;
                case "left":
                    mouseColumn--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "up":
                    mouseRow--;
                    break;
            }

            if (mouseRow < 0 || mouseRow >= n || mouseColumn < 0 || mouseColumn >= n ) {
                System.out.println("Where is the mouse?");
                break;
            }
            if (matrix[mouseRow][mouseColumn] == 'c') {
                cheeseCount++;

            } else if (matrix[mouseRow][mouseColumn] == 'B') {
                continue;
            }
            matrix[mouseRow][mouseColumn] = 'M';

            command = scanner.nextLine();
        }

        if (cheeseCount >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", cheeseCount);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", 5 - cheeseCount);
        }

        printMatrix(n,matrix);

    }

    private static void printMatrix(int n, char[][] matrix) {

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                System.out.print(matrix[row][column]);

            }
            System.out.println();

        }
    }

    private static void fillMatrix(Scanner scanner, int n, char[][] matrix) {

        for (int row = 0; row < n; row++) {
            String lines = scanner.nextLine();
            char[] symbols = lines.toCharArray();
            matrix[row] = symbols;
        }
    }
}
