package ru.getlab.services.processors;

import ru.getlab.services.menu.MenuOption;

public class SearchPurchaseSingleCommandProcessor implements MenuSingleCommandProcessor {
    private final MenuOption processedCommandOption;

    public SearchPurchaseSingleCommandProcessor(MenuOption processedCommandOption) {
        this.processedCommandOption = processedCommandOption;
    }

    @Override
    public void processCommand() {
        // TODO write this feature in future...
        System.out.println("search purchase...write code here");
    }

    @Override
    public MenuOption getProcessedCommandOption() {
        return processedCommandOption;
    }
}
