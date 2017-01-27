/**
 * Created by vig on 11/28/16.
 */
public class Thread1 implements Runnable {
    public static volatile int V = 0;

    private int startFrom;
    private int endWith;

    public void setStartFrom(int startFrom) {
        this.startFrom = startFrom;
    }

    public void setEndWith(int endWith) {
        this.endWith = endWith;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start " + V);
        for (int i = startFrom; i < endWith; i++) {
            System.out.println(Thread.currentThread().getName() + " i = " + i);
        }
        System.out.println(Thread.currentThread().getName() + " ended " + V++);
    }
}
