import java.util.Scanner;
public class LightTest {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        Light l1 = new Light(n,m);
        l1.addPlane();
        l1.addLight();
        l1.countLight();
        System.out.println(l1.getCount());
    }
    
}

class Light{
    private int count = 0;
    private int[][] N;
    private int[] M;
    public Scanner input = new Scanner(System.in);


    public Light(int n, int m){
        this.N = new int[n][2];
        this.M = new int[m];
    }

    public int getCount(){
        return count;
    }

    public void addPlane(){
        for(int i=0;i<N.length;i++){
           for(int j=0;j<N[i].length;j++){
               N[i][j] = input.nextInt();
           }
        }
    }

    public void addLight(){
        for(int i=0;i<M.length;i++){
            M[i] = input.nextInt();
        }
    }

    public void countLight(){
        for(int i=0;i<N.length;i++){
            for(int j=0;j<M.length;j++){
                if(N[i][0] < M[j] && M[j] < N[i][1]){
                    count++;
                }
            }
        }
    }


}
