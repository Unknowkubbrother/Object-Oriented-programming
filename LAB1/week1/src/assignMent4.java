import java.util.Scanner;

public class assignMent4 {
    public static void main(String[] args) throws Exception {
        double balance;
        double annualInerestRate;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter balance and interest rate (e.g., 3 for 3%): ");
        balance = input.nextDouble();
        annualInerestRate = input.nextDouble();
        double interest = balance * (annualInerestRate / 1200);
        String text = String.format("The interest is %.5f", interest);
        System.out.println(text);

    }
}