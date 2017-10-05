/**
 * Created by Jordan on 10/4/2017.
 */
public class Prime {


    //checks whether an int is prime or not.
    public static boolean isPrime(int n) {

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

    public static int nthPrime(int n) {
        int candidate, count;
        for(candidate = 2, count = 0; count < n; ++candidate) {
            if (isPrime(candidate)) {
                ++count;
            }
        }
        // The candidate has been incremented once after the count reached n
        return candidate-1;
    }

}
