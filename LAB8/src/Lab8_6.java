
public class Lab8_6 {
    public static void main(String[] args) {
        
    }
}

interface Movable{
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}

class MoveablePoint implements Movable{
    int x;
    int y;
    int xSpeed;
    int ySpeed;
    
    public String MovablePoint(int x,int y,int xSpeed,int ySpeed){
        return "";
    }

    @Override
    public String toString() {
        return "";
    }
    
    
    
    @Override
    public void moveUp() {
        
    }

    @Override
    public void moveDown() {
        
    }

    @Override
    public void moveLeft() {
        
    }

    @Override
    public void moveRight() {
        
    }
    
}

class MovableCircle implements Movable{
    int radius;
    MoveablePoint movepoint;
    
    public String MovableCircle(int x,int y,int xSpeed,int ySpeed){
        return "";
    }

    @Override
    public String toString() {
        return "";
    }
    
    @Override
    public void moveUp() {
        
    }

    @Override
    public void moveDown() {
        
    }

    @Override
    public void moveLeft() {
        
    }

    @Override
    public void moveRight() {
        
    }
    
}