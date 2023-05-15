package ru.getlab;

import ru.getlab.services.ApplicationRunner;
import ru.getlab.services.ApplicationStopService;
import ru.getlab.services.IOServiceStreams;
import ru.getlab.services.menu.MenuOption;
import ru.getlab.services.menu.MenuOptionsRegistry;
import ru.getlab.services.processors.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var applicationStopService =  new ApplicationStopService();
        var ioService =  new IOServiceStreams(System.out, System.in);

        var makePurchaseMenuOption = new MenuOption(1, "Make purchase");
        var showPurchaseHistoryMenuOption = new MenuOption(2, "Show purchase history");
        var searchPurchaseMenuOption = new MenuOption(3, "Search purchase");
        var stopApplicationMenuOption = new MenuOption(4, "Exit");
        var menuOptions = List.of(makePurchaseMenuOption, showPurchaseHistoryMenuOption,
                searchPurchaseMenuOption, stopApplicationMenuOption);
        var menuOptionRegistry =  new MenuOptionsRegistry(menuOptions);


        List<MenuSingleCommandProcessor> processors = List.of(
                new MakePurchaseSingleCommandProcessor(makePurchaseMenuOption),
                new ShowPurchaseHistorySingleCommandProcessor(showPurchaseHistoryMenuOption),
                new SearchPurchaseSingleCommandProcessor(searchPurchaseMenuOption),
                new StopApplicationSingleCommandProcessor(applicationStopService, stopApplicationMenuOption)
        );

        MenuCommandProcessor menuCommandProcessor =  new MenuCommandProcessor(processors);

        new ApplicationRunner(ioService, applicationStopService, menuOptionRegistry, menuCommandProcessor)
                .run();
    }
}
