public class BubbleSort {
    public static void main(String[] args) throws Exception {
       int[] a = {5, 2, 4, 6, 1, 3};

       for(int i = 1;i<a.length;i++){
          for(int j = i ; j>0;j--){
              if(a[j]<a[j-1]){
                  int temp = a[j];
                  a[j] = a[j-1];
                  a[j-1] = temp;
              }
          }
       }

        for(int i = 0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }

       
    }
}
