package Tasks;

import Structures.IceCreamStore;

/**
 * Created by vig on 1/23/17.
 */
public class TaskForStore implements Runnable {

    private volatile int iceCreamLimit;
    private IceCreamStore store;
    private static boolean isFinished = false;

    public static void setIsFinished(boolean isFinished) {
        TaskForStore.isFinished = isFinished;
    }

    public static boolean isFinished() {
        return isFinished;
    }

    public int getIceCreamLimit() {
        return iceCreamLimit;
    }

    public TaskForStore(int iceCreamLimit, IceCreamStore store) {
        this.iceCreamLimit = iceCreamLimit;
        this.store = store;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < iceCreamLimit; i++) {
            safeSleep(5000);
            store.produceIceCream();
        }
        TaskForStore.setIsFinished(true);
    }

    private void safeSleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() +
                    e.getMessage());
            e.printStackTrace();
        }
    }
}
