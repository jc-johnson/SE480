package Controllers;

import Exceptions.NullParameterException;
import Seda.SedaStage;
import ThreadPool.ThreadPool;

/**
 * Created by Jordan on 10/15/2017.
 */
public class ThreadPoolController {

    public void addThread(ThreadPool threadPool){

        if (threadPool != null) {
            try {
                threadPool.addThread();
            } catch (NullParameterException e) {
                e.printStackTrace();
            }
        }

    }

    public void removeThread(ThreadPool threadPool){

        if (threadPool != null) {
            threadPool.removeThread();
        }

    }
}
