package exams.retakeExam_15122021;

import java.util.Scanner;

public class throneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int numberRows = Integer.parseInt(scanner.nextLine());

        String [][] matrix = readMatrix(numberRows,scanner);

        int parisRow =-1;
        int parisCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            boolean isFound = false;
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("P")){
                    parisRow = row;
                    parisCol=col;
                    isFound = true;
                    break;
                }
            }
            if (isFound){
                break;
            }
        }
        boolean isFinished = false;
        while (!isFinished){
            String[] lines = scanner.nextLine().split("\\s+");

            String move = lines[0];
            int row =Integer.parseInt(lines[1]);
            int column = Integer.parseInt(lines[2]);

            matrix[row][column] = "S";

            switch (move){
                case "up":
                    if (parisRow - 1 < 0){
                        energy--;
                        break;
                    }else {
                        parisRow--;
                        matrix[parisRow + 1][parisCol] = "-";
                        if (matrix[parisRow][parisCol].equals("S")){
                            energy -= 2;
                        }else if (matrix[parisRow][parisCol].equals("H")){
                            energy--;
                            matrix[parisRow][parisCol] = "-";
                            isFinished = true;
                            break;
                        }
                        matrix[parisRow][parisCol] = "P";
                        energy--;
                    }
                    if (energy <= 0){
                        matrix[parisRow][parisCol] = "X";
                        isFinished = true;
                    }
                    break;
                case "down":
                    if (parisRow + 1 >= matrix.length){
                        energy--;
                        break;
                    }else {
                        parisRow++;
                        matrix[parisRow - 1][parisCol] = "-";
                        if (matrix[parisRow][parisCol].equals("S")){
                            energy -= 2;
                        }else if (matrix[parisRow][parisCol].equals("H")){
                            energy--;
                            matrix[parisRow][parisCol] = "-";
                            isFinished = true;
                            break;
                        }
                        matrix[parisRow][parisCol] = "P";
                        energy--;
                    }
                    if (energy <= 0){
                        matrix[parisRow][parisCol] = "X";
                        isFinished = true;
                    }
                    break;
                case "left":
                    if (parisCol - 1 <0) {
                        energy--;
                        break;
                    }else {
                        parisCol--;
                        matrix[parisRow][parisCol + 1]="-";
                        if (matrix[parisRow][parisCol].equals("S")){
                            energy -= 2;
                        }else if (matrix[parisRow][parisCol].equals("H")){
                            energy--;
                            matrix[parisRow][parisCol] = "-";
                            isFinished = true;
                            break;
                        }
                        matrix[parisRow][parisCol] = "P";
                        energy--;
                    }
                    if (energy <= 0){
                        matrix[parisRow][parisCol] ="X";
                        isFinished = true;
                    }
                    break;
                case "right":
                    if (parisCol + 1 >= matrix[parisRow].length){
                        energy--;
                        break;
                    }else {
                        parisCol++;
                        matrix[parisRow][parisCol-1] = "-";
                        if (matrix[parisRow][parisCol].equals("S")){
                            energy -= 2;
                        }else if (matrix[parisRow][parisCol].equals("H")){
                            matrix[parisRow][parisCol] = "-";
                            energy--;
                            isFinished = true;
                            break;
                        }
                        matrix[parisRow][parisCol] = "P";
                        energy--;
                    }
                    if (energy <= 0){
                        matrix[parisRow][parisCol] = "X";
                        isFinished = true;
                    }
                    break;
            }
        }
        if (energy <= 0){
            System.out.printf("Paris died at %d;%d.\n",parisRow,parisCol);
            printMatrix(matrix);

        }else{
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d\n",energy);
            printMatrix(matrix);
        }

    }

    public static String[][] readMatrix(int rows, Scanner scanner) {
        String[][] matrix = new String[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] =scanner.nextLine().split("");
        }
        return matrix;
    }

    public static void printMatrix(String[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}


