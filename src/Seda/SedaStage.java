package Seda;

import Controllers.BatchingController;
import Controllers.ThreadPoolController;
import Exceptions.NullParameterException;
import ThreadPool.ThreadPool;
import com.sun.javafx.tk.Toolkit;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Jordan on 10/14/2017.
 */
public class SedaStage {

    ThreadPool threadPool;
    BatchingController batchingController;
    ThreadPoolController threadPoolController;
    TaskHandler taskHandler;
    BlockingQueue blockingQueue;

    public SedaStage() throws InterruptedException, NullParameterException {
    }

    public void enqueueTaskToStage(Runnable runnable) {
        try {
            this.threadPool.execute(runnable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
