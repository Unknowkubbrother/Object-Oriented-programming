import java.util.Scanner;

public class PalindromeTest {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String text1 = input.nextLine();
        input.close();
        text1 = text1.replaceAll("[^a-zA-Z0-9]", "").replace(" ","");
        System.out.println(isPalindrome(text1) ? 1 : 0);
    }

    public static boolean isPalindrome(String s) {
        int length = s.length();
        for (int i=0; i<(int)(length/2);i++){
            if (s.charAt(i) != s.charAt(length-1-i)){
                return false;
            }
        }
        return true;
    }
    
}