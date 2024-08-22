public class LAB6NO7 {
    public static void main(String[] args) {
        MyRectangle2D r = new MyRectangle2D();
        System.out.println(r.getArea());
    }
}

class MyRectangle2D{
    private double x;
    private double y;
    private double width;
    private double height;

    public MyRectangle2D() {
        x=0;
        y=0;
        width = 1;
        height = 1;
    }

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    public double getArea(){
        return width*height;
    }
    public double getPerimeter(){
        return width*2+height*2;
    }
    public boolean contains(double x,double y){
        double x1 = this.x-width/2;
        double x2 = this.x+width/2;
        double y1 = this.y+height/2;
        double y2 = this.y-height/2;
        if(x>=x1&&x<=x2&&y>=y2&&y<=y1){
            return true;
        }
        return false;
    }
    public boolean contains(MyRectangle2D r){
        double x1 = this.x-width/2;
        double x2 = this.x+width/2;
        double y1 = this.y+height/2;
        double y2 = this.y-height/2;
        double rx1 = r.x-r.width/2;
        double rx2 = r.x+r.width/2;
        double ry1 = r.y+height/2;
        double ry2 = r.y-height/2;
        
        if(rx1>=x1&&rx1<=x2&&rx2>=x1&&rx2<=x2&&ry1<=y1&&ry1>=y2&&ry2<=y1&&ry2>=y2){
            return true;
        }
        return false;
    }
    
    public boolean overlaps(MyRectangle2D r){
        double x1 = this.x-width/2;
        double x2 = this.x+width/2;
        double y1 = this.y+height/2;
        double y2 = this.y-height/2;
        double rx1 = r.x-r.width/2;
        double rx2 = r.x+r.width/2;
        double ry1 = r.y+height/2;
        double ry2 = r.y-height/2;
        
        if((rx1>=x1&&rx1<=x2)||(rx2>=x1&&rx2<=x2)){
            if((ry1<=y1&&ry1>=y2)||(ry2<=y1&&ry2>=y2)){
             return true;
            }
        }
        return false;
    }
    
}