import java.util.Scanner;
import java.util.ArrayList;

class PrimeNumber {
    private ArrayList<Integer> numbers;
    private int maxPrime;

    public PrimeNumber() {
        this.numbers = new ArrayList<>();
        this.maxPrime = -1;
    }

    public void addNumber(int number) {
        if (number == 0) {
            return;
        }
        numbers.add(number);
    }

    public int findMaxPrime() {
        for (int number : numbers) {
            if (isPrime(number) && number > maxPrime) {
                maxPrime = number;
            }
        }
        return maxPrime;
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class PrimeNumberTest {
    public static void main(String[] args) {
        PrimeNumber primeNumber = new PrimeNumber();
        Scanner input = new Scanner(System.in);
        int number;
        do{
            number = input.nextInt();
            primeNumber.addNumber(number);
            
        } while(number != 0);

        int maxPrime = primeNumber.findMaxPrime();
        System.out.println(maxPrime);
    }
}
