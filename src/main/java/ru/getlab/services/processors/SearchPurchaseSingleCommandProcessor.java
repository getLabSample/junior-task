package ru.getlab.services.processors;

import ru.getlab.services.HistoryLoader;
import ru.getlab.services.IOServiceStreams;
import ru.getlab.services.menu.MenuOption;
import static ru.getlab.services.processors.utils.PurchaseUtils.*;

/**
 * Actions for search in purchase history.
 */
public class SearchPurchaseSingleCommandProcessor implements MenuSingleCommandProcessor {
    private final MenuOption processedCommandOption;
    private final IOServiceStreams ioService;
    private final HistoryLoader historyLoader;

    public SearchPurchaseSingleCommandProcessor(MenuOption processedCommandOption,
                                                IOServiceStreams ioService,
                                                HistoryLoader historyLoader) {
        this.processedCommandOption = processedCommandOption;
        this.ioService = ioService;
        this.historyLoader =  historyLoader;
    }

    @Override
    public void processCommand() {
        String userInput =
                ioService.readStringWithPrompt("Input search criteria:");
        ioService.outputString(searchPurchase(userInput, historyLoader.readFromInputStream()));
    }

    @Override
    public MenuOption getProcessedCommandOption() {
        return processedCommandOption;
    }
}
