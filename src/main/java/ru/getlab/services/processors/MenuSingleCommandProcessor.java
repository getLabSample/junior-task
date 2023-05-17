package ru.getlab.services.processors;

import ru.getlab.services.menu.MenuOption;

/**
 * Define common behaviour for all processors.
 */
public interface MenuSingleCommandProcessor {
    void processCommand();

    MenuOption getProcessedCommandOption();
}
