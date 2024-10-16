import java.util.Scanner;

public class TornadoNoru {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double spawnX = input.nextDouble();
        double spawnY = input.nextDouble();
        double radius = input.nextDouble();
        double v = input.nextDouble();
        
        int houseCount = input.nextInt();
        int housePos[][] = new int[houseCount][2];
        for (int i = 0; i < houseCount; i++) {
            housePos[i][0] = input.nextInt();
            housePos[i][1] = input.nextInt();
        }

        int broken = 0;

        while (v > 1.0) {
            for (int i = 0; i < houseCount; i++) {
                if (housePos[i][0] == -1 && housePos[i][1] == -1) continue;

                double distance = Math.sqrt(Math.pow(housePos[i][0] - spawnX, 2) + Math.pow(housePos[i][1] - spawnY, 2));
                
                if (distance <= radius) {
                    System.out.println("House at (" + housePos[i][0] + ", " + housePos[i][1] + ") is affected.");
                    broken++;
                    housePos[i][0] = -1;
                    housePos[i][1] = -1;
                }
            }

            spawnX -= v;

            v = v * 0.8;
            radius = radius * 0.8;
        }

        System.out.println("Total houses affected: " + broken);
    }
}


// 457139 1735791 10 15
// 3
// 457139 1735791
// 557139 2735791
// 9 9