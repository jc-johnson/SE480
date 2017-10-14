package misc.Tutorial;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jordan on 10/13/2017.
 */
public class ThreadPool {

    private BlockingQueue taskQueue = null;
    private List<PoolThread> threads = new ArrayList<PoolThread>();
    private boolean isStopped = false;

    public ThreadPool(int numberOfThreads, int maxNumberOfTasks){
        // initialize blocking queue
        taskQueue = new BlockingQueue(maxNumberOfTasks);

        // add each task to queue
        for(int i=0; i<numberOfThreads; i++){
            threads.add(new PoolThread(taskQueue));
        }

        // run each thread
        for(PoolThread thread : threads){
            thread.run();
        }
    }

    public synchronized void  execute(Runnable task) throws Exception{
        if(this.isStopped) throw
                new IllegalStateException("ThreadPool is stopped");

        this.taskQueue.enqueue(task);
    }

    public synchronized void stop(){
        this.isStopped = true;
        for(PoolThread thread : threads){
            thread.doStop();
        }
    }
}
