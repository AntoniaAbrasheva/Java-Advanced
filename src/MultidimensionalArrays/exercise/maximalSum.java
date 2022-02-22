package MultidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class maximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][columns];

        fillMatrix(matrix,scanner,rows);

        int maxSum = Integer.MIN_VALUE;

        int startRow = 0;
        int startColumn = 0;

        for (int row = 0; row < rows - 2; row++) {
            for (int column = 0; column < columns - 2; column++) {

                int sum = matrix[row][column] + matrix[row][column + 1] + matrix[row][column + 2] +
                matrix[row + 1][column] + matrix[row + 1][column + 1] + matrix[row + 1][column +2] +
                matrix[row + 2][column] + matrix[row + 2][column + 1] + matrix[row + 2][column + 2];

                if (sum > maxSum) {
                    maxSum = sum;
                    startRow = row;
                    startColumn = column;
                }

            }
        }
        System.out.printf("Sum = %d\n",maxSum);

        for (int row = startRow; row <= startRow + 2; row++) {
            for (int column = startColumn; column <= startColumn + 2; column++) {

                System.out.print(matrix[row][column] + " ");

            }
            System.out.println();

        }

    }

    private static void fillMatrix(int[][] matrix,Scanner scanner,int rows) {

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }
    }
}
