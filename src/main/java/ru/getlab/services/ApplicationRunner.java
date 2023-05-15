package ru.getlab.services;

import ru.getlab.exceptions.MenuItemIndexOutOfBoundsException;
import ru.getlab.services.menu.MenuOption;
import ru.getlab.services.menu.MenuOptionsRegistry;
import ru.getlab.services.processors.MenuCommandProcessor;

import java.util.Comparator;

public class ApplicationRunner {

    private final IOService ioService;
    private final ApplicationStopService applicationStopService;
    private final MenuOptionsRegistry menuOptionRegistry;
    private final MenuCommandProcessor commandsProcessor;

    public ApplicationRunner(IOService ioService,
                             ApplicationStopService applicationStopService,
                             MenuOptionsRegistry menuOptionsRegistry,
                             MenuCommandProcessor commandsProcessor) {
        this.ioService = ioService;
        this.applicationStopService = applicationStopService;
        this.menuOptionRegistry = menuOptionsRegistry;
        this.commandsProcessor = commandsProcessor;
    }

    public void run() {
        while (applicationStopService.isApplicationRunning()) {
            outputMenu();
            try {
                int selectedMenuItem = readSelectedOptionNumber();
                processMenuCommand(selectedMenuItem);

            } catch (NumberFormatException e) {
                ioService.outputString("Input number error. You should input only single digit");
            } catch (MenuItemIndexOutOfBoundsException e) {
                ioService.outputString("Invalid option number. No such menu item. Pay attention");
            }
        }
    }

    private void outputMenu() {
        ioService.outputString("============================================");
        ioService.outputString("choose option");
        menuOptionRegistry.getAvailableMenuOptions().stream()
                .sorted(Comparator.comparingInt(MenuOption::getId))
                .map(m -> m.getId() + ". " + m.getDescription())
                .forEach(ioService::outputString);
    }

    private void processMenuCommand(int selectedMenuItemId) {
        var selectedMenuOption =
                menuOptionRegistry.getMenuOptionById(selectedMenuItemId)
                        .orElseThrow(
                                () -> new MenuItemIndexOutOfBoundsException("Given menu item index is out of range")
                        );
        commandsProcessor.processMenuCommand(selectedMenuOption);
    }

    private int readSelectedOptionNumber() {
        return ioService.readInt();
    }
}
