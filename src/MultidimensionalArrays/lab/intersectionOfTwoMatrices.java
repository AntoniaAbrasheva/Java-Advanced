package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class intersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][columns];

        for (int row = 0; row < rows; row++) {

            String[] firstSymbols = scanner.nextLine().split("\\s+");

            for (int column= 0; column < columns; column++) {

                firstMatrix[row][column] = firstSymbols[column].charAt(0);

            }
        }

        char[][] secondMatrix = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            String[] secondSymbols = scanner.nextLine().split("\\s+");

            for (int column = 0; column < columns; column++) {

                secondMatrix[row][column] = secondSymbols[column].charAt(0);

            }

        }

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                if (firstMatrix[row][column] == secondMatrix[row][column]) {

                    System.out.print(firstMatrix[row][column] + " ");
                } else {
                    System.out.print("* ");
                }

            }
            System.out.println();

        }
    }
}
