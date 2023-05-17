package ru.getlab;

import ru.getlab.services.*;
import ru.getlab.services.menu.MenuOption;
import ru.getlab.services.menu.MenuOptionsRegistry;
import ru.getlab.services.processors.*;

import java.util.List;

/**
 * This is start point of application. Here we initialize everything and run application runner.
 */
public class Main {
    public static void main(String[] args) {
        var applicationStopService = new ApplicationStopService();
        var ioService = new IOServiceStreams(System.out, System.in);

        var historyLoader = new HistoryLoader();
        var historyWriter = new HistoryWriter();

        var makePurchaseMenuOption = new MenuOption(1, "Make purchase");
        var showPurchaseHistoryMenuOption = new MenuOption(2, "Show purchase history");
        var searchPurchaseMenuOption = new MenuOption(3, "Search purchase");
        var stopApplicationMenuOption = new MenuOption(4, "Exit");
        var menuOptions = List.of(makePurchaseMenuOption, showPurchaseHistoryMenuOption,
                searchPurchaseMenuOption, stopApplicationMenuOption);
        var menuOptionRegistry = new MenuOptionsRegistry(menuOptions);


        List<MenuSingleCommandProcessor> processors = List.of(
                new MakePurchaseSingleCommandProcessor(makePurchaseMenuOption,
                        historyWriter, ioService),
                new ShowPurchaseHistorySingleCommandProcessor(showPurchaseHistoryMenuOption,
                        historyLoader, ioService),
                new SearchPurchaseSingleCommandProcessor(searchPurchaseMenuOption,
                        ioService, historyLoader),
                new StopApplicationSingleCommandProcessor(applicationStopService,
                        stopApplicationMenuOption)
        );

        MenuCommandProcessor menuCommandProcessor = new MenuCommandProcessor(processors);

        new ApplicationRunner(ioService, applicationStopService, menuOptionRegistry, menuCommandProcessor)
                .run();
    }
}
