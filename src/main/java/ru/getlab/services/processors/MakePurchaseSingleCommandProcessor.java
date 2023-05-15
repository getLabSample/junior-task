package ru.getlab.services.processors;

import ru.getlab.services.menu.MenuOption;

public class MakePurchaseSingleCommandProcessor implements MenuSingleCommandProcessor {
    private final MenuOption processedCommandOption;

    public MakePurchaseSingleCommandProcessor(MenuOption processedCommandOption) {
        this.processedCommandOption = processedCommandOption;
    }

    @Override
    public void processCommand() {
        System.out.println("making purchase...");
    }

    @Override
    public MenuOption getProcessedCommandOption() {
        return processedCommandOption;
    }
}
