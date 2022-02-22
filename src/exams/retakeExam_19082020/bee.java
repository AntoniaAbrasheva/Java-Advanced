package exams.retakeExam_19082020;

import java.util.Scanner;

public class bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        fillMatrix(scanner, n, matrix);

        int beeRow = -1;
        int beeColumn = -1;
        int pollinatedFlowers = 0;
        boolean isOut = false;

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {

                if (matrix[row][column] == 'B') {
                    beeRow = row;
                    beeColumn = column;
                }
            }
        }

        String commands = scanner.nextLine();
        while (!commands.equals("End")) {

            switch (commands) {
                case "right":
                    matrix[beeRow][beeColumn] = '.';
                    beeColumn++;
                    if (beeColumn > n - 1) {
                        isOut = true;
                        break;
                    } else {
                        if (matrix[beeRow][beeColumn] == 'f') {
                            pollinatedFlowers++;
                            matrix[beeRow][beeColumn] = 'B';
                        } else if (matrix[beeRow][beeColumn] == 'O') {
                            matrix[beeRow][beeColumn] = '.';
                            beeColumn += 1;

                            if (beeColumn > n - 1) {
                                isOut = true;
                            } else {
                                if (matrix[beeRow][beeColumn] == 'f') {
                                    pollinatedFlowers++;
                                    matrix[beeRow][beeColumn] = 'B';
                                } else {
                                    matrix[beeRow][beeColumn] = 'B';
                                }
                            }
                        } else {
                            matrix[beeRow][beeColumn] = 'B';
                        }
                    }
                    break;
                case "left":
                    matrix[beeRow][beeColumn] = '.';
                    beeColumn--;
                    if (beeColumn < 0) {
                        isOut = true;
                        break;
                    } else {
                        if (matrix[beeRow][beeColumn] == 'f') {
                            pollinatedFlowers++;
                            matrix[beeRow][beeColumn] = 'B';
                        } else if (matrix[beeRow][beeColumn] == 'O') {
                            matrix[beeRow][beeColumn] = '.';

                            beeColumn -= 1;
                            if (beeColumn < 0) {
                                isOut = true;
                                break;
                            } else {

                                if (matrix[beeRow][beeColumn] == 'f') {
                                    pollinatedFlowers++;
                                    matrix[beeRow][beeColumn] = 'B';
                                } else {
                                    matrix[beeRow][beeColumn] = 'B';
                                }
                            }

                        } else {
                            matrix[beeRow][beeColumn] = 'B';
                        }
                    }
                    break;
                case "down":
                    matrix[beeRow][beeColumn] = '.';
                    beeRow++;
                    if (beeRow > n - 1) {
                        isOut = true;
                        break;
                    } else {
                        if (matrix[beeRow][beeColumn] == 'f') {
                            pollinatedFlowers++;
                            matrix[beeRow][beeColumn] = 'B';
                        } else if (matrix[beeRow][beeColumn] == 'O') {
                            matrix[beeRow][beeColumn] = '.';
                            beeRow += 1;
                            if (beeRow > n - 1) {
                                isOut = true;
                            } else {
                                if (matrix[beeRow][beeColumn] == 'f') {
                                    pollinatedFlowers++;
                                    matrix[beeRow][beeColumn] = 'B';
                                } else {
                                    matrix[beeRow][beeColumn] = 'B';
                                }
                            }
                        } else {
                            matrix[beeRow][beeColumn] = 'B';
                        }
                    }
                    break;
                case "up":
                    matrix[beeRow][beeColumn] = '.';
                    beeRow--;
                    if (beeRow < 0) {
                        isOut = true;
                        break;
                    } else {
                        if (matrix[beeRow][beeColumn] == 'f') {
                            pollinatedFlowers++;
                            matrix[beeRow][beeColumn] = 'B';
                        } else if (matrix[beeRow][beeColumn] == 'O') {
                            matrix[beeRow][beeColumn] = '.';
                            beeRow -= 1;
                            if (beeRow < 0) {
                                isOut = true;
                            } else {
                                if (matrix[beeRow][beeColumn] == 'f') {
                                    pollinatedFlowers++;
                                    matrix[beeRow][beeColumn] = 'B';
                                } else {
                                    matrix[beeRow][beeColumn] = 'B';
                                }
                            }
                        } else {
                            matrix[beeRow][beeColumn] = 'B';
                        }
                    }
                    break;
            }
            if (isOut) {
                break;
            }

            commands = scanner.nextLine();
        }
        if (isOut) {
            System.out.println("The bee got lost!");
        }

        if (pollinatedFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - pollinatedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollinatedFlowers);
        }


        printMatrix(n, matrix);
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


