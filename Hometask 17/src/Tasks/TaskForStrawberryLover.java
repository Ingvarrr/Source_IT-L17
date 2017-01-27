package Tasks;

import Structures.Child;
import Structures.IceCream;
import Structures.IceCreamStore;

/**
 * Created by vig on 1/23/17.
 */
public class TaskForStrawberryLover implements Runnable {
    private Child strawberryIceCreamLover = new Child("John", IceCream.STRAWBERRY);

    public Child getStrawberryIceCreamLover() {
        return strawberryIceCreamLover;
    }

    @Override
    public synchronized void run() {
            safeSleep(5300);
            if(IceCreamStore.iceCreamLand.containsStrawberryIceCream()){
                strawberryIceCreamLover.EatIceCream();
                IceCreamStore.iceCreamLand.removeStrawberryIceCream();
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
}
