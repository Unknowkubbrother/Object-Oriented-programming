import java.util.ArrayList;
import java.util.Scanner;

public class Lab9_9 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        power a = new power(n);
        for(int i = 0;i<n;i++){
            arr.add(sc.nextInt());
        }
        a.setArr(arr);
        System.out.println(a.getpower());
    }
}

class power{
    private ArrayList<Integer> arr = new ArrayList<Integer>();
    private int sizen;

    public power(int sizen) {
        this.sizen = sizen;
    }

    public void setArr(ArrayList<Integer> arr) {
        this.arr = arr;
    }
    
    public int getpower(){
        int sum = 0;
        ArrayList<Integer> temp = (ArrayList<Integer>) arr.clone();
        int a=0;
        int b=0;
        int max;
        while(temp.size()>1){
            max = 0;
            for(int i=0;i<temp.size()-1;i++){
                if(Math.abs(temp.get(i)-temp.get(i+1))>max){
                    a = i;
                    b = i+1;
                    max = Math.abs(temp.get(i)-temp.get(i+1));
                }else if(Math.abs(temp.get(i)-temp.get(i+1))==max){
                    if(temp.get(a)>temp.get(i)){
                        a=i;
                        b=i+1;
                        max = Math.abs(temp.get(i)-temp.get(i+1));
                    }
                }
            }
            temp.remove(a);
            temp.remove(b-1);
            sum+= max;
        }
        return sum;
    }
    
}
