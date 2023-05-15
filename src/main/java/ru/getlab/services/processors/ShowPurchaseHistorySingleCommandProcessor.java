package ru.getlab.services.processors;

import ru.getlab.services.menu.MenuOption;

public class ShowPurchaseHistorySingleCommandProcessor implements MenuSingleCommandProcessor {
    private final MenuOption processedCommandOption;

    public ShowPurchaseHistorySingleCommandProcessor(MenuOption processedCommandOption) {
        this.processedCommandOption = processedCommandOption;
    }

    @Override
    public void processCommand() {
        System.out.println("show purchase history...");
    }

    @Override
    public MenuOption getProcessedCommandOption() {
        return processedCommandOption;
    }
}
