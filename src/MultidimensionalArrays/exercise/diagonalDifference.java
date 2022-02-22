package MultidimensionalArrays.exercise;

import java.util.Scanner;

public class diagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        createMatrix(matrix,scanner);

        int primarySum = getSumOfPrimaryDiagonal(matrix);

        int secondarySum = getSumOfSecondaryDiagonal(matrix);

        System.out.println(Math.abs(primarySum - secondarySum));
    }

    private static int getSumOfSecondaryDiagonal(int[][] matrix) {

        int sum = 0;

        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int column = 0; column < matrix.length; column++) {


                if (matrix.length - row - 1 == column) {
                    sum += matrix[row][column];
                }
            }


        }
        return sum;
    }

    private static int getSumOfPrimaryDiagonal(int[][] matrix) {

        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {

                if (row == column) {
                    sum += matrix[row][column];
                }

            }

        }
        return  sum;
    }

    private static void createMatrix(int[][] matrix,Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                matrix[row][column] = scanner.nextInt();

            }

        }
    }
}
