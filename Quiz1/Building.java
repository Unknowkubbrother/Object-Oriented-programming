import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();  
        for (int i = 1; i <= n; i++) {
            int t = input.nextInt();  
            int[] heights = new int[t];
            for (int j = 0; j < t; j++) {
                heights[j] = input.nextInt(); 
            }
            
            int visibleCount = 1;
            int maxHeight = heights[t - 1]; 
            
            for (int j = 0; j < t; j++) {
                if (heights[t - j - 1] > maxHeight) {
                    visibleCount++;
                    maxHeight = heights[t - j - 1];
                }
            }
            
            System.out.println("Case " + i + ": " + visibleCount);
        }
    }
}

// 3
// 12 1 2 3 4 5 6 7 8 9 10 11 12
// 8 2 13 6 1 7 2 1 3
// 5 15 10 10 9 8
