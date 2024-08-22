import java.util.Scanner;
public class LAB5NO4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] arr;
        int row = input.nextInt();
        int col = input.nextInt();
        arr = new int[row][col];
        int k = input.nextInt();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] = input.nextInt();
            }
        }
        int ans = 0;
        for(int i=0;i<arr.length-k+1;i++){
            for(int j=0;j<arr[i].length-k+1;j++){
                int sum = 0;
                if (k == 1){
                    sum = arr[i][j];
                }else{
                    sum+=arr[i][j]+arr[i][j+1]+arr[i+1][j]+arr[i+1][j+1]; 
                }
                if (sum >= ans){
                    ans = sum;
                }
            }
        }
        System.out.println(ans);
    }
}
