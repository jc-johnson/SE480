import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Jordan on 10/5/2017.
 */
public class FixedSizeScheduler implements Executor {

    private int numberOfThreads;

    public FixedSizeScheduler(int numberOfThreads){
        this.numberOfThreads = numberOfThreads;
    }

    public int getNumberOfThreads() {
        return numberOfThreads;
    }

    public void setNumberOfThreads(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    // this should return something
    private void grabTaskFromQueue() {

    }

    @Override
    public void execute(Runnable command) {
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        // for x numberOfThreads
            // create a thread
            // grab a task from queue
            // run task
            // if any more tasks on queue
                // run it

    }

    public static void main(String[] args) {
    }
}
