package ru.getlab.services.processors.utils;

import ru.getlab.exceptions.NoSuchFruitException;
import ru.getlab.exceptions.PurchaseAmountFormatException;
import ru.getlab.model.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Some helper actions for make purchase.
 */
public class PurchaseUtils {
    private PurchaseUtils() {}

    private static final List<Fruit> list = List.of(
            new Apple(),
            new Banana(),
            new Orange(),
            new Pear(),
            new Pineapple()
    );
    private static Map<String, BigDecimal> availableFruits = list.stream()
            .collect(Collectors.toUnmodifiableMap(Fruit::getName, Fruit::getPrice));

    public static void checkPurchase(String input) {
        String[] arr = input.split(" ");
        String fruit = arr[0];

        if (!availableFruits.containsKey(fruit)) {
            throw new NoSuchFruitException();
        }
        try {
            Integer.parseInt(arr[1]);
        } catch (NumberFormatException e) {
            throw new PurchaseAmountFormatException();
        }
    }

    public static BigDecimal getFruitPrice(String fruit) {
        return availableFruits.get(fruit);
    }

    public static String searchPurchase(String userPattern, String text) {
        Pattern pattern =  Pattern.compile(userPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher =  pattern.matcher(text);
        StringBuilder sb =  new StringBuilder();
        sb.append("************ Search Result ***********\n");
        while (matcher.find()){
            sb.append(text.substring(matcher.start(), matcher.end()));
            sb.append("\n");
        }
        return sb.toString();
    }
}
