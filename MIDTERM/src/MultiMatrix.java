public class MultiMatrix {
    public static void main(String[] args) {
        int a[][] = {{1, 2},{-1,0},{3,2}};
        int b[][] = {{1, 5, 2},{-2, 0, 1}};

        int c[][] = new int[a.length][b[0].length];

        for(int i=0;i<a.length;i++){
            for(int j=0;j<b[0].length;j++){
                double sum = 0;
                for(int k=0;k<a[0].length;k++){
                    sum += a[i][k]*b[k][j];
                }
                c[i][j] = (int)sum;
            }
        }

        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[0].length;j++){
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
    }
}
