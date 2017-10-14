import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Jordan on 10/13/2017.
 */
public class PoolThread implements Runnable {
    private BlockingQueue taskQueue = new ArrayBlockingQueue(5);
    private boolean       isStopped = false;

    public PoolThread(BlockingQueue queue){
        taskQueue = queue;
    }


    // runs whatever task is on the queue
    @Override
    public void run(){
        while(!isStopped()){
            try{
                Runnable runnable = (Runnable) taskQueue.remove();
                runnable.run();
            } catch(Exception e){
                //log or otherwise report exception,
                //but keep pool thread alive.
            }
        }
    }

    public synchronized void doStop(){
        isStopped = true;
        // this.interrupt(); //break pool thread out of dequeue() call.
        this.doStop();
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}
