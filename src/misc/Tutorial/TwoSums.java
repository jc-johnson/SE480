package misc.Tutorial;

/**
 * Created by Jordan on 10/9/2017.
 */
public class TwoSums {

    private int sum1 = 0;
    private int sum2 = 0;

    public void add(int val1, int val2){
        synchronized(this){
            this.sum1 += val1;
            this.sum2 += val2;
        }
    }
}
