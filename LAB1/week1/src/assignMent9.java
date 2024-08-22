import java.util.Scanner;

public class assignMent9 {

    public static void main(String[] args){
        int num;
        int max = 0;
        int count = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            num = input.nextInt();
            if (num == 0){
                break;
            }else if (num > max){
                max = num;
                count = 1;
            }else if (num == max){
                count++;
            }
        }

        System.out.println(String.format("%d %d", max, count));

    }
    
}
