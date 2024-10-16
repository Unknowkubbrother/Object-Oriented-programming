import java.util.Scanner;
public class Rotate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        char arr[][] = new char[n][n];
        input.nextLine(); // Consume the newline character after the integer input
        for(int i=0; i<n; i++) {
            String line = input.nextLine();
            for(int j=0; j<n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int countRotate = input.nextInt();
        for (int i = 0; i < countRotate; i++) {
            int rotate = input.nextInt();
            if (rotate == 1) {
                arr = rotateRight(arr);
            } else if (rotate == -1) {
                arr = rotateLeft(arr);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static char[][] rotateRight(char arr[][]){
        int n = arr.length;
        char temp[][] = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                temp[j][n-i-1] = arr[i][j];
            }
        }
        return temp;
    }

    public static char[][] rotateLeft(char arr[][]){
        int n = arr.length;
        char temp[][] = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                temp[n-j-1][i] = arr[i][j];
            }
        }
        return temp;
    }
}

// 2
// AI
// ZU
// 2
// 1
// 1


// 3
// xOO
// OOy
// OOO
// 1
// -1

// 5
// ABCDE
// FGHIJ
// KLMNO
// PQRST
// UVWXY
// 1
// 1