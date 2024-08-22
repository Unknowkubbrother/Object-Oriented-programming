import java.util.Scanner;

class RoachPopulation{
    private int numRoach;

    public RoachPopulation(){
        this.numRoach = 0;
    }

    public RoachPopulation(int numRoach){
        this.numRoach = numRoach;
    }

    public void waitRoach() {
        this.numRoach = this.numRoach*2;
    }

    public void spayRoach(){
        this.numRoach = this.numRoach - ((int)(this.numRoach * 0.1));
    }

    public int getRoach(){
        return this.numRoach;
    }
}


public class RoachPopulationTest {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numRoach = input.nextInt();
        int round = input.nextInt();
        RoachPopulation r1 = new RoachPopulation(numRoach);

        for(int i=0;i<round;i++){
            r1.waitRoach();
            r1.spayRoach();
        }

        System.out.println(r1.getRoach());

    }
    
}