import java.util.Scanner;

public class LAB4NO8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int H = input.nextInt();
        int W = input.nextInt();
        int[][] arr = new int[H][W];
        for(int i=0; i< arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                arr[i][j] = input.nextInt();
            }
        }
        input.close();
        int sumarr = 0;
        int[] diff = new int[3];
        for(int i=0; i< arr.length - 1; i++){
            for(int j=0; j<arr[i].length; j++){
                int tempdiff = Math.abs(arr[i+1][j] - arr[i][j]);
                int tempsum = arr[i+1][j] + arr[i][j];
                if(tempsum > sumarr && tempdiff >= 0 && tempdiff <= 10){
                    diff[0] = tempdiff;
                    diff[1] = i;
                    diff[2] = j;
                    sumarr = tempsum;
                }
            }
        }
        System.out.println(diff[1]+1 + " " + (diff[2]+1));
    }
    
}