package Controllers;

import Exceptions.NullParameterException;
import Seda.SedaStage;
import ThreadPool.ThreadPool;

/**
 * Created by Jordan on 10/15/2017.
 */
public class ThreadPoolController {

    private SedaStage sedaStage;

    public ThreadPoolController(SedaStage sedaStage) {
        this.sedaStage = sedaStage;
    }

    public void addThread(ThreadPool threadPool){
        try {
            threadPool.addThread();
        } catch (NullParameterException e) {
            e.printStackTrace();
        }
    }

    public void removeThread(ThreadPool threadPool){
        threadPool.removeThread();
    }
}
