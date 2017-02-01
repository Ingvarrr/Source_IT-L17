package Tasks;

import Structures.Child;
import Structures.IceCream;
import Structures.IceCreamStore;

/**
 * Created by vig on 1/26/17.
 */
public class TaskForVanillaLover implements Runnable {
    private Child vanillaIceCreamLover = new Child("Lily", IceCream.VANILLA);

    public Child getVanillaIceCreamLover() {
        return vanillaIceCreamLover;
    }

    @Override
    public synchronized void run() {
        while (!TaskForStore.isFinished() || IceCreamStore.iceCreamLand.getIceCreamList().size() != 0) {
            safeSleep(5400);
            if (IceCreamStore.iceCreamLand.containsVanillaIceCream()) {
                vanillaIceCreamLover.EatIceCream();
                IceCreamStore.iceCreamLand.removeVanillaIceCream();
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
