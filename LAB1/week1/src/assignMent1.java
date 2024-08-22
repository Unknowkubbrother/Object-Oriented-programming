import java.util.Scanner;

public class assignMent1 {
    
    public static void main(String[] args) {
       double celsius;
       Scanner input = new Scanner(System.in);
       double fh = input.nextDouble();
       celsius = (5.00/9)*(fh-32);
       String text = String.format("Celsius : %fl", celsius);
       System.out.println(text);
    }    
}
