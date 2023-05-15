package ru.getlab.exceptions;

public class MenuCommandProcessorNotFound extends RuntimeException {
    public MenuCommandProcessorNotFound(String message) {
        super(message);
    }
}
