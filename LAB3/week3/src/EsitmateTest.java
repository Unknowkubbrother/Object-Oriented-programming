import java.util.Scanner;

class Esitmate{
    public static double cal(int i){
        double mi = 0;
        for (int j=1;j<=i;j++){
            mi += (Math.pow(-1, j+1)/(2*j-1));
        }
        return 4*mi;
    }
}


public class EsitmateTest {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        System.out.println(String.format("%.4f", Esitmate.cal(i)));

    }
    
}
