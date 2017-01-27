package Structures;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by vig on 1/22/17.
 */
public enum IceCream {
    STRAWBERRY("Strawberry","Red","Sweet"),
    PINEAPPLE("Pineapple","Yellow","Citrus"),
    VANILLA("Vanilla","White","Vanilla");


    private String taste;
    private String color;
    private String smell;

    public String getTaste() {
        return taste;
    }

    public String getColor() {
        return color;
    }

    public String getSmell() {
        return smell;
    }

    IceCream(String x, String y,String z) {
        this.taste = x;
        this.color = y;
        this.smell = z;
    }
    private static final List<IceCream> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static IceCream randomIceCream()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
