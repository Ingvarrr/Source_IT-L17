import Structures.Child;
import Structures.IceCreamStore;
import Tasks.TaskForPineappleLover;
import Tasks.TaskForStore;
import Tasks.TaskForStrawberryLover;
import Tasks.TaskForVanillaLover;


/**
 * Created by vig on 1/22/17.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaskForStore iceCreamProduce = new TaskForStore(50,IceCreamStore.iceCreamLand);
        TaskForPineappleLover pineappleLover = new TaskForPineappleLover();
        TaskForStrawberryLover strawberryLover = new TaskForStrawberryLover();
        TaskForVanillaLover vanillaLover = new TaskForVanillaLover();

        Thread produce = new Thread(iceCreamProduce);
        Thread getPineappleIceCream = new Thread(pineappleLover);
        Thread getStrawberryIceCream = new Thread(strawberryLover);
        Thread getVanillaIceCream = new Thread(vanillaLover);

        produce.start();
        while(produce.isAlive() || IceCreamStore.iceCreamLand.getIceCreamList().size() !=0) {
            getPineappleIceCream.run();
            getStrawberryIceCream.run();
            getVanillaIceCream.run();
        }
        if (!produce.isAlive() && !getPineappleIceCream.isAlive() && !getStrawberryIceCream.isAlive() &&
                 !getVanillaIceCream.isAlive()) {
            System.out.println("Amount of produced ice-cream: " + iceCreamProduce.getIceCreamLimit() + "\n" +
                    "Amount of ice-cream eaten by kids: " + Child.overallIceCreamEatenCount + "\n" +
                    "First kid: " + pineappleLover.getPineappleIceCreamLover().toString() +
                    " has eaten " + pineappleLover.getPineappleIceCreamLover().getIceCreamEaten() + " ice-creams" + "\n" +
                    "Second kid: " + strawberryLover.getStrawberryIceCreamLover().toString() +
                    " has eaten " + strawberryLover.getStrawberryIceCreamLover().getIceCreamEaten() + " ice-creams" + "\n" +
                    "Third kid: " + vanillaLover.getVanillaIceCreamLover().toString() +
                    " has eaten " + vanillaLover.getVanillaIceCreamLover().getIceCreamEaten() + " ice-creams"
            );
        }
    }
}
