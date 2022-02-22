package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class wrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }

        String[] conditions = scanner.nextLine().split("\\s+");
        int coordinateRow = Integer.parseInt(conditions[0]);
        int coordinateCol = Integer.parseInt(conditions[1]);

        int wrongValue = 0;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < matrix[row].length; column++) {

                if (row == coordinateRow && column == coordinateCol) {
                    wrongValue = matrix[row][column];
                    break;
                }
                 break;
            }


        }

        findWrongValuesInMatrix(matrix,wrongValue);
    }

    private static void findWrongValuesInMatrix(int[][] matrix,int wrongNumber) {

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {

                if (matrix[row][column] == wrongNumber) {


                }

            }

        }
    }
}
