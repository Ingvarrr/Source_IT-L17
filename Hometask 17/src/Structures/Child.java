package Structures;

/**
 * Created by vig on 1/22/17.
 */
public class Child {
    private String name;
    IceCream desiredIceCream;
    private boolean hasIceCream; //for future development
    public static volatile int overallIceCreamEatenCount = 0;
    private int iceCreamEaten = 0;

    public static int getIceCreamEatenCount() {
        return overallIceCreamEatenCount;
    }

    public int getIceCreamEaten() {
        return iceCreamEaten;
    }

    public void setHasIceCream(boolean hasIceCream) {
        this.hasIceCream = hasIceCream;
    }

    public Child(String name, IceCream desiredIceCream) {
        this.name = name;
        this.desiredIceCream = desiredIceCream;
        this.hasIceCream = false;
    }

    public void EatIceCream(){
        setHasIceCream(false);
        ++iceCreamEaten;
        ++overallIceCreamEatenCount;
    }

    @Override
    public String toString() {
        return name + " who loves " + desiredIceCream.toString().toLowerCase();
    }
}
