package ru.getlab.services.menu;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Some helper actions with menu options.
 */
public class MenuOptionsRegistry {
    private final Map<Integer, MenuOption> options;

    public MenuOptionsRegistry(List<MenuOption> options) {
        this.options = options.stream()
                .collect(Collectors.toUnmodifiableMap(MenuOption::getId, Function.identity()));
    }

    public List<MenuOption> getAvailableMenuOptions() {
        return options.values().stream().toList();
    }

    public Optional<MenuOption> getMenuOptionById(int id) {
        return Optional.ofNullable(options.get(id));
    }
}
