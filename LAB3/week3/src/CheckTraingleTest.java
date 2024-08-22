import java.util.Scanner;

public class CheckTraingleTest {
    public static void main(String[] args) {
        double x0, y0, x1, y1, x2, y2;
        Scanner input = new Scanner(System.in);
        x0 = input.nextDouble();
        y0 = input.nextDouble();
        x1 = input.nextDouble();
        y1 = input.nextDouble();
        x2 = input.nextDouble();
        y2 = input.nextDouble();
        input.close();
        if (CheckTraingle.leftOfTheLine(x0, y0, x1, y1, x2, y2)) {
            System.out.println(2);
        } 
        else if (CheckTraingle.onTheSameLine(x0, y0, x1, y1, x2, y2)) {
            System.out.println(0);
        } 
        else if (CheckTraingle.RightOfTheLine(x0, y0, x1, y1, x2, y2)) {
            System.out.println(1);
        }
        else if (CheckTraingle.onTheLineSegment(x0, y0, x1, y1, x2, y2)) {
            System.out.println(3);
        }
    }
}

class CheckTraingle{
    public static boolean leftOfTheLine(double x0, double y0, double x1, double y1, double x2, double y2){
        return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) > 0;
    }

    public static boolean onTheSameLine(double x0, double y0, double x1, double y1, double x2, double y2){
        return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) == 0;
    }

    public static boolean onTheLineSegment(double x0, double y0, double x1, double y1, double x2, double y2){
        return onTheSameLine(x0, y0, x1, y1, x2, y2) && (x2 >= Math.min(x0, x1) && x2 <= Math.max(x0, x1) && y2 >= Math.min(y0, y1) && y2 <= Math.max(y0, y1));
    }

    public static boolean RightOfTheLine(double x0, double y0, double x1, double y1, double x2, double y2){
        return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) < 0;
    }
}
