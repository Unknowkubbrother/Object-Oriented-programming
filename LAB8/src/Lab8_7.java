import java.util.Scanner;

public class Lab8_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),m=sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            int s=sc.nextInt();
            arr[i][0]=s;
            for(int j=1;j<=s;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        n = sc.nextInt();
        int[][] qus = new int[n][2];
        for(int i =0;i<n;i++){
            qus[i][0]= sc.nextInt();
            qus[i][1] = sc.nextInt();
        }
        
        for(int i =0;i<n;i++){
            int[][] temp = arr.clone();
            if(station.findstation(arr, qus[i][0])==-1||station.findstation(arr, qus[i][1])==-1){
                System.out.println("impossible");
                continue;
            }
            int check=0;
            int sta = station.findstation(arr, qus[i][0]);
            for(int j=1;j<=arr[sta][0];j++){
                if(arr[sta][j]==qus[i][1]){
                    System.out.println(0);
                    check=1;
                    break;
                }
            }
            if(check==1){
                continue;
            }
            
            for(int j=1;j<=arr[sta][0];j++){
                if(arr[sta][j]!=qus[i][0]){
                    int round = 0;
                    check = 0;
                    while(check!=2&&check!=1){
                        if(station.nextstation(arr, arr[sta][j], sta)==-1){
                            check=1;
                        }else{
                            sta = station.nextstation(arr, arr[sta][j], sta);
                            round++;
                            if(station.endstation(arr, qus[i][1], sta)==1){
                                check=2;
                            }else{
                                check=1;
                                for(int a=1;a<=arr[sta][0];a++){
                                    int temps = sta;
                                    if(station.nextstation(arr, arr[sta][a], sta)!=-1){
                                        sta = station.nextstation(arr, arr[sta][a], sta);
                                        if(station.endstation(arr, qus[i][1], sta)==1){
                                            check=2;
                                            break;
                                        }else{
                                            sta = temps;
                                        }
                                    }
                                }
                                round++;
                            }
                        }
                    }
                    sta = station.findstation(arr, qus[i][0]);
                    if(check==2){
                        System.out.println(round);
                        break;
                    }
                    
                }
            }
            
            if(check==2){
                continue;
            }
            
            System.out.println("impossible");
        }
        
    }
}

class station{
    public static int findstation(int[][] arr,int n){
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<=arr[i][0];j++){
                if(arr[i][j]==n){
                    return i;
                }
            }
        }
        return -1;
    }
    public static int nextstation(int[][] arr,int n,int s){
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<=arr[i][0];j++){
                if(arr[i][j]==n&&i!=s){
                    return i;
                }
            }
        }
        return -1;
    }
    public static int endstation(int[][] arr,int n,int s){
        for(int j=1;j<=arr[s][0];j++){
                if(arr[s][j]==n){
                    return 1;
                }
        }
        return -1;
    }
}
