import java.util.Scanner;

public class Lab7_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        int[][] arr = new int[n][m];
        n=sc.nextInt();
        m=sc.nextInt();
        int[] start ={n-1,m-1};
        n=sc.nextInt();
        m=sc.nextInt();
        int[] end ={n-1,m-1};
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int bomb=0;
        int min=1000;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                int round = 1;
                if(arr[i][j]==0){
                    arr[i][j]=1;
                    int[] result = {start[0],start[1]};
                    maze.sizeh = 0;
                    while(result[0]!=end[0]||result[1]!=end[1]){
                        result = maze.step(result, end, arr);
                        if(result[0]==-1){
                            break;
                        }
                        round++;
                    }
                    if(result[0]!=-1){
                        if(round<min){
                            min = round;
                        }
                        bomb++;
                    }
                    if(result[0]==-1){
                        for(int a=0;a<arr.length;a++){
                            for(int b=0;b<arr[a].length;b++){
                                round = 1;
                                if(arr[a][b]==1){
                                    arr[a][b]=0;
                                    int[] results = {start[0],start[1]};
                                    maze.sizeh = 0;
                                    while(results[0]!=end[0]||results[1]!=end[1]){
                                        results = maze.step(results, end, arr);
                                        if(results[0]==-1){
                                            break;
                                        }
                                        round++;
                                    }
                                    if(results[0]!=-1){
                                        if(round<min){
                                            min = round;
                                        }
                                        bomb++;
                                    }
                                    arr[a][b] = 1;
                                    }
                            }
                        }
                    }
                    arr[i][j] = 0;
                }
            }
        }
        System.out.println(bomb);
        System.out.println(min);
        
    }
}

class maze{
    public static int[][] histroy = new int[100][2];
    public static int sizeh=0;
    public static int[] step(int[] start,int[] end,int[][] arr){
        int[] result = {-1,-1};
        double minout=1000;
        start[1]+=1;
        if(start[1]<arr[start[0]].length&&arr[start[0]][start[1]]!=0 && !(find(start[0], start[1]))&& distand(start, end)<minout){
            result[0]=start[0];
            result[1]=start[1];
            minout = distand(start, end);
            histroy[sizeh][0]= result[0];
            histroy[sizeh][1]= result[1];
            sizeh+=1;
        }
        start[1]-=1;
        start[0]+=1;
        if(start[0]<arr.length&&arr[start[0]][start[1]]!=0 && !(find(start[0], start[1]))&& distand(start, end)<minout){
            result[0]=start[0];
            result[1]=start[1];
            minout = distand(start, end);
            histroy[sizeh][0]= result[0];
            histroy[sizeh][1]= result[1];
            sizeh+=1;
        }
        start[0]-=1;
        start[0]-=1;
        if(start[0]>=0&&arr[start[0]][start[1]]!=0 && !(find(start[0], start[1]))&& distand(start, end)<minout){
            result[0]=start[0];
            result[1]=start[1];
            minout = distand(start, end);
            histroy[sizeh][0]= result[0];
            histroy[sizeh][1]= result[1];
            sizeh+=1;
        }
        start[0]+=1;
        start[1]-=1;
        if(start[1]>=0&&arr[start[0]][start[1]]!=0 && !(find(start[0], start[1]))&& distand(start, end)<minout){
            result[0]=start[0];
            result[1]=start[1];
            histroy[sizeh][0]= result[0];
            histroy[sizeh][1]= result[1];
            sizeh+=1;
        }
        start[1]+=1;
        return result;
    }
    public static boolean find(int n,int m){
        for(int i=0;i<sizeh;i++){
            if(histroy[i][0]==n&&histroy[i][1]==m){
                return true;
            }
        }
        return false;
    }
    
    public static double distand(int[] start,int[] end){
        return Math.sqrt(Math.pow(start[0]-end[0], 2)+Math.pow(start[1]-end[1], 2));
    }
}
