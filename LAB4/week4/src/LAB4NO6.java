import java.util.Scanner;

public class LAB4NO6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double[][] A = new double[n][2];
        for (int i = 0; i < n; i++) {
            A[i][0] = input.nextDouble();
            A[i][1] = input.nextDouble();
        }
        input.close(); 
        double near = Math.sqrt(Math.pow(A[1][1] - A[0][1], 2) + Math.pow(A[1][0] - A[0][0], 2));
        for(int i = 0; i < n; i++){
            for (int j = 0 ;j < n; j++){
                double temp = Math.sqrt(Math.pow(A[j][1] - A[i][1], 2) + Math.pow(A[j][0] - A[i][0], 2));
                if (temp < near && temp != 0){
                    near = temp;
                }
            }
        }
        System.out.println(Math.round(near * 100.0) / 100.0);
    }
}

