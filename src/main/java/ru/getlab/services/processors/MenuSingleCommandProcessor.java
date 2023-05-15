package ru.getlab.services.processors;

import ru.getlab.services.menu.MenuOption;

public interface MenuSingleCommandProcessor {
    void processCommand();

    MenuOption getProcessedCommandOption();
}
