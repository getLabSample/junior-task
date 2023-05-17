package ru.getlab.services.processors;

import ru.getlab.services.HistoryWriter;
import ru.getlab.services.menu.MenuOption;

import java.math.BigDecimal;

import static ru.getlab.services.processors.utils.PurchaseUtils.*;

public class MakePurchaseSingleCommandProcessor implements MenuSingleCommandProcessor {
    private final MenuOption processedCommandOption;
    private final HistoryWriter historyWriter;
    private final InputService inputService;

    public MakePurchaseSingleCommandProcessor(MenuOption processedCommandOption,
                                              HistoryWriter historyWriter,
                                              InputService inputService) {
        this.processedCommandOption = processedCommandOption;
        this.historyWriter = historyWriter;
        this.inputService = inputService;
    }

    @Override
    public void processCommand() {
        String userInput =
                inputService.readStringWithPrompt("Choose fruit and amount (for example, apple 4)");
        checkPurchase(userInput);
        historyWriter.writePurchaseToFile(calculateTotalPrice(userInput));
    }

    @Override
    public MenuOption getProcessedCommandOption() {
        return processedCommandOption;
    }

    private String calculateTotalPrice(String userInput) {
        String[] arrInput = userInput.split(" ");
        BigDecimal fruitPrice = getFruitPrice(arrInput[0]);
        int amount = Integer.parseInt(arrInput[1]);
        BigDecimal totalPrice = fruitPrice.multiply(BigDecimal.valueOf(amount));
        return arrInput[0] + " " + totalPrice;
    }
}
