package misc.Tutorial;

/**
 * Created by Jordan on 10/9/2017.
 *
 *
 */
public class TwoSumsAlt {

    private int sum1 = 0;
    private int sum2 = 0;

    private Integer sum1Lock = new Integer(1);
    private Integer sum2Lock = new Integer(2);

    public void add(int val1, int val2){
        synchronized(this.sum1Lock){
            this.sum1 += val1;
        }
        synchronized(this.sum2Lock){
            this.sum2 += val2;
        }
    }

    //  Here is an example of a thread safe local primitive variable:
    public void someMethod(){

        long threadSafeInt = 0;

        threadSafeInt++;
    }
}
