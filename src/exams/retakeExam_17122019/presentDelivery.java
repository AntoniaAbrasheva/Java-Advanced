package exams.retakeExam_17122019;

import java.util.Scanner;

public class presentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfPresents = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];
        fillMatrix(scanner,n,matrix);

        int santaRow = -1;
        int santaColumn = -1;
        int countOfNiceKids = 0;

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {

                if (matrix[row][column].equals("S")) {
                    santaRow = row;
                    santaColumn = column;
                }
                if (matrix[row][column].equals("V")) {
                    countOfNiceKids++;
                }
            }
        }

        String commands = scanner.nextLine();
        boolean isOut = false;
        boolean isRunOutOfPresents = false;
        int niceKids = 0;
        while (!commands.equals("Christmas morning")) {
            switch (commands) {
                case "right":
                    matrix[santaRow][santaColumn] = "-";
                    santaColumn++;
                    if (santaColumn > n - 1) {
                        isOut = true;
                    } else {
                        if (matrix[santaRow][santaColumn].equals("V")) {
                            countOfPresents--;
                            niceKids++;
                            if (countOfPresents <= 0) {
                                isRunOutOfPresents = true;
                            }
                            matrix[santaRow][santaColumn] = "S";
                        } else if (matrix[santaRow][santaColumn].equals("X")) {
                            matrix[santaRow][santaColumn] = "S";
                        } else if (matrix[santaRow][santaColumn].equals("C")) {
                            matrix[santaRow][santaColumn] = "S";
                            if (santaRow >= 1) {
                                countOfPresents--;
                            } else if (santaRow <= n - 2) {
                                countOfPresents--;
                                if (countOfPresents <= 0) {
                                    isRunOutOfPresents = true;
                                }
                            } else if (santaColumn <= n - 2) {
                                countOfPresents--;
                                if (countOfPresents <= 0) {
                                    isRunOutOfPresents = true;
                                }
                            } else if (santaColumn >= 1) {
                                countOfPresents--;
                                if (countOfPresents <= 0) {
                                    isRunOutOfPresents = true;
                                }
                            }
                        } else {
                            matrix[santaRow][santaColumn] = "S";
                        }

                    }
                    break;
                case "left":
                    matrix[santaRow][santaColumn] = "-";
                    santaColumn--;
                    if (santaColumn < 0) {
                        isOut = true;
                    } else {
                        if (matrix[santaRow][santaColumn].equals("V")) {
                            niceKids++;
                            countOfPresents--;
                            if (countOfPresents <= 0) {
                                isRunOutOfPresents = true;
                            }
                            matrix[santaRow][santaColumn] = "S";
                        } else if (matrix[santaRow][santaColumn].equals("X")) {
                            matrix[santaRow][santaColumn] = "S";
                        } else if (matrix[santaRow][santaColumn].equals("C")) {
                            matrix[santaRow][santaColumn] = "S";
                            if (santaRow >= 1) {
                                countOfPresents--;
                            } else if (santaRow <= n - 2) {
                                countOfPresents--;
                                if (countOfPresents <= 0) {
                                    isRunOutOfPresents = true;
                                }
                            } else if (santaColumn <= n - 2) {
                                countOfPresents--;
                                if (countOfPresents <= 0) {
                                    isRunOutOfPresents = true;
                                }
                            } else if (santaColumn >= 1) {
                                countOfPresents--;
                                if (countOfPresents <= 0) {
                                    isRunOutOfPresents = true;
                                }
                            }
                        } else {
                            matrix[santaRow][santaColumn] = "S";
                        }

                    }
                    break;
                case "down":
                    matrix[santaRow][santaColumn] = "-";
                    santaRow++;
                    if (santaRow > n - 1) {
                        isOut = true;
                    } else {
                        if (matrix[santaRow][santaColumn].equals("V")) {
                            niceKids++;
                            countOfPresents--;
                            if (countOfPresents <= 0) {
                                isRunOutOfPresents = true;
                            }
                            matrix[santaRow][santaColumn] = "S";
                        } else if (matrix[santaRow][santaColumn].equals("X")) {
                            matrix[santaRow][santaColumn] = "S";
                        } else if (matrix[santaRow][santaColumn].equals("C")) {
                            matrix[santaRow][santaColumn] = "S";
                            if (santaRow >= 1) {
                                countOfPresents--;
                            } else if (santaRow <= n - 2) {
                                countOfPresents--;
                                if (countOfPresents <= 0) {
                                    isRunOutOfPresents = true;
                                }
                            } else if (santaColumn <= n - 2) {
                                countOfPresents--;
                                if (countOfPresents <= 0) {
                                    isRunOutOfPresents = true;
                                }
                            } else if (santaColumn >= 1) {
                                countOfPresents--;
                                if (countOfPresents <= 0) {
                                    isRunOutOfPresents = true;
                                }
                            }
                        } else {
                            matrix[santaRow][santaColumn] = "S";
                        }

                    }
                    break;
                case "up":
                    matrix[santaRow][santaColumn] = "-";
                    santaRow--;
                    if (santaColumn < 0) {
                        isOut = true;
                    } else {
                        if (matrix[santaRow][santaColumn].equals("V")) {
                            niceKids++;
                            countOfPresents--;
                            if (countOfPresents <= 0) {
                                isRunOutOfPresents = true;
                            }
                            matrix[santaRow][santaColumn] = "S";
                        } else if (matrix[santaRow][santaColumn].equals("X")) {
                            matrix[santaRow][santaColumn] = "S";
                        } else if (matrix[santaRow][santaColumn].equals("C")) {
                            matrix[santaRow][santaColumn] = "S";
                            if (santaRow >= 1) {
                                countOfPresents--;
                            } else if (santaRow <= n - 2) {
                                countOfPresents--;
                                if (countOfPresents <= 0) {
                                    isRunOutOfPresents = true;
                                }
                            } else if (santaColumn <= n - 2) {
                                countOfPresents--;
                                if (countOfPresents <= 0) {
                                    isRunOutOfPresents = true;
                                }
                            } else if (santaColumn >= 1) {
                                countOfPresents--;
                                if (countOfPresents <= 0) {
                                    isRunOutOfPresents = true;
                                }
                            }
                        } else {
                            matrix[santaRow][santaColumn] = "S";
                        }

                    }
                    break;
            }
            if (isOut) {
                break;
            }
            if (isRunOutOfPresents) {
                break;
            }
            commands = scanner.nextLine();
        }
        if (isRunOutOfPresents) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(n,matrix);

        if (countOfNiceKids == niceKids) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.\n",niceKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.\n",countOfNiceKids - niceKids);
        }
    }

    private static void printMatrix(int n, String[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int n, String[][] matrix) {
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");

        }
    }
}
