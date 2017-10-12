package misc;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jordan on 10/6/2017.
 */
public class ScheduledThreadPool {

    private int threadPoolSize;
    private ScheduledExecutorService scheduledThreadPool;

    public ScheduledThreadPool(int threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
        this.scheduledThreadPool = Executors.newScheduledThreadPool(this.threadPoolSize);
    }

    public void run() throws InterruptedException {
        //schedule to run after sometime
        System.out.println("Current Time = "+ new Date());
        for(int i=0; i<3; i++){
            Thread.sleep(1000);
            WorkerThread worker = new WorkerThread("do heavy processing");
            scheduledThreadPool.schedule(worker, 10, TimeUnit.SECONDS);
        }

        //add some delay to let some threads spawn by scheduler
        Thread.sleep(30000);

        scheduledThreadPool.shutdown();
        while(!scheduledThreadPool.isTerminated()){
            //wait for all tasks to finish
        }
        System.out.println("Finished all threads");
    }


    public static void main(String[] args) throws InterruptedException {
        ScheduledThreadPool scheduledThreadPool = new ScheduledThreadPool(5);
        scheduledThreadPool.run();
    }
}
