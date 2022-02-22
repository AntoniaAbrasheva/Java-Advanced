package exams.finalExam_22022020;

import java.util.Scanner;

public class revolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int commandsNum = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        fillMatrix(scanner, n, matrix);

        int playerRow = -1;
        int playerColumn = -1;

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (matrix[row][column] == 'f') {
                    playerRow = row;
                    playerColumn = column;
                }
            }
        }
        boolean isFinished = false;
        for (int i = 0; i < commandsNum; i++) {
            String commands = scanner.nextLine();

            switch (commands) {
                case "right":
                    matrix[playerRow][playerColumn] = '-';
                    playerColumn++;
                    if (playerColumn > n - 1) {
                        playerColumn = 0;

                        if (matrix[playerRow][playerColumn] == 'B') {
                            playerColumn++;
                            if (matrix[playerRow][playerColumn] == 'F') {
                                matrix[playerRow][playerColumn] = 'f';
                                isFinished = true;
                            } else {
                                matrix[playerRow][playerColumn] = 'f';
                            }
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerColumn = n - 1;
                            if (matrix[playerRow][playerColumn] == 'F') {
                                matrix[playerRow][playerColumn] = 'f';
                                isFinished = true;
                            } else {
                                matrix[playerRow][playerColumn] = 'f';
                            }
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'f';
                            isFinished = true;
                        } else {
                            matrix[playerRow][playerColumn] = 'f';
                        }
                    } else {
                        if (matrix[playerRow][playerColumn] == 'B') {
                            playerColumn++;
                            if (playerColumn <= n - 1) {

                                if (matrix[playerRow][playerColumn] == 'F') {
                                    matrix[playerRow][playerColumn] = 'f';
                                    isFinished = true;
                                } else {
                                    matrix[playerRow][playerColumn] = 'f';
                                }
                            } else {
                                playerColumn = 0;
                                if (matrix[playerRow][playerColumn] == 'F') {
                                    matrix[playerRow][playerColumn] = 'f';
                                    isFinished = true;
                                } else {
                                    matrix[playerRow][playerColumn] = 'f';
                                }
                            }

                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerColumn--;

                            if (playerColumn >= 0) {
                                if (matrix[playerRow][playerColumn] == 'F') {
                                    matrix[playerRow][playerColumn] = 'f';
                                    isFinished = true;
                                } else {
                                    matrix[playerRow][playerColumn] = 'f';
                                }
                            } else {
                                playerColumn = n - 1;
                                if (matrix[playerRow][playerColumn] == 'F') {
                                    matrix[playerRow][playerColumn] = 'f';
                                    isFinished = true;
                                } else {
                                    matrix[playerRow][playerColumn] = 'f';
                                }

                            }
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'f';
                            isFinished = true;
                        } else {
                            matrix[playerRow][playerColumn] = 'f';
                        }
                    }

                    break;
                case "left":
                    matrix[playerRow][playerColumn] = '-';
                    playerColumn--;
                    if (playerColumn < 0) {
                        playerColumn = n - 1;

                        if (matrix[playerRow][playerColumn] == 'B') {
                            playerColumn--;
                            if (matrix[playerRow][playerColumn] == 'F') {
                                matrix[playerRow][playerColumn] = 'f';
                                isFinished = true;
                            } else {
                                matrix[playerRow][playerColumn] = 'f';
                            }
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerColumn++;
                            if (playerColumn <= n - 1) {
                                if (matrix[playerRow][playerColumn] == 'F') {
                                    matrix[playerRow][playerColumn] = 'f';
                                    isFinished = true;
                                } else {
                                    matrix[playerRow][playerColumn] = 'f';
                                }
                            } else {
                                if (matrix[playerRow][playerColumn] == 'F') {
                                    matrix[playerRow][playerColumn] = 'f';
                                    isFinished = true;
                                } else {
                                    matrix[playerRow][playerColumn] = 'f';
                                }

                            }
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'f';
                            isFinished = true;
                        } else {
                            matrix[playerRow][playerColumn] = 'f';
                        }
                    } else {
                        if (matrix[playerRow][playerColumn] == 'B') {
                            playerColumn--;
                            if (playerColumn >= 0) {

                                if (matrix[playerRow][playerColumn] == 'F') {
                                    matrix[playerRow][playerColumn] = 'f';
                                    isFinished = true;
                                } else {
                                    matrix[playerRow][playerColumn] = 'f';
                                }
                            } else {
                                playerColumn = n - 1;
                                if (matrix[playerRow][playerColumn] == 'F') {
                                    matrix[playerRow][playerColumn] = 'f';
                                    isFinished = true;
                                } else {
                                    matrix[playerRow][playerColumn] = 'f';
                                }

                            }
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerColumn++;
                            if (matrix[playerRow][playerColumn] == 'F') {
                                matrix[playerRow][playerColumn] = 'f';
                                isFinished = true;
                            } else {
                                matrix[playerRow][playerColumn] = 'f';
                            }
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'f';
                            isFinished = true;
                        } else {
                            matrix[playerRow][playerColumn] = 'f';
                        }
                    }
                    break;
                case "down":
                    matrix[playerRow][playerColumn] = '-';
                    playerRow++;
                    if (playerRow > n - 1) {
                        playerRow = 0;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            playerRow++;
                            if (matrix[playerRow][playerColumn] == 'F') {
                                matrix[playerRow][playerColumn] = 'f';
                                isFinished = true;
                            } else {
                                matrix[playerRow][playerColumn] = 'f';
                            }
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerRow--;
                            if (matrix[playerRow][playerColumn] == 'F') {
                                matrix[playerRow][playerColumn] = 'f';
                                isFinished = true;
                            } else {
                                matrix[playerRow][playerColumn] = 'f';
                            }
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'f';
                            isFinished = true;
                        } else {
                            matrix[playerRow][playerColumn] = 'f';
                        }
                    } else {
                        if (matrix[playerRow][playerColumn] == 'B') {
                            playerRow++;
                            if (playerRow < n - 1) {

                                if (matrix[playerRow][playerColumn] == 'F') {
                                    matrix[playerRow][playerColumn] = 'f';
                                    isFinished = true;
                                } else {
                                    matrix[playerRow][playerColumn] = 'f';
                                }
                            }else {
                                playerRow = 0;
                                if (matrix[playerRow][playerColumn] == 'F') {
                                    matrix[playerRow][playerColumn] = 'f';
                                    isFinished = true;
                                } else {
                                    matrix[playerRow][playerColumn] = 'f';
                                }

                            }
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerRow--;
                            if (matrix[playerRow][playerColumn] == 'F') {
                                matrix[playerRow][playerColumn] = 'f';
                                isFinished = true;
                            } else {
                                matrix[playerRow][playerColumn] = 'f';
                            }
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'f';
                            isFinished = true;
                        } else {
                            matrix[playerRow][playerColumn] = 'f';
                        }
                    }
                    break;
                case "up":
                    matrix[playerRow][playerColumn] = '-';
                    playerRow--;
                    if (playerRow < 0) {
                        playerRow = n - 1;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            playerRow--;
                            if (matrix[playerRow][playerColumn] == 'F') {
                                matrix[playerRow][playerColumn] = 'f';
                                isFinished = true;
                            } else {
                                matrix[playerRow][playerColumn] = 'f';
                            }
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerRow = 0;
                            if (matrix[playerRow][playerColumn] == 'F') {
                                matrix[playerRow][playerColumn] = 'f';
                                isFinished = true;
                            } else {
                                matrix[playerRow][playerColumn] = 'f';
                            }
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'f';
                            isFinished = true;
                        } else {
                            matrix[playerRow][playerColumn] = 'f';
                        }
                    } else {
                        if (matrix[playerRow][playerColumn] == 'B') {
                            playerRow--;
                            if (playerRow >= 0) {

                                if (matrix[playerRow][playerColumn] == 'F') {
                                    matrix[playerRow][playerColumn] = 'f';
                                    isFinished = true;
                                } else {
                                    matrix[playerRow][playerColumn] = 'f';
                                }
                            }else {
                                playerRow = n - 1;
                                if (matrix[playerRow][playerColumn] == 'F') {
                                    matrix[playerRow][playerColumn] = 'f';
                                    isFinished = true;
                                } else {
                                    matrix[playerRow][playerColumn] = 'f';
                                }

                            }
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerRow--;
                            if (matrix[playerRow][playerColumn] == 'F') {
                                matrix[playerRow][playerColumn] = 'f';
                                isFinished = true;
                            } else {
                                matrix[playerRow][playerColumn] = 'f';
                            }
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'f';
                            isFinished = true;
                        } else {
                            matrix[playerRow][playerColumn] = 'f';
                        }
                    }
                    break;
            }
            if (isFinished) {
                break;
            }
        }
        if (isFinished) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
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
            matrix[row] = scanner.nextLine().toCharArray();

        }
    }
}
