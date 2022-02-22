package MultidimensionalArrays.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixData = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(matrixData[0]);
        int cols = Integer.parseInt(matrixData[1]);

        List<List<Integer>> matrix = new ArrayList<>();
        fillTheMatrix(matrix,rows,cols);

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")){
            String[] commandData =command.split("\\s+");
            int row = Integer.parseInt(commandData[0]);
            int col = Integer.parseInt(commandData[1]);
            int radius = Integer.parseInt(commandData[2]);

            for (int currentRow = row-radius; currentRow <= row+radius ; currentRow++) {
                if(isInMatrix(currentRow,col,matrix) && currentRow!=row){
                    matrix.get(currentRow).remove(col);
                }
            }
            for (int currentCol = col+radius; currentCol >=col-radius ; currentCol--) {
                if(isInMatrix(row,currentCol,matrix)){
                    matrix.get(row).remove(currentCol);
                }
            }


            matrix.removeIf(List::isEmpty);
            command =scanner.nextLine();
        }
        printMatrix(matrix);


    }

    private static boolean isInMatrix( int row, int col, List<List<Integer>> matrix) {
        return row>= 0 && row<matrix.size() && col>=0 && col<matrix.get(row).size();
    }

    private static void fillTheMatrix (List<List<Integer>> matrix,int rows, int cols){
        int n = 1;

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(n++);
            }
        }
    }
    public static void printMatrix (List<List<Integer>> matrix) {
        for(List<Integer> row : matrix){
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
