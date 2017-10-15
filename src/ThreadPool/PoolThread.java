package ThreadPool;

import Exceptions.NullParameterException;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Jordan on 10/13/2017.
 */
public class PoolThread extends Thread {
    private BlockingQueue taskQueue;
    private boolean       isStopped = false;


    public PoolThread(BlockingQueue queue) throws NullParameterException {

        if (queue != null) {
            taskQueue = queue;
        }

        else throw new NullParameterException();
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
        this.interrupt(); //break pool thread out of dequeue() call.
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}
