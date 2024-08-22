import java.util.Scanner;

public class LAB4NO10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[][] arr = new int[t][m];
        int[] path = new int[t];
        for(int i =0;i<t;i++){
            for(int j = 0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        Car(m,n,t,arr,path);
        for(int i = 0;i<t;i++){
            System.out.println(path[i]);
        }
    }
    
    public static void Car(int m,int n,int t,int[][] arr,int[] path){
        int check = 0;
        for(int j = 0;j<m;j++){
            if(arr[t-1][j]==0){
                    int len = j;
                    check = 1;
                    for(int s=t-1;s>=0;s--){
                        if(s-1<0){
                            if(len<n-1){
                                path[s]=1;
                            }else if(len>n-1){
                                path[s]=2;
                            }else{
                                path[s] = 3;
                            }
                            continue;
                        }
                        if(len<n-1){
                            if(len+1<arr[s-1].length&&arr[s-1][len+1]==0){
                                len++;
                                path[s]=1;
                                continue;
                            }
                            if(arr[s-1][len]==0){
                                path[s]=3;
                                continue;
                            }
                            if(len-1>=0&&arr[s-1][len-1]==0){
                                len--;
                                path[s]=2;
                                continue;
                            }
                            check = 0;
                            break;
                        }else if(len>n-1){
                            if(len-1>=0&&arr[s-1][len-1]==0){
                                len--;
                                path[s]=2;
                                continue;
                            }
                            if(arr[s-1][len]==0){
                                path[s]=3;
                                continue;
                            }
                            if(len+1<arr[s-1].length&&arr[s-1][len+1]==0){
                                len++;
                                path[s]=1;
                                continue;
                            }
                            check = 0;
                            break;
                        }else if(len==n-1){
                            if(arr[s-1][len]==0){
                                path[s]=3;
                                continue;
                            }
                            if(len+1<arr[s-1].length&&arr[s-1][len+1]==0){
                                len++;
                                path[s]=1;
                                continue;
                            }
                            if(len-1>=0&&arr[s-1][len-1]==0){
                                len--;
                                path[s]=2;
                                continue;
                            }
                            check = 0;
                            break;
                        }
                    }
            }
            if(check==1){
                break;
            }
        }
    }
}
