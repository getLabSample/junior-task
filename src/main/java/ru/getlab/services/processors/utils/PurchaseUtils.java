package ru.getlab.services.processors.utils;

import ru.getlab.exceptions.NoSuchFruitException;
import ru.getlab.exceptions.PurchaseAmountFormatException;
import ru.getlab.model.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PurchaseUtils {
    // TODO оптимально ли я храню список фруктов? подумать еще...
    private static Map<String, BigDecimal> availableFruits;
    private static final List<Fruit> list = List.of(
            new Apple(),
            new Banana(),
            new Orange(),
            new Pear(),
            new Pineapple()
    );

    public PurchaseUtils() {
        this.availableFruits = list.stream()
                .collect(Collectors.toUnmodifiableMap(Fruit::getName, Fruit::getPrice));
    }


    public static void checkPurchase(String input) {
        String[] arr = input.split(" ");
        String fruit = arr[0];
        if (availableFruits == null) {
            availableFruits = list.stream()
                    .collect(Collectors.toUnmodifiableMap(Fruit::getName, Fruit::getPrice));
        }

        if (!availableFruits.containsKey(fruit)) {
            throw new NoSuchFruitException();
        }
        try {
            int amount = Integer.parseInt(arr[1]);
        } catch (NumberFormatException e) {
            throw new PurchaseAmountFormatException();
        }
    }

    public static BigDecimal getFruitPrice(String fruit) {
        return availableFruits.get(fruit);
    }
}
