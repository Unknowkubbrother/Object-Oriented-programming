import java.util.Scanner;

class Square {
    private double x;
    private double y;
    private double width;
    private double height;

    public Square(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int CheckX(Square box) {
        double check_width = this.width / 2.0;
        double check_x_max = this.x + check_width;
        double check_x_min = this.x - check_width;
        int check_x_dot;
        double check_box_width = box.width / 2.0;
        double check_box_x_max = box.x + check_box_width;
        double check_box_x_min = box.x - check_box_width;
        
        if (box.x <= check_x_max && box.x >= check_x_min) {
            check_x_dot = 1;
            if (check_x_max >= check_box_x_max && check_x_min <= check_box_x_min) {
                return check_x_dot;
            } else {
                check_x_dot = 2;
                return check_x_dot;
            }
        } else {
            check_x_dot = 3;
            if ((check_box_x_min <= check_x_max && check_box_x_min >= check_x_min)
                    || (check_box_x_max >= check_x_min && check_box_x_max <= check_x_max)) {
                return check_x_dot;
            } else {
                return -1;
            }
        }
    }

    public int CheckY(Square box) {
        double check_height = this.height / 2.0;
        double check_y_max = this.y + check_height;
        double check_y_min = this.y - check_height;
        int check_y_dot;
        double check_box_height = box.height / 2.0;
        double check_box_y_max = box.y + check_box_height;
        double check_box_y_min = box.y - check_box_height;
        
        if (box.y <= check_y_max && box.y >= check_y_min) {
            check_y_dot = 1;
            if (check_y_max >= check_box_y_max && check_y_min <= check_box_y_min) {
                return check_y_dot;
            } else {
                check_y_dot = 2;
                return check_y_dot;
            }
        } else {
            check_y_dot = 3;
            if ((check_box_y_min <= check_y_max && check_box_y_min >= check_y_min)
                    || (check_box_y_max >= check_y_min && check_box_y_max <= check_y_max)) {
                return check_y_dot;
            } else {
                return -1;
            }
        }
    }
}

public class SquareTest {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter r1's center x-, y-coordinates, widthm and height: ");
        double centerX1 = input.nextDouble();
        double centerY1 = input.nextDouble();
        double Width1 = input.nextDouble();
        double Height1 = input.nextDouble();
        Square square = new Square(centerX1, centerY1, Width1, Height1);
        System.out.print("Enter r2's center x-, y-coordinates, widthm and height: ");
        double centerX2 = input.nextDouble();
        double centerY2 = input.nextDouble();
        double Width2 = input.nextDouble();
        double Height2 = input.nextDouble();
        Square square2 = new Square(centerX2, centerY2, Width2, Height2);
        int checkX = square.CheckX(square2);
        int checkY = square.CheckY(square2);
        if (checkX == 1 && checkY == 1) {
            System.out.println("r2 is inside r1");
        } else if (checkX == 2 || checkX == 3 || checkY == 2 || checkY == 3) {
            System.out.println("r2 is overlapping r1");
        } else {
            System.out.println("r2 is outside r1");
        }
    }
}
