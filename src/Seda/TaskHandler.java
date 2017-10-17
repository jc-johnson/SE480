package Seda;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Jordan on 10/15/2017.
 */
public class TaskHandler {

    private int maxTasksToProcess;

    private int tasksToProcess;

    private BlockingQueue taskQueue;

    public TaskHandler(int maxTasksToProcess) {
        this.maxTasksToProcess = maxTasksToProcess;
    }

    public void enqueueToStage(SedaStage sedaStage) {

    }

    // add task to queue
    public void process(Runnable runnable) {
        taskQueue.add(runnable);
    }

    public int getTasksToProcess() {
        return tasksToProcess;
    }

    public void setTasksToProcess(int tasksToProcess) {
        if (tasksToProcess > 0) {
            int answer = this.tasksToProcess + tasksToProcess;

            if (answer > 0 && answer < maxTasksToProcess) {
                this.tasksToProcess = tasksToProcess;
            }
        }
    }

}
