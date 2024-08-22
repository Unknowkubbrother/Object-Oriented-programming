public class LAB6NO8 {
    public static void main(String[] args) {
        System.out.println(contains(new Line(1,1,5,5),new Rectangle(10, 10, 0, 6)));
        System.out.println(cross(new Line(1,1,5,5),new Line(5,1,1,5)));
        System.out.println(overlaps(new Rectangle(10, 10, 0, 6),new Rectangle(10, 10, 1, 3)));
        System.out.println(distance(new Line(1,1,5,5), new Rectangle(10, 10, 0, 6)));
    }

    public static int contains(Line a,Rectangle b){
        double xrect = b.x+b.width;
        double yrect = b.y-b.height;
        if(a.x1>=b.x&&a.x1<=xrect&&a.y1<=b.y&&a.y1>=yrect&&a.x2>=b.x&&a.x2<=xrect&&a.y2<=b.y&&a.y2>=yrect){
            return 1;
        }
        return 0;
    }

    public static int cross(Line a,Line b){
        double m1 = (a.y1-a.y2)/(a.x1-a.x2);
        double c1 = a.y1-a.x1*m1;
        double m2 = (b.y1-b.y2)/(b.x1-b.x2);
        double c2 = b.y1-b.x1*m2;
        for(double i = a.x1;i<=a.x2;i++){
            if(i*m1+c1==i*m2+c2){
                return 1;
            }
        }
        return 0;
    }

    public static int overlaps(Rectangle a,Rectangle b){
        double xarect = a.x+a.width;
        double yarect = a.y-a.height;
        double xbrect = b.x+b.width;
        double ybrect = b.y-b.height;
        if((xarect>=b.x&&xarect<=xbrect)||(a.x>=b.x&&a.x<=xbrect)||(xbrect>=a.x&&xbrect<=xarect)||(b.x>=a.x&&b.x<=xarect)){
            if((yarect<=b.y&&yarect>=ybrect)||(a.y<=b.y&&a.y>=ybrect)||(ybrect<=a.y&&ybrect>=yarect)||(b.y<=a.y&&b.y>=yarect)){
                return 1;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }
    public static double distance(Line a, Rectangle b){
        double xl = (a.x1+a.x2)/2;
        double yl = (a.y1+a.y2)/2;
        double xr = (b.x+b.width)/2;
        double yr = (b.y-b.height)/2;
        return Math.sqrt(Math.pow(xl-xr, 2)+Math.pow(yl-yr, 2));
    }

    
}

class Rectangle{
    public double width;
    public double height;
    public double x;
    public double y;

    public Rectangle() {
    }

    public Rectangle(double width, double height, double x, double y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }
    public double getArea(Rectangle a){
        return a.width*a.height;
    }
}

class Line{
    public double x1;
    public double y1;
    public double x2;
    public double y2;

    public Line() {
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public double getLong(Line a){
        return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
    }
}