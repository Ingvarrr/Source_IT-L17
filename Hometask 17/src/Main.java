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

        //создание потоков для производства и покупки мороженного
        Thread produce = new Thread(iceCreamProduce);
        produce.setName("IceCreamProduce");
        Thread getPineappleIceCream = new Thread(pineappleLover);
        getPineappleIceCream.setName("BuyingPineappleIceCream");
        Thread getStrawberryIceCream = new Thread(strawberryLover);
        getStrawberryIceCream.setName("BuyingStrawberryIceCream");
        Thread getVanillaIceCream = new Thread(vanillaLover);
        getVanillaIceCream.setName("BuyingVanillaIceCream");

        produce.start();
        getPineappleIceCream.start();
        getStrawberryIceCream.start();
        getVanillaIceCream.start();

        //создание и запуск потока для вывода результата
        TaskForResults results = new TaskForResults(){
            @Override
            public void run() {
                try{
                    produce.join();
                    getPineappleIceCream.join();
                    getStrawberryIceCream.join();
                    getVanillaIceCream.join();
                }catch (InterruptedException e){}
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
        };
        Thread showResults = new Thread(results);
        showResults.setName("Results");
        showResults.start();

        //старая версия в 1 поток
        /*while(produce.isAlive() || IceCreamStore.iceCreamLand.getIceCreamList().size() !=0) {
            getPineappleIceCream.run();
            getStrawberryIceCream.run();
            getVanillaIceCream.run();
        }*/

    }

    private static class TaskForResults implements Runnable {
        @Override
        public void run() {

        }
    }
}
