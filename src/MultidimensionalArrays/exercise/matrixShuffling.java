package MultidimensionalArrays.exercise;

import java.util.Scanner;

public class matrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][columns];

        fillMatrix(matrix,scanner);

        String input = scanner.nextLine();
        while (!input.equals("END")) {

            if (!commandValidator(input,rows,columns)) {

                System.out.println("Invalid input!");
            } else {

                String[] commandParts = input.split("\\s+");

                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);

                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];

                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;
                
                printMatrix(matrix,rows,columns);

            }


            input = scanner.nextLine();
        }


    }

    private static void printMatrix(String[][] matrix,int rows,int columns) {

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                System.out.print(matrix[row][column] + " ");

            }
            System.out.println();
            
        }
    }

    private static boolean commandValidator(String command,int rows,int columns) {

        String[] commandParts = command.split("\\s+");

        if (commandParts.length != 5) {
            return false;
        }

        if (!commandParts[0].equals("swap")) {
            return false;
        }

        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);

        if (row1 < 0 || row1 >= rows || col1 < 0 || col1 >= columns
        || row2 < 0 || row2 >= rows || col2 < 0 || col2 >= columns) {
            return false;
        }

        return true;


    }

    private static void fillMatrix(String[][] matrix,Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {

            matrix[row] = scanner.nextLine().split("\\s+");

        }
    }
}
