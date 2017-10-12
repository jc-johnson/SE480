package misc.Tutorial;

/**
 * Created by Jordan on 10/11/2017.
 */
public class MonitorObject {

    public class MyWaitNotify {

        MonitorObject myMonitorObject = new MonitorObject();

        public void doWait() {
            synchronized (myMonitorObject) {
                try {
                    myMonitorObject.wait();
                } catch (InterruptedException e) {}
            }
        }

        public void doNotify() {
            synchronized (myMonitorObject) {
                myMonitorObject.notify();
            }
        }
    }
}
