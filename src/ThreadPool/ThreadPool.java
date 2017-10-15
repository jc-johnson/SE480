package ThreadPool;

import Exceptions.NullParameterException;
import Runnables.Prime;

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
    private List<PoolThread> threads = new ArrayList<>();
    private boolean isStopped = false;
    private int maxNumberOfTasks;

    public ThreadPool(int numberOfThreads, int maxNumberOfTasks) throws InterruptedException, NullParameterException {
        // initialize blocking queue
        taskQueue = new ArrayBlockingQueue(maxNumberOfTasks);

        this.maxNumberOfTasks = maxNumberOfTasks;

        // add tasks to queue
        try {
            initializeQueue(maxNumberOfTasks);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // create new threads that execute tasks on queue when run
        for(int i=0; i<numberOfThreads; i++){
            threads.add(new PoolThread(taskQueue));
        }

        // run each thread
        for(PoolThread poolThread: threads){
            poolThread.run();
        }
    }

    // initialize queue with custom Runnables.Prime tasks
    public void initializeQueue(int numberOfTasks) throws Exception {
        if (numberOfTasks < this.maxNumberOfTasks) {
            for (int i = 0; i < numberOfTasks; i++) {
                int randomNumber = ThreadLocalRandom.current().nextInt(1, 100 + 1);
                // taskQueue.add(new Prime(randomNumber));
                execute(new Prime(randomNumber));
            }
        }


    }

    public synchronized void execute(Runnable task) throws Exception{
        if(this.isStopped) throw
                new IllegalStateException("ThreadPool.ThreadPool is stopped");

        this.taskQueue.add(task);
    }

    public synchronized void stop(){
        this.isStopped = true;
        for(PoolThread thread : threads){
            thread.doStop();
        }
    }

    public void addThread() throws NullParameterException {
        threads.add(new PoolThread(taskQueue));
    }

    public void removeThread() {

    }
}
