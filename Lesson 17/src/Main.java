import java.util.Random;

/**
 * Created by vig on 11/28/16.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        Storage storage = new Storage();
        for(int i=0; i< 10; i ++) {

            Task task = new Task(
                    r.nextInt(500),
                    r.nextInt(500),
                    storage
            );
            new Thread(task).start();
        }
        System.out.println("MAin Ended ");

        /*Random r = new Random();
        Storage storage = new Storage();
        for (int i = 0; i < 10; i++) {
            //Thread1 thread1 = new Thread1();
            Task task = new Task(){
                r.nextInt(500);

            }
            int start = r.nextInt(50) + 1;
            thread1.setStartFrom(start);
            thread1.setEndWith(start + r.nextInt(50));
            Thread t = new Thread(thread1);
            t.setName("My Thread " + i);
            t.start();

        }*/


        // !!!!!!!!!!!!!!!!! thread1.run();
        /*Thread t = new Thread(thread1);
        System.out.println("State =- " + t.getState());
        t.setName("My Thread");
        t.start();
        System.out.println("State =- " + t.getState());
        System.out.println("Main " +
                Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("State =- " + t.getState());*/
    }
}
