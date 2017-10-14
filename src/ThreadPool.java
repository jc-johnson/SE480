

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Jordan on 10/13/2017.
 */
public class ThreadPool {

    private BlockingQueue taskQueue = null;
    private List<PoolThread> threads = new ArrayList<PoolThread>();
    // private List<Prime> threads = new ArrayList<Prime>();
    private boolean isStopped = false;
    private int maxNumberOfTasks;

    public ThreadPool(int numberOfThreads, int maxNumberOfTasks) throws InterruptedException {
        // initialize blocking queue
        taskQueue = new ArrayBlockingQueue(maxNumberOfTasks);

        this.maxNumberOfTasks = maxNumberOfTasks;

        // add tasks to queue
        initializeQueue(maxNumberOfTasks);

        // create new threads to execute tasks on queue
        for(int i=0; i<numberOfThreads; i++){
            threads.add(new PoolThread(taskQueue));
        }

        // run each thread
        for(PoolThread thread : threads){
            thread.run();
        }
    }

    public void initializeQueue(int numberOfTasks) {
        if (numberOfTasks < this.maxNumberOfTasks) {
            for (int i = 0; i < numberOfTasks; i++) {
                int randomNumber = ThreadLocalRandom.current().nextInt(1, 100 + 1);
                taskQueue.add(new Prime(randomNumber));
            }
        }


    }

    public synchronized void execute(Runnable task) throws Exception{
        if(this.isStopped) throw
                new IllegalStateException("ThreadPool is stopped");

        this.taskQueue.add(task);
    }

    public synchronized void stop(){
        this.isStopped = true;
        for(PoolThread thread : threads){
            thread.doStop();
        }
    }
}
