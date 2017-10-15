package Runnables;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jordan on 10/4/2017.
 */
public class Prime implements Runnable{

    private List<Integer> primes = new ArrayList<>();   // list to hold previous primes
    private int n;

    public Prime(int n){
        this.n = n;
    }

    //checks whether an int is prime or not.
    public boolean isPrime(int n) {

        if (n < 2) return false;

        // check beginning edge cases
        if (n % 2 == 0) return n == 2;
        if (n % 3 == 0) return n == 3;

        //check if n is a multiple of 2
        // if (n%2==0) return false;

        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public int nthPrime(int n) throws InterruptedException {

        if (n < 1) return 0;

        int i, count;
        for(i = 2, count = 0; count < n; ++i) {
            if (isPrime(i)) {
                ++count;
                primes.add(i);
            }
        }

        printPrimes();

        // The candidate has been incremented once after the count reached n
        System.out.println(String.format("Nth prime number: %d", i-1));
        return i-1;
    }

    public void printPrimes() throws InterruptedException {
        for (Integer integer : primes) {
            System.out.println(integer);
            Thread.sleep(10);
        }
    }

    @Override
    public void run() {
        try {
            nthPrime(this.n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Prime thread = new Prime(7);
        thread.run();
    }


}
