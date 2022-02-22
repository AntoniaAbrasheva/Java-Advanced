package exams.finalExam_20022021;

import java.util.Scanner;

public class bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        String[][] matrix = new String[n][n];

        fillMatrix(scanner,n,matrix);

        int sapperRow = -1;
        int sapperColumn = -1;
        int countOfBombs = 0;

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {

                if (matrix[row][column].equals("s")) {
                    sapperRow = row;
                    sapperColumn = column;
                }
                if (matrix[row][column].equals("B")) {
                    countOfBombs++;
                }
            }
        }
        boolean endGame = false;
        boolean foundAllBombs = false;

        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];

            switch (currentCommand) {
                case "right":
                    sapperColumn++;
                    if (sapperColumn > n - 1) {
                        sapperColumn = n - 1;
                    } else {
                        if (matrix[sapperRow][sapperColumn].equals("B")) {
                            System.out.println("You found a bomb!");
                            countOfBombs--;
                        } else if (matrix[sapperRow][sapperColumn].equals("e")) {
                            endGame = true;
                            break;
                        } else {
                            matrix[sapperRow][sapperColumn] = "S";
                        }
                        if (countOfBombs <= 0) {
                            foundAllBombs = true;
                            break;
                        }
                    }

                    break;
                case "left":
                    sapperColumn--;
                    if (sapperColumn < 0) {
                        sapperColumn = 0;
                    } else {
                        if (matrix[sapperRow][sapperColumn].equals("B")) {
                            System.out.println("You found a bomb!");
                            countOfBombs--;
                        } else if (matrix[sapperRow][sapperColumn].equals("e")) {
                            endGame = true;
                            break;
                        } else {
                            matrix[sapperRow][sapperColumn] = "S";
                        }
                        if (countOfBombs <= 0) {
                            foundAllBombs = true;
                            break;
                        }
                    }
                    break;
                case "down":
                    sapperRow++;
                    if (sapperRow > n - 1) {
                        sapperRow = n - 1;
                    } else {

                        if (matrix[sapperRow][sapperColumn].equals("B")) {
                            System.out.println("You found a bomb!");
                            countOfBombs--;
                        } else if (matrix[sapperRow][sapperColumn].equals("e")) {
                            endGame = true;
                            break;
                        } else {
                            matrix[sapperRow][sapperColumn] = "S";
                        }
                        if (countOfBombs <= 0) {
                            foundAllBombs = true;
                            break;
                        }
                    }
                    break;
                case "up":
                    sapperRow--;
                    if (sapperRow < 0) {
                        sapperRow = 0;
                    } else {
                        if (matrix[sapperRow][sapperColumn].equals("B")) {
                            System.out.println("You found a bomb!");
                            countOfBombs--;
                        } else if (matrix[sapperRow][sapperColumn].equals("e")) {
                            endGame = true;
                            break;
                        } else {
                            matrix[sapperRow][sapperColumn] = "S";
                        }
                        if (countOfBombs <= 0) {
                            foundAllBombs = true;
                            break;
                        }
                    }
                    break;
            }
            if (endGame) {
                break;
            }
            if (foundAllBombs) {
                break;
            }

        }

        if (foundAllBombs) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (endGame) {
            System.out.printf("END! %d bombs left on the field\n",countOfBombs);
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)\n"
                    ,countOfBombs,sapperRow,sapperColumn);
        }


    }



    private static void fillMatrix(Scanner scanner, int n, String[][] matrix) {

        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");

        }
    }
}
