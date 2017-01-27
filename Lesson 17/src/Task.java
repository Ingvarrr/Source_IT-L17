/**
 * Created by vig on 11/28/16.
 */
public class Task implements Runnable {

    private int a;
    private int b;
    private Storage storage;

    public Task(int a, int b, Storage storage) {
        this.a = a;
        this.b = b;
        this.storage = storage;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            storage.store(
                    Thread.currentThread().getName(),
                    a + b / 2);
        }
    }
}

// Установка флага Interrupt и убивание потока при условии

/*public class Task implements Runnable {

    Thread targetToDestroy = null;

    public Task(Thread targetToDestroy) {
        this.targetToDestroy = targetToDestroy;
    }

    @Override
    public void run() {
        for(int i = 0;i < 1000 ; i++) {
            safeSleep(1000);
            if(i == 2 && targetToDestroy != null) {
                System.out.println(Thread.currentThread().getName()
                + " interrupting " + targetToDestroy.getName());
                targetToDestroy.interrupt();
            }
            if(Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted "
                        + Thread.currentThread().getName());
                break;
            }
        }
    }
    private void safeSleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() +
            e.getMessage());
            e.printStackTrace();
        }
        for(int i = 0; i<Integer.MAX_VALUE; i++);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Task(null));
        new Thread(new Task(t1)).start();
        t1.start();
    }
}*/

//Установка своего флага и создание своего объекта(псевдопотока), который знает как себя прервать

/*public class Task implements Runnable {

    Task targetToDestroy = null;
    volatile boolean flag = false;

    public Task(Task targetToDestroy) {
        this.targetToDestroy = targetToDestroy;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            safeSleep(1000);
            if (i == 2 && targetToDestroy != null) {
                System.out.println(this
                        + " interrupting " + targetToDestroy);
                targetToDestroy.flag = true;
            }
            if (this.flag) {
                System.out.println("Interrupted "
                        + Thread.currentThread().getName());
                break;
            }
        }
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

    public static void main(String[] args) {
        Task t1 = new Task(null);
        new Thread(new Task(t1)).start();
        new Thread(t1).start();
    }
}*/

//alt+F7 - выделение и быстрый поиск