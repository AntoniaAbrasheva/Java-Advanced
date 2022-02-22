package MultidimensionalArrays.exercise;

import java.util.Scanner;

public class fillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int n = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[n][n];

        if (pattern.equals("A")) {

            fillMatrixPatternA(matrix);
        } else {

            fillMatrixPatternB(matrix);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {

                System.out.print(matrix[row][column] + " ");

            }
            System.out.println();

        }
    }

    private static void fillMatrixPatternB(int[][] matrix) {

        int num = 1;

        for (int column = 0; column < matrix.length; column++) {

            if (column % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][column] = num;
                    num++;

                }

            } else {

                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][column] = num;
                    num++;

                }

            }

        }
    }

    private static void fillMatrixPatternA(int[][] matrix) {

        int num = 1;

        for (int column = 0; column < matrix.length; column++) {
            for (int row = 0; row < matrix.length; row++) {

                matrix[row][column] = num;
                num++;

            }

        }
    }
}
