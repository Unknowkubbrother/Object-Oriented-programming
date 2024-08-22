import java.util.Scanner;

public class LAB4NO7{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); // รับค่าจำนวนเต็ม n จากผู้ใช้
        int[] numbers = new int[n]; // สร้างอาร์เรย์ของจำนวนเต็ม

        for (int i = 0; i < n; i++) {
            numbers[i] = input.nextInt(); // รับค่าจำนวนเต็มจากผู้ใช้และเก็บในอาร์เรย์
        }

        MinTwoSet minTwoSet = new MinTwoSet(n, numbers); // สร้างอ็อบเจ็กต์ MinTwoSet
        int minDifference = minTwoSet.findMinDifference(); // คำนวณค่าผลต่างขั้นต่ำ
        System.out.println(minDifference); // แสดงผลลัพธ์

        input.close(); // ปิด Scanner
    }
};

class MinTwoSet{
    private int n; // จำนวนเต็ม n
    private int[] numbers; // อาร์เรย์ของจำนวนเต็ม

    public MinTwoSet(int n, int[] numbers) {
        this.n = n;
        this.numbers = numbers;
    }

    public int findMinDifference() {
        int m = n / 2; // ขนาดของกลุ่ม A
        int totalSum = 0; // ผลรวมของตัวเลขทั้งหมด

        for (int i = 0; i < n; i++) {
            totalSum += numbers[i];
        }

        int targetSum = totalSum / 2; // ผลรวมที่ต้องการให้กลุ่ม A และกลุ่ม B มีค่าเท่ากัน

        boolean[][] dp = new boolean[m + 1][targetSum + 1]; // ตาราง dp ที่ใช้ในการเก็บผลลัพธ์ของปัญหา Subset Sum
        dp[0][0] = true; // กำหนดให้ค่าเริ่มต้นของ dp[0][0] เป็น true

        for (int weight : numbers) {
            for (int j = m; j > 0; j--) {
                for (int k = targetSum; k >= weight; k--) {
                    dp[j][k] |= dp[j - 1][k - weight]; // คำนวณค่าในตาราง dp
                }
            }
        }

        int bestSum = 0; // ผลรวมที่ดีที่สุด
        for (int k = 0; k <= targetSum; k++) {
            if (dp[m][k]) {
                bestSum = k;
            }
        }

        int groupA = bestSum; // ผลรวมของกลุ่ม A
        int groupB = totalSum - groupA; // ผลรวมของกลุ่ม B
        return Math.abs(groupA - groupB); // คืนค่าผลต่างระหว่างกลุ่ม A และกลุ่ม B
    }
}
