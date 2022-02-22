package exams.retakeExam_18082021;

import java.util.Scanner;

public class formulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int commandsNum = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        fillMatrix(scanner,n,matrix);

        int playerRow = -1;
        int playerColumn = -1;

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                char currentSymbol = matrix[row][column];

                if (currentSymbol == 'P') {
                    playerRow = row;
                    playerColumn = column;
                }
            }
        }

        boolean isFinished = false;

        for (int i = 0; i < commandsNum; i++) {
            String commands = scanner.nextLine();

            matrix[playerRow][playerColumn] = '.';

            switch (commands) {
                case "right":
                    if (playerColumn == n - 1) {
                        playerColumn = 0;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            matrix[playerRow][playerColumn] = 'B';
                            matrix[playerRow][playerColumn + 1] = 'P';
                            playerColumn += 1;

                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            matrix[playerRow][playerColumn] = 'T';

                            matrix[playerRow][n - 1] = 'P';
                            playerColumn = n - 1;
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            isFinished = true;
                            break;
                        } else {

                            matrix[playerRow][playerColumn] = 'P';
                        }
                    } else {
                        playerColumn++;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            matrix[playerRow][playerColumn] = 'B';
                            if (playerColumn + 1 <= n - 1) {
                                matrix[playerRow][playerColumn + 1] = 'P';
                                playerColumn += 1;

                            } else {
                                matrix[playerRow][0] = 'P';
                                playerColumn = 0;
                            }

                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            matrix[playerRow][playerColumn] = 'T';
                            matrix[playerRow][playerColumn - 1] = 'P';
                            playerColumn -= 1;
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            isFinished = true;
                            break;

                        } else {
                            matrix[playerRow][playerColumn] = 'P';
                        }
                    }

                    break;
                case "left":
                    if (playerColumn == 0) {
                        playerColumn = n - 1;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            matrix[playerRow][playerColumn] = 'B';
                            matrix[playerRow][playerColumn - 1] = 'P';
                            playerColumn -= 1;
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            matrix[playerRow][playerColumn] = 'T';
                            matrix[playerRow][0] = 'P';
                            playerColumn = 0;
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            isFinished = true;
                            break;

                        } else {
                            matrix[playerRow][playerColumn] = 'P';
                        }
                    } else {
                        playerColumn--;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            matrix[playerRow][playerColumn] = 'B';

                            if (playerColumn - 1 != 0) {
                                matrix[playerRow][playerColumn - 1] = 'P';
                                playerColumn -= 1;
                            } else {
                                matrix[playerRow][playerColumn - 1] = 'P';
                                playerColumn -= 1;
                            }
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            matrix[playerRow][playerColumn + 1] = 'P';
                            playerColumn += 1;
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            isFinished = true;
                            break;
                        } else {
                            matrix[playerRow][playerColumn] = 'P';
                        }
                    }
                    break;
                case "down":
                    if (playerRow == n - 1) {
                        playerRow = 0;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            matrix[playerRow][playerColumn] = 'B';
                            matrix[playerRow + 1][playerColumn] = 'P';
                            playerRow += 1;
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            matrix[playerRow][playerColumn] = 'T';
                            matrix[n - 1][playerColumn] = 'P';
                            playerRow = n - 1;
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'P';
                            isFinished = true;
                            break;
                        } else {
                            matrix[playerRow][playerColumn] = 'P';
                        }
                    } else {
                        playerRow++;

                        if (matrix[playerRow][playerColumn] == 'B') {
                            matrix[playerRow][playerColumn] = 'B';

                            if (playerRow + 1 <= n - 1) {
                                matrix[playerRow + 1][playerColumn] = 'P';
                                playerRow = playerRow + 1;

                            } else {
                                matrix[0][playerColumn] = 'P';
                                playerRow = 0;

                            }
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            matrix[playerRow][playerColumn] = 'T';
                            matrix[playerRow - 1][playerColumn] = 'P';
                            playerRow = playerRow - 1;
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'P';
                            isFinished = true;
                            break;
                        } else {
                            matrix[playerRow][playerColumn] = 'P';
                        }
                    }
                    break;
                case "up":
                    if (playerRow == 0) {
                        playerRow = n - 1;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            matrix[playerRow][playerColumn] = 'B';
                            matrix[playerRow - 1][playerColumn] = 'P';
                            playerRow -= 1;

                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            matrix[playerRow][playerColumn] = 'T';
                            matrix[0][playerColumn] = 'P';
                            playerRow = 0;
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            isFinished = true;
                            break;
                        } else {
                            matrix[playerRow][playerColumn] = 'P';
                        }
                    } else {
                        playerRow--;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            matrix[playerRow][playerColumn] = 'B';

                            if (playerRow - 1 < 0) {
                                matrix[n - 1][playerColumn] = 'P';
                                playerRow = n - 1;
                            } else {
                                matrix[0][playerColumn] = 'P';

                            }
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            matrix[playerRow][playerColumn] = 'T';
                            matrix[playerRow + 1][playerColumn] = 'P';
                            playerRow += 1;
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            isFinished = true;
                            break;
                        } else {
                            matrix[playerRow][playerColumn] = 'P';
                        }

                    }

                    break;
            }
        }




        if (isFinished) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
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


