package ru.getlab.services.processors;

import ru.getlab.services.ApplicationStopService;
import ru.getlab.services.menu.MenuOption;

/**
 * Actions for stop application.
 */
public class StopApplicationSingleCommandProcessor implements MenuSingleCommandProcessor {
    private final MenuOption processedCommandOption;
    private final ApplicationStopService applicationStopService;

    public StopApplicationSingleCommandProcessor(ApplicationStopService applicationStopService,
                                                 MenuOption processedCommandOption) {
        this.processedCommandOption = processedCommandOption;
        this.applicationStopService = applicationStopService;
    }

    @Override
    public void processCommand() {
        applicationStopService.stopApplication();
    }

    @Override
    public MenuOption getProcessedCommandOption() {
        return processedCommandOption;
    }
}
