import java.util.Scanner;

public class FindTreasure {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.nextInt();
            }
        }

        int max = 0;
        int pos[] = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Check right
                if (j < m - 1 && arr[i][j] + arr[i][j + 1] > max && Math.abs(arr[i][j] - arr[i][j + 1]) <= 10) {
                    max = arr[i][j] + arr[i][j + 1];
                    pos[0] = i + 1;
                    pos[1] = j + 1;
                }
                // Check down
                if (i < n - 1 && arr[i][j] + arr[i + 1][j] > max && Math.abs(arr[i][j] - arr[i + 1][j]) <= 10) {
                    max = arr[i][j] + arr[i + 1][j];
                    pos[0] = i + 1;
                    pos[1] = j + 1;
                }
            }
        }

        System.out.println(pos[0] + " " + pos[1]);
    }
}


// 4 5
// 5 1 2 10 4
// 4 30 3 0 100
// 3 25 10 4 10
// 3 20 4 8 5


// 4 4
// 0 0 0 0
// 0 0 0 0
// 0 1 1 1
// 1 1 0 0