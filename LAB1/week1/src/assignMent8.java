import java.util.Scanner;
import java.lang.Math;

public class assignMent8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input n , a0 and a1: ");
        int n = sc.nextInt();
        double a0 = sc.nextDouble();
        double a1 = sc.nextDouble();
        System.out.println(a0);
        System.out.println(a1);
        double ak = 0;
        int k = 2;
        for(int i = 2 ; i <= n ; i++){
            ak = (Math.pow(k , 2)*a1) - a0 + Math.pow(3 , k);
            System.out.println(ak + " ");
            a0 = a1;
            a1 = ak;
            k++;
        }
    }
    
}