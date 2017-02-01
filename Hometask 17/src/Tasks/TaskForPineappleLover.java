package Tasks;

import Structures.Child;
import Structures.IceCream;
import Structures.IceCreamStore;

/**
 * Created by vig on 1/26/17.
 */
public class TaskForPineappleLover implements Runnable {
    private Child pineappleIceCreamLover = new Child("Abe", IceCream.PINEAPPLE);

    public Child getPineappleIceCreamLover() {
        return pineappleIceCreamLover;
    }

    @Override
    public synchronized void run() {
        while (!TaskForStore.isFinished() || IceCreamStore.iceCreamLand.getIceCreamList().size() != 0) {
            safeSleep(5200);
            if (IceCreamStore.iceCreamLand.containsPineAppleIceCream()) {
                pineappleIceCreamLover.EatIceCream();
                IceCreamStore.iceCreamLand.removePineappleIceCream();
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
}
