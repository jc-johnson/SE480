import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jordan on 10/4/2017.
 */
public class PrimeTest {
    @Test
    public void isPrime() throws Exception {

        // bad input
        assertEquals(false, Prime.isPrime(0));
        assertEquals(false, Prime.isPrime(-1));

        assertEquals(false, Prime.isPrime(4));
        assertEquals(false, Prime.isPrime(10));
        assertEquals(false, Prime.isPrime(30));
        assertEquals(false, Prime.isPrime(130));

        assertEquals(true, Prime.isPrime(3));
        assertEquals(true, Prime.isPrime(149));
        assertEquals(true, Prime.isPrime(2));
        assertEquals(true, Prime.isPrime(829));
        assertEquals(true, Prime.isPrime(997));
        assertEquals(true, Prime.isPrime(211));

    }

}