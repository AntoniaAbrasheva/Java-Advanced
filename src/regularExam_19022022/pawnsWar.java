package regularExam_19022022;

import java.util.Scanner;

public class pawnsWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix= new char[8][8];
        fillMatrix(scanner,matrix);

        int blackRow = -1;
        int blackColumn = -1;
        int whiteRow = -1;
        int whiteColumn = -1;

        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (matrix[row][column] == 'b') {
                    blackRow = row;
                    blackColumn = column;
                }
                if (matrix[row][column] == 'w') {
                    whiteRow = row;
                    whiteColumn = column;
                }

            }

        }

        while (true) {
            if (whiteRow - 1 >= 0 && whiteColumn - 1 >= 0 && matrix[whiteRow - 1][whiteColumn - 1] == 'b') {

                String position = findPosition(whiteRow - 1, whiteColumn - 1);
                System.out.printf("Game over! White capture on %s.", position);
                break;

            } else if (whiteRow - 1 >= 0 && whiteColumn + 1 <= 7 && matrix[whiteRow - 1][whiteColumn + 1] == 'b') {

                String position = findPosition(whiteRow - 1, whiteColumn + 1);
                System.out.printf("Game over! White capture on %s.", position);
                break;

            } else {
                matrix[whiteRow][whiteColumn] = '-';
                whiteRow -= 1;
                matrix[whiteRow][whiteColumn] = 'w';

                if (whiteRow == 0) {
                    String position = findPosition(whiteRow, whiteColumn);
                    System.out.printf("Game over! White pawn is promoted to a queen at %s.", position);
                    break;
                }

            }

            if (blackRow + 1 <= 7 && blackColumn - 1 >= 0 && matrix[blackRow + 1][blackColumn - 1] == 'w') {

                String position = findPosition(blackRow + 1, blackColumn - 1);
                System.out.printf("Game over! Black capture on %s.", position);
                break;

            } else if (blackRow + 1 <= 7 && blackColumn + 1 <= 7 && matrix[blackRow + 1][blackColumn + 1] == 'w') {

                String position = findPosition(blackRow + 1, blackColumn + 1);
                System.out.printf("Game over! Black capture on %s.", position);
                break;

            } else {
                matrix[blackRow][blackColumn] = '-';
                blackRow += 1;
                matrix[blackRow][blackColumn] = 'b';

                if (blackRow == 7) {
                    String position = findPosition(blackRow, blackColumn);
                    System.out.printf("Game over! Black pawn is promoted to a queen at %s.", position);
                    break;
                }

            }
        }


    }

    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < 8; row++) {
            matrix[row] = scanner.nextLine().toCharArray();

        }
    }

    private static String findPosition(int row, int column) {
        StringBuilder sb = new StringBuilder();

        for (int i = 8; i >= 0; i--) {
            if (column == i) {
                sb.append((char)(i + 97));
            }
        }

        int count = 8;
        for (int i = 0; i < 8; i++) {
            if (row == i)
            {
                sb.append(count);
            }
            count--;
        }
        return sb.toString();
    }
}
