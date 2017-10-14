package misc.Tutorial;


/**
 * Created by Jordan on 10/13/2017.
 */
public class PoolThread implements Runnable {
    private BlockingQueue taskQueue = null;
    private boolean       isStopped = false;

    public PoolThread(BlockingQueue queue){
        taskQueue = queue;
    }

    @Override
    public void run(){
        while(!isStopped()){
            try{
                Runnable runnable = (Runnable) taskQueue.dequeue();
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
