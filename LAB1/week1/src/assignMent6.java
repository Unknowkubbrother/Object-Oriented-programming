import java.util.Scanner;

public class assignMent6 {
    public static void main(String[] args){
        int rows;
        int columns;
        Scanner input = new java.util.Scanner(System.in);
        System.out.print("Please input number of columns and rows: ");
        columns = input.nextInt();
        rows = input.nextInt();
        for (int i = 1; i <= rows; i++){
            for (int j = 1; j <= columns; j++){
                if ((i * j) != 1){
                    System.out.print("\t" + (i * j));
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println("");
        }
    }
}
