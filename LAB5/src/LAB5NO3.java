import java.util.ArrayList;
import java.util.Scanner;
public class LAB5NO3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        int num;
        int flag = 0;
        do{
            num = input.nextInt();
            if(num == 0){
                if (flag == 0){
                    flag = 1;
                    num = -1;
                }else{
                    break;
                }
            }
            if(flag == 0){
                list1.add(num);
            }else{
                list2.add(num);
            }
        }while (num != 0);
        ArrayList<Integer> temp = SortMergeList.intersect(list1, list2);
        for(int i=0;i<temp.size();i++){
            System.out.print(temp.get(i)+" ");
        }
    }
    
}

class SortMergeList{
    public static ArrayList<Integer> intersect(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> temp = new ArrayList<Integer>();

        for(int i=0;i<list1.size();i++){
            for(int j=0;j<list2.size();j++){
                if (list1.get(i) == list2.get(j)){
                    temp.add(list1.get(i));
                }
            }
        }
        
        return temp;
    }
}