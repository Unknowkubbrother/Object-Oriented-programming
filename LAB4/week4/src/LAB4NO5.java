import java.util.Scanner;

public class LAB4NO5{
    public static void main(String[] args) {
        int[][] matrixOne = MatrixMultiplication.InputNewArray();
        int[][] matrixTwo = MatrixMultiplication.InputNewArray();
        int[][] matrix = MatrixMultiplication.Multi(matrixOne,matrixTwo);
        MatrixMultiplication.printMatrix(matrix);

    }
}

class MatrixMultiplication {
    public static int[][] InputNewArray() {
        Scanner input = new Scanner(System.in);
        int[][] matrix = new int[input.nextInt()][input.nextInt()];      
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j] = input.nextInt();
            }
        }
        input.close();
        return matrix;
    }

    public static int[][] Multi(int[][] matrixOne, int[][] matrixTwo){
        int[][] matrix = new int[matrixOne.length][matrixTwo[0].length];
        for(int i=0;i<matrixOne.length;i++){
            for(int j=0;j<matrixTwo[0].length;j++){
                int sum = 0;
                for(int k=0;k<matrixOne[0].length;k++){
                    sum += matrixOne[i][k] * matrixTwo[k][j]; 
                }
                matrix[i][j] = sum;
            }   
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}