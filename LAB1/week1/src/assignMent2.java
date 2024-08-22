import java.util.Scanner;

public class assignMent2 {
    
    public static void main(String[] args) {
       double ratePerMonth = 0.05/12;
       double money;
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the monthly saving amount : ");
       money = input.nextDouble();
       double result = 0;
       
       for(int i=0 ; i<6; i++){
           result = (money+result)*(1+ratePerMonth);
       }
       
       String text = String.format("After the sixth month,the account value is $%.2f", result);
       
       System.out.println(text);
   
    }
}
