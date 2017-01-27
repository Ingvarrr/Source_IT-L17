package Structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vig on 1/22/17.
 */
public class IceCreamStore {
    public static IceCreamStore iceCreamLand = new IceCreamStore();
    private List<IceCream> iceCreamList = Collections.synchronizedList(new ArrayList<IceCream>());

    public List<IceCream> getIceCreamList() {
        return iceCreamList;
    }

    public void produceIceCream(){
            iceCreamList.add(IceCream.randomIceCream());
    }
    public void removeStrawberryIceCream(){
        iceCreamList.remove(IceCream.STRAWBERRY);
    }
    public void removePineappleIceCream(){
        iceCreamList.remove(IceCream.PINEAPPLE);
    }
    public void removeVanillaIceCream(){
        iceCreamList.remove(IceCream.VANILLA);
    }
    public boolean containsStrawberryIceCream(){
        return iceCreamList.contains(IceCream.STRAWBERRY);
    }
    public boolean containsPineAppleIceCream(){
        return iceCreamList.contains(IceCream.PINEAPPLE);
    }
    public boolean containsVanillaIceCream(){
        return iceCreamList.contains(IceCream.VANILLA);
    }
}
