package misc;

import java.util.Date;

/**
 * Created by Jordan on 10/6/2017.
 */
public class WorkerThread implements Runnable {

    private String command;

    public WorkerThread(String string){
        this.command = string;
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Time = "+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End. Time = "+new Date());
    }

    @Override
    public String toString(){
        return this.command;
    }

    public static void main(String[] args) {
        WorkerThread thread = new WorkerThread("Hi There");
        thread.run();
    }
}

