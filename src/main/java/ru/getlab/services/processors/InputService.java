package ru.getlab.services.processors;

/**
 * This interface defines behaviour to make some information from user.
 */
public interface InputService {
    int readInt();

    String readStringWithPrompt(String prompt);
}
