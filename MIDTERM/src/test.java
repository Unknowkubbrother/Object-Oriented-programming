import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> arrInt = new ArrayList<>();
        arrInt.add(1); // Boxing
        int x = arrInt.get(0); // Unboxing
        System.out.println(x);
    }

    public static void change(Integer a) {
        a = 2; 
      }


}