import Exceptions.NullParameterException;
import Runnables.Prime;
import ThreadPool.ThreadPool;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Jordan on 10/15/2017.
 */
public class Application {

    public static void main(String[] args) {

        /**
         * Fixed-size thread-pool execution
         *
         * run tasks through fixed-size thread-pool
         */
        try {
            // create threadpool of size 5. Max tasks of 100
            ThreadPool threadPool = new ThreadPool(5, 100);

            // add 5 tasks to threadpool queue
            for (int i = 0; i < 5; i++) {
                int randomNumber = ThreadLocalRandom.current().nextInt(1, 100 + 1);
                Prime calculatePrimeTask = new Prime(randomNumber);
                threadPool.addTaskToQueue(calculatePrimeTask);
            }
            threadPool.start();
            // threadPool.stop();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NullParameterException e) {
            e.printStackTrace();
        }

    }
}
