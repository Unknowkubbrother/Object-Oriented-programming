import java.util.Scanner;

public class assignMent7 {

    static int sumPow(int x, int n){
        if (n == 0){
            return 1;
        }else{
            return (int)Math.pow(x, n) + sumPow(x, n-1);
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please input x, n: ");
        int result = sumPow(input.nextInt(), input.nextInt());
        System.out.println(String.format("Output is %d", result));
    }

}
