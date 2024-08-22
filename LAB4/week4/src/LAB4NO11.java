import java.util.Scanner;

public class LAB4NO11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),m=sc.nextInt();
        int sizenum=0;
        char arr[][] = new char[n][m];
        boolean check[][] = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                arr[i][j] = sc.next().charAt(0);
                check[i][j]=false;
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(arr[i][j]=='@'&&check[i][j]==false){
                    sizenum++;
                    check[i][j]=true;
                    int[] x= new int[n*m],y=new int[n*m];
                    int num = -1;
                    for(int xi=i-1;xi<=i+1;xi++){
                        for(int xj=j-1;xj<=j+1;xj++){
                            if(xi<0||xj<0||xi>=n||xj>=m){
                                continue;
                            }
                            if(arr[xi][xj]=='@'&&check[xi][xj]==false){
                                check[xi][xj]=true;
                                num++;
                                x[num] = xi;
                                y[num] = xj;
                            }
                        }
                    }
                    for(int xn=0;xn<=num;xn++){
                        if(arr[x[xn]][y[xn]]=='@'){
                                check[x[xn]][y[xn]]=true;
                                for(int xi=x[xn]-1;xi<=x[xn]+1;xi++){
                                    for(int xj=y[xn]-1;xj<=y[xn]+1;xj++){
                                        if(xi<0||xj<0||xi>=n||xj>=m){
                                            continue;
                                        }
                                        if(arr[xi][xj]=='@'&&check[xi][xj]==false){
                                            check[xi][xj]=true;
                                            num++;
                                            x[num] = xi;
                                            y[num] = xj;
                                        }
                                    }
                                }
                        }
                    }
                    
                }
            }
        }
        System.out.println(sizenum);
    }
    
}
