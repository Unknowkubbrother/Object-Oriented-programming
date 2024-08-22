import java.util.Scanner;

public class LAB4NO9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int col = input.nextInt();
        int[][] arr = new int[row][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        input.close();
        if (isConsecutiveFour(arr)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    public static boolean isConsecutiveFour(int[][] values) {
        int numRows = values.length;
        int numCols = values[0].length;

        // Check rows
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col <= numCols - 4; col++) {
                int current = values[row][col];
                if (current == values[row][col + 1] &&
                        current == values[row][col + 2] &&
                        current == values[row][col + 3]) {
                    return true;
                }
            }
        }

        // Check columns
        for (int col = 0; col < numCols; col++) {
            for (int row = 0; row <= numRows - 4; row++) {
                int current = values[row][col];
                if (current == values[row + 1][col] &&
                        current == values[row + 2][col] &&
                        current == values[row + 3][col]) {
                    return true;
                }
            }
        }

        // Check diagonals (top-left to bottom-right)
        for (int row = 0; row <= numRows - 4; row++) {
            for (int col = 0; col <= numCols - 4; col++) {
                int current = values[row][col];
                if (current == values[row + 1][col + 1] &&
                        current == values[row + 2][col + 2] &&
                        current == values[row + 3][col + 3]) {
                    return true;
                }
            }
        }

        // Check diagonals (bottom-left to top-right)
        for (int row = 3; row < numRows; row++) {
            for (int col = 0; col <= numCols - 4; col++) {
                int current = values[row][col];
                if (current == values[row - 1][col + 1] &&
                        current == values[row - 2][col + 2] &&
                        current == values[row - 3][col + 3]) {
                    return true;
                }
            }
        }

        return false;
    }
}
