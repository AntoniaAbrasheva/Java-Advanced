package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class sumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] dimensionsOfMatrix = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensionsOfMatrix[0]);
        int columns = Integer.parseInt(dimensionsOfMatrix[1]);

        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int column = 0; column < columns; column++) {
                matrix[row][column] = numbers[column];

            }

        }

        int sum = 0;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                sum += matrix[row][column];

            }

        }

        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum);
    }
}
