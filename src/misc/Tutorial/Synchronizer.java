package misc.Tutorial;

import java.util.concurrent.locks.Lock;

/**
 * Created by Jordan on 10/11/2017.
 */
public class Synchronizer {

    Lock lock;

    public void doSynchronized() throws InterruptedException{
        this.lock.lock();
        //critical section, do a lot of work which takes a long time
        this.lock.unlock();
    }
}
