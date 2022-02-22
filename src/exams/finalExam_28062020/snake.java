package exams.finalExam_28062020;

import java.util.Scanner;

public class snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        fillMatrix(scanner,n,matrix);

        int snakeRow = -1;
        int snakeColumn = -1;
        int foodCount = 0;



        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {

                if (matrix[row][column] == 'S') {
                    snakeRow = row;
                    snakeColumn = column;
                }
            }
        }

        String commands = scanner.nextLine();
        boolean isOut = false;

        boolean isFed = false;


        while (foodCount < 10 && snakeRow >= 0 && snakeRow <= n - 1
                && snakeColumn >= 0 && snakeColumn <= n -1) {

            switch (commands) {
                case "left":
                    matrix[snakeRow][snakeColumn] = '.';
                    snakeColumn--;
                    if (snakeColumn < 0) {
                        isOut = true;
                    } else {
                        if (matrix[snakeRow][snakeColumn] == '*') {
                            foodCount++;
                            if (foodCount >= 10) {
                                isFed = true;
                            }
                            matrix[snakeRow][snakeColumn] = 'S';
                        } else if (matrix[snakeRow][snakeColumn] == 'B') {
                            matrix[snakeRow][snakeColumn] = '.';

                            for (int row = 0; row < n; row++) {
                                for (int column = 0; column < n; column++) {
                                    if (matrix[row][column] == 'B') {
                                        snakeRow = row;
                                        snakeColumn = column;
                                        matrix[snakeRow][snakeColumn] = 'S';
                                    }
                                }
                            }
                        } else {
                            matrix[snakeRow][snakeColumn] = 'S';
                        }
                    }

                    break;
                case "right":
                    matrix[snakeRow][snakeColumn] = '.';
                    snakeColumn++;
                    if (snakeColumn > n - 1) {
                        isOut = true;
                    } else {
                        if (matrix[snakeRow][snakeColumn] == '*') {
                            foodCount++;
                            if (foodCount >= 10) {
                                isFed = true;
                            }
                            matrix[snakeRow][snakeColumn] = 'S';
                        } else if (matrix[snakeRow][snakeColumn] == 'B') {
                            matrix[snakeRow][snakeColumn] = '.';

                            for (int row = 0; row < n; row++) {
                                for (int column = 0; column < n; column++) {
                                    if (matrix[row][column] == 'B') {
                                        snakeRow = row;
                                        snakeColumn = column;
                                        matrix[snakeRow][snakeColumn] = 'S';
                                    }
                                }
                            }

                        } else {
                            matrix[snakeRow][snakeColumn] = 'S';
                        }
                    }
                    break;
                case "down":
                    matrix[snakeRow][snakeColumn] = '.';
                    snakeRow++;
                    if (snakeRow > n - 1) {
                        isOut = true;
                    } else {
                        if (matrix[snakeRow][snakeColumn] == '*') {
                            foodCount++;
                            if (foodCount >= 10) {
                                isFed = true;
                            }
                            matrix[snakeRow][snakeColumn] = 'S';
                        } else if (matrix[snakeRow][snakeColumn] == 'B') {
                            matrix[snakeRow][snakeColumn] = '.';

                            for (int row = 0; row < matrix.length; row++) {
                                for (int column = 0; column < matrix.length; column++) {
                                    if (matrix[row][column] == 'B') {
                                        snakeRow = row;
                                        snakeColumn = column;
                                        matrix[snakeRow][snakeColumn] = 'S';
                                    }
                                }
                            }
                        } else {
                            matrix[snakeRow][snakeColumn] = 'S';
                        }
                    }
                    break;
                case "up":
                    matrix[snakeRow][snakeColumn] = '.';
                    snakeRow--;
                    if (snakeRow < 0) {
                        isOut = true;
                    } else {
                        if (matrix[snakeRow][snakeColumn] == '*') {
                            foodCount++;
                            if (foodCount >= 10) {
                                isFed = true;
                            }
                            matrix[snakeRow][snakeColumn] = 'S';
                        } else if (matrix[snakeRow][snakeColumn] == 'B') {
                            matrix[snakeRow][snakeColumn] = '.';

                            for (int row = 0; row < n; row++) {
                                for (int column = 0; column < n; column++) {
                                    if (matrix[row][column] == 'B') {
                                        snakeRow = row;
                                        snakeColumn = column;
                                        matrix[snakeRow][snakeColumn] = 'S';
                                    }
                                }
                            }
                        } else {
                            matrix[snakeRow][snakeColumn] = 'S';
                        }
                    }
                    break;
            }
            if (isOut) {
                break;
            }
            if (isFed) {
                break;
            }
            commands = scanner.nextLine();
        }

        if (isOut) {
            System.out.println("Game over!");
        }
        if (isFed) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d\n",foodCount);

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
            matrix[row] = scanner.nextLine().toCharArray();

        }
    }
}
