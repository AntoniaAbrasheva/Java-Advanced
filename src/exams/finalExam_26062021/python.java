package exams.finalExam_26062021;

import java.util.Scanner;

public class python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",\\s+");

        String[][] matrix = new String[n][n];

        fillMatrix(scanner, n, matrix);

        int firstLength = 1;
        int snakeRow = -1;
        int snakeColumn = -1;


       int foodCount = 0;
        int countOfFood = foodCount(n, matrix,foodCount);

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (matrix[row][column].equals("s")) {
                    snakeRow = row;
                    snakeColumn = column;
                }

            }

        }
        boolean allFoodIsEaten = false;
        boolean isKilledByEnemy = false;

        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];

            if (currentCommand.equals("up")) {
                matrix[snakeRow][snakeColumn] = "*";
                if (snakeRow == 0) {
                    snakeRow = n - 1;
                    matrix[snakeRow][snakeColumn] = matrix[n - 1][snakeColumn];
                } else {
                    snakeRow--;

                }
                if (matrix[snakeRow][snakeColumn].equals("f")) {
                    countOfFood--;
                    firstLength++;
                    matrix[snakeRow][snakeColumn] = "s";

                    if (countOfFood == 0) {
                        allFoodIsEaten = true;
                        break;
                    }
                } else if (matrix[snakeRow][snakeColumn].equals("e")) {
                    isKilledByEnemy = true;
                    break;
                } else {
                    matrix[snakeRow][snakeColumn] = "s";
                }

            } else if (currentCommand.equals("down")) {
                matrix[snakeRow][snakeColumn] = "*";

                if (snakeRow == n - 1) {
                    snakeRow = 0;
                    matrix[snakeRow][snakeColumn] = matrix[0][snakeColumn];
                } else {
                    snakeRow++;
                }
                if (matrix[snakeRow][snakeColumn].equals("f")) {
                    countOfFood--;
                    firstLength++;
                    matrix[snakeRow][snakeColumn] = "s";
                    if (countOfFood == 0) {
                        allFoodIsEaten = true;
                        break;
                    }
                } else if (matrix[snakeRow][snakeColumn].equals("e")) {
                    isKilledByEnemy = true;
                    break;
                } else {
                    matrix[snakeRow][snakeColumn] = "s";
                }


            } else if (currentCommand.equals("right")) {
                matrix[snakeRow][snakeColumn] = "*";


                if (snakeColumn == n - 1) {
                    snakeColumn = 0;
                    matrix[snakeRow][snakeColumn] = matrix[snakeRow][0];
                } else {
                    snakeColumn++;
                }
                if (matrix[snakeRow][snakeColumn].equals("f")) {
                    countOfFood--;
                    firstLength++;
                    matrix[snakeRow][snakeColumn] = "s";
                    if (countOfFood == 0) {
                        allFoodIsEaten = true;
                        break;
                    }
                } else if (matrix[snakeRow][snakeColumn].equals("e")) {
                    isKilledByEnemy = true;
                    break;
                } else {
                    matrix[snakeRow][snakeColumn] = "s";
                }

            } else if (currentCommand.equals("left")) {
                matrix[snakeRow][snakeColumn] = "*";

                if (snakeColumn == 0) {
                    snakeColumn = n - 1;
                    matrix[snakeRow][snakeColumn] = matrix[snakeRow][n - 1];
                } else {
                    snakeColumn --;
                }

                if (matrix[snakeRow][snakeColumn].equals("f")) {
                    countOfFood--;
                    firstLength++;
                    matrix[snakeRow][snakeColumn] = "s";
                    if (countOfFood == 0) {
                        allFoodIsEaten = true;
                        break;
                    }
                } else if (matrix[snakeRow][snakeColumn].equals("e")) {
                    isKilledByEnemy = true;
                    break;
                } else {
                    matrix[snakeRow][snakeColumn] = "s";
                }

            }

        }

        if (isKilledByEnemy) {
            System.out.println("You lose! Killed by an enemy!");
        } else {

            if (allFoodIsEaten) {
                System.out.printf("You win! Final python length is %d", firstLength);
            } else {
                System.out.printf("You lose! There is still %d food to be eaten.", countOfFood);
            }
        }



    }

    private static int foodCount(int n, String[][] matrix, int foodCount) {
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (matrix[row][column].equals("f")) {
                    foodCount++;

                }

            }

        }
        return foodCount;
    }

    private static void fillMatrix(Scanner scanner, int n, String[][] matrix) {
        for (int row = 0; row < n; row++) {

           matrix[row] = scanner.nextLine().split("\\s+");

        }
    }


}
