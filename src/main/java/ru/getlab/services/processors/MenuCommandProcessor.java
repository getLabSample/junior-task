package ru.getlab.services.processors;

import ru.getlab.exceptions.MenuCommandProcessorNotFound;
import ru.getlab.services.menu.MenuOption;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MenuCommandProcessor {
    private final Map<MenuOption, MenuSingleCommandProcessor> processors;

    public MenuCommandProcessor(List<MenuSingleCommandProcessor> processors) {
        this.processors = processors.stream()
                .collect(
                        Collectors.toMap(MenuSingleCommandProcessor::getProcessedCommandOption, Function.identity())
                );
    }

    public void processMenuCommand(MenuOption selectedMenuOption) {
        var commandProcessor = processors.get(selectedMenuOption);
        if (commandProcessor == null) {
            throw new MenuCommandProcessorNotFound("Menu command processor for given option does not registered");
        }
        commandProcessor.processCommand();
    }
}
