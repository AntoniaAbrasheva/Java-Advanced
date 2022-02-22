package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class positionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizeOfMatrix = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(sizeOfMatrix[0]);
        int columns = Integer.parseInt(sizeOfMatrix[1]);



        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int column = 0; column < columns; column++) {
                matrix[row][column] = numbers[column];

            }

        }
        int num = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                if (matrix[row][column] == num) {
                    isFound = true;
                    System.out.printf("%d %d\n",row,column);
                }

            }

        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
