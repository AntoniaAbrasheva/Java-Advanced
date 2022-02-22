package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class compareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstMatrixSize = scanner.nextLine().split("\\s+");
        int rowsOfFirstMatrix = Integer.parseInt(firstMatrixSize[0]);
        int columnsOfFirstMatrix = Integer.parseInt(firstMatrixSize[1]);

        int[][] firstMatrix = new int[rowsOfFirstMatrix][columnsOfFirstMatrix];

        for (int row = 0; row < rowsOfFirstMatrix; row++) {

            int[] firstNumbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int column = 0; column < columnsOfFirstMatrix; column++) {

                firstMatrix[row][column] = firstNumbers[column];

            }

        }

        String[] secondMatrixSize = scanner.nextLine().split("\\s+");
        int rowsOfSecondMatrix = Integer.parseInt(secondMatrixSize[0]);
        int columnsOfSecondMatrix = Integer.parseInt(secondMatrixSize[1]);

        int[][] secondMatrix = new int[rowsOfSecondMatrix][columnsOfSecondMatrix];

        for (int row = 0; row < rowsOfSecondMatrix; row++) {

            int[] secondNumbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int column = 0; column < columnsOfSecondMatrix; column++) {

                secondMatrix[row][column] = secondNumbers[column];

            }

        }

        if (rowsOfFirstMatrix != rowsOfSecondMatrix || columnsOfFirstMatrix != columnsOfSecondMatrix) {
            System.out.println("not equal");
            return;
        }

        for (int row = 0; row < rowsOfFirstMatrix; row++) {
            for (int column = 0; column < columnsOfSecondMatrix; column++) {

                if (firstMatrix[row][column] != secondMatrix[row][column]) {
                    System.out.println("not equal");
                    return;
                }

            }

        }

        System.out.println("equal");




    }


}
