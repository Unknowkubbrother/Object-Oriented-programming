import java.util.ArrayList;
import java.util.Scanner;
public class LAB5NO2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Star star = new Star();
        do{
            String text = input.nextLine();
            if (text.equals("exit")){
                break;
            }else{
                if(text.charAt(0) == '1'){;
                    System.out.println(star.addStar());
                }else if(text.charAt(0) == '2'){
                    System.out.println(star.removeStar());
                }else{
                    star.addText(text);
                }
            }
        }while(true);
    }
    
}

class Star{
    private ArrayList<String> arr;

    public Star(){
        arr = new ArrayList<String>();
    }

    public void addText(String text){
        arr.add(text);
    }

    public ArrayList<String> addStar(){
        ArrayList<String> temp = new ArrayList<String>();
        for(int i=0;i<arr.size();i++){
            temp.add(arr.get(i));
            temp.add("*");
        }
        return temp;
    }

    public ArrayList<String>  removeStar(){
        return arr;
    }
}
