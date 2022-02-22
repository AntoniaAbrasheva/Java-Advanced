package exams.retakeExam_14042021;

import java.util.Scanner;

public class cookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        fillMatrix(scanner, n, matrix);

        int bakerRow = -1;
        int bakerColumn = -1;

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (matrix[row][column].equals("S")) {
                    bakerRow = row;
                    bakerColumn = column;
                }

            }

        }

        String commands = scanner.nextLine();

        int collectedPrice = 0;
        boolean enoughMoney = false;
        boolean isOut = false;

        while ((collectedPrice < 50) || (bakerRow >= 0 && bakerRow <= n -1 && bakerColumn >= 0 && bakerColumn <= n - 1)) {


            switch (commands) {


                case "right":
                    matrix[bakerRow][bakerColumn] = "-";
                    bakerColumn++;

                    if (bakerColumn > n - 1) {
                        isOut = true;
                        break;
                    }
                    if (matrix[bakerRow][bakerColumn].equals("1") || matrix[bakerRow][bakerColumn].equals("2")
                            || matrix[bakerRow][bakerColumn].equals("3") || matrix[bakerRow][bakerColumn].equals("4")
                            || matrix[bakerRow][bakerColumn].equals("5") || matrix[bakerRow][bakerColumn].equals("6")
                            || matrix[bakerRow][bakerColumn].equals("7") || matrix[bakerRow][bakerColumn].equals("8")
                            || matrix[bakerRow][bakerColumn].equals("9")) {

                        collectedPrice += Integer.parseInt(matrix[bakerRow][bakerColumn]);
                        matrix[bakerRow][bakerColumn] = "S";

                        if (collectedPrice >= 50) {
                            enoughMoney = true;
                            break;
                        }


                    } else if (matrix[bakerRow][bakerColumn].equals("P")) {
                        matrix[bakerRow][bakerColumn] = "S";


                        for (int row = 0; row < n; row++) {
                            for (int column = 0; column < n; column++) {
                                if (matrix[row][column].equals("P")) {
                                    matrix[bakerRow][bakerColumn] = "-";

                                    bakerRow = row;
                                    bakerColumn = column;

                                    matrix[bakerRow][bakerColumn] = "S";
                                }
                            }
                        }

                    } else {
                        matrix[bakerRow][bakerColumn] = "S";
                    }
                        break;
                case "left":
                    matrix[bakerRow][bakerColumn] = "-";
                    bakerColumn--;

                    if (bakerColumn < 0) {
                        isOut = true;
                        break;
                    }
                    if (matrix[bakerRow][bakerColumn].equals("1") || matrix[bakerRow][bakerColumn].equals("2")
                            || matrix[bakerRow][bakerColumn].equals("3") || matrix[bakerRow][bakerColumn].equals("4")
                            || matrix[bakerRow][bakerColumn].equals("5") || matrix[bakerRow][bakerColumn].equals("6")
                            || matrix[bakerRow][bakerColumn].equals("7") || matrix[bakerRow][bakerColumn].equals("8")
                            || matrix[bakerRow][bakerColumn].equals("9")) {

                        collectedPrice += Integer.parseInt(matrix[bakerRow][bakerColumn]);
                        matrix[bakerRow][bakerColumn] = "S";

                        if (collectedPrice >= 50) {
                            enoughMoney = true;
                            break;
                        }


                    } else if (matrix[bakerRow][bakerColumn].equals("P")) {
                        matrix[bakerRow][bakerColumn] = "S";


                        for (int row = 0; row < n; row++) {
                            for (int column = 0; column < n; column++) {
                                if (matrix[row][column].equals("P")) {
                                    matrix[bakerRow][bakerColumn] = "-";

                                    bakerRow = row;
                                    bakerColumn = column;

                                    matrix[bakerRow][bakerColumn] = "S";
                                }
                            }
                        }

                    } else {
                        matrix[bakerRow][bakerColumn] = "S";
                    }
                    break;
                case "up":
                    matrix[bakerRow][bakerColumn] = "-";
                    bakerRow--;

                    if (bakerRow < 0) {
                        isOut = true;
                        break;
                    }
                    if (matrix[bakerRow][bakerColumn].equals("1") || matrix[bakerRow][bakerColumn].equals("2")
                            || matrix[bakerRow][bakerColumn].equals("3") || matrix[bakerRow][bakerColumn].equals("4")
                            || matrix[bakerRow][bakerColumn].equals("5") || matrix[bakerRow][bakerColumn].equals("6")
                            || matrix[bakerRow][bakerColumn].equals("7") || matrix[bakerRow][bakerColumn].equals("8")
                            || matrix[bakerRow][bakerColumn].equals("9")) {

                        matrix[bakerRow][bakerColumn] = "S";

                        collectedPrice += Integer.parseInt(matrix[bakerRow][bakerColumn]);
                        if (collectedPrice >= 50) {
                            enoughMoney = true;
                            break;
                        }


                    } else if (matrix[bakerRow][bakerColumn].equals("P")) {
                        matrix[bakerRow][bakerColumn] = "S";


                        for (int row = 0; row < n; row++) {
                            for (int column = 0; column < n; column++) {
                                if (matrix[row][column].equals("P")) {
                                    matrix[bakerRow][bakerColumn] = "-";

                                    bakerRow = row;
                                    bakerColumn = column;

                                    matrix[bakerRow][bakerColumn] = "S";
                                }
                            }
                        }

                    } else {
                        matrix[bakerRow][bakerColumn] = "S";
                    }
                    break;
                case "down":
                    matrix[bakerRow][bakerColumn] = "-";
                    bakerRow++;

                    if (bakerRow > n - 1) {
                        isOut = true;
                        break;
                    }
                    if (matrix[bakerRow][bakerColumn].equals("1") || matrix[bakerRow][bakerColumn].equals("2")
                            || matrix[bakerRow][bakerColumn].equals("3") || matrix[bakerRow][bakerColumn].equals("4")
                            || matrix[bakerRow][bakerColumn].equals("5") || matrix[bakerRow][bakerColumn].equals("6")
                            || matrix[bakerRow][bakerColumn].equals("7") || matrix[bakerRow][bakerColumn].equals("8")
                            || matrix[bakerRow][bakerColumn].equals("9")) {

                        collectedPrice += Integer.parseInt(matrix[bakerRow][bakerColumn]);
                        matrix[bakerRow][bakerColumn] = "S";
                        if (collectedPrice >= 50) {
                            enoughMoney = true;
                            break;
                        }


                    } else if (matrix[bakerRow][bakerColumn].equals("P")) {
                        matrix[bakerRow][bakerColumn] = "S";


                        for (int row = 0; row < n; row++) {
                            for (int column = 0; column < n; column++) {
                                if (matrix[row][column].equals("P")) {
                                    matrix[bakerRow][bakerColumn] = "-";

                                    bakerRow = row;
                                    bakerColumn = column;

                                    matrix[bakerRow][bakerColumn] = "S";
                                }
                            }
                        }

                    } else {
                        matrix[bakerRow][bakerColumn] = "S";
                    }
                    break;
            }
            if (isOut) {
                break;
            }
            if (enoughMoney) {
                break;
            }

            commands = scanner.nextLine();
        }

        if (enoughMoney) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news! You are out of the pastry shop.");

        }
        System.out.printf("Money: %d\n",collectedPrice);

        printMatrix(n,matrix);
    }

    private static void printMatrix(int n, String[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                System.out.print(matrix[row][column]);

            }
            System.out.println();

        }
    }


    private static void fillMatrix(Scanner scanner, int n, String[][] matrix) {
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}
