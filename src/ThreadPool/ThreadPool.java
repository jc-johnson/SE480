package ThreadPool;

import Exceptions.NullParameterException;
import Runnables.Prime;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
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

        // create new threads that execute tasks on queue when run
        for(int i=0; i<numberOfThreads; i++){
            threads.add(new PoolThread(taskQueue));
        }

    }

    /*
    // initialize queue with custom tasks
    public void initializeQueue(int numberOfTasks) throws Exception {
        if (numberOfTasks < this.maxNumberOfTasks) {
            for (int i = 0; i < numberOfTasks; i++) {
                int randomNumber = ThreadLocalRandom.current().nextInt(1, 100 + 1);
                taskQueue.add(new Prime(randomNumber));
            }
        }
    }
    */

    public void addTaskToQueue(Runnable task) {
        if(this.isStopped) throw
                new IllegalStateException("ThreadPool.ThreadPool is stopped");
        taskQueue.add(task);
    }

    public void addTaskToQueue(Callable task) {
        if(this.isStopped) throw
                new IllegalStateException("ThreadPool.ThreadPool is stopped");
        taskQueue.add(task);
    }


    // add task to queue
    public synchronized void execute(Runnable task) throws Exception{
        if(this.isStopped) throw
                new IllegalStateException("ThreadPool.ThreadPool is stopped");

        this.taskQueue.add(task);
    }

    public synchronized void start(){
        this.isStopped = true;
        for(PoolThread poolThread: threads){
            poolThread.run();
        }
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
        threads.get(0).interrupt();
        threads.remove(0);
    }
}
