
import java.lang.Cloneable; 

public class Polymorphishm {
    public static void main(String[] args) throws CloneNotSupportedException {
        A b1 = new B();
        A b2 = (A)b1.clone();
        b1.a();
        b2.a();
        System.out.println(b1.toString());
        System.out.println(b2.toString());
    }
    
}

interface BB{
    final int a = 1;
}

interface AA{
    void a();
}

class B extends A implements BB{
    int a = 2;
    public static void smile(){
        System.out.println("smileB");
    }

    public void test(){
        System.out.print("testB");
    }

    @Override
    public void a(){
        System.out.println(a);
    }
}


class A implements AA,Cloneable{
    int x;

    @Override
    public void a(){
        System.out.println("printA");
    }

    public static void smile(){
        System.out.println("smileA");
    }

    public void test(){
        System.out.print("testA");
    }

    public boolean equals(A a){
        return this.x == a.x;
    }

    @Override
    protected Object clone() 
        throws CloneNotSupportedException 
    { 
        return super.clone(); 
    } 
}
