package ru.getlab.services.processors;

import ru.getlab.services.HistoryLoader;
import ru.getlab.services.menu.MenuOption;

public class ShowPurchaseHistorySingleCommandProcessor implements MenuSingleCommandProcessor {
    private final MenuOption processedCommandOption;
    private final HistoryLoader historyLoader;
    private final OutputService outputService;

    public ShowPurchaseHistorySingleCommandProcessor(MenuOption processedCommandOption,
                                                     HistoryLoader historyLoader,
                                                     OutputService outputService) {
        this.processedCommandOption = processedCommandOption;
        this.historyLoader = historyLoader;
        this.outputService = outputService;
    }

    @Override
    public void processCommand() {
        outputService.outputString(historyLoader.readFromInputStream());
    }

    @Override
    public MenuOption getProcessedCommandOption() {
        return processedCommandOption;
    }
}
